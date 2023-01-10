package com.ahmedmeid.fleet.service;

import com.ahmedmeid.fleet.service.dto.TokenEntity;
import com.ahmedmeid.fleet.service.dto.VehicleDTO;
import com.ahmedmeid.fleet.service.dto.device.Device;
import com.ahmedmeid.fleet.service.dto.device.ProvisionDevice;
import com.ahmedmeid.fleet.service.dto.device.StaticAttribute;
import com.ahmedmeid.fleet.service.dto.entity.Attribute;
import com.ahmedmeid.fleet.service.dto.entity.CreateEntity;
import com.ahmedmeid.fleet.service.dto.entity.RegNo;
import com.ahmedmeid.fleet.service.dto.entity.Vin;
import com.ahmedmeid.fleet.service.dto.servicegroup.ServiceGroup;
import com.ahmedmeid.fleet.service.dto.subscription.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.function.Consumer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.http.*;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service
public class FiwareService {

    private final Logger log = LoggerFactory.getLogger(FiwareService.class);
    private RestTemplate restTemplate;

    @Value("${fiware.orion.server-uri}")
    private String OrionURL;

    @Value("${fiware.iot-agent.server-uri}")
    private String IotAgentURL;

    @Value("${fiware.notification-service.url}")
    private String notificationServiceURL;

    @Value("${fiware.orion.client-id}")
    private String orionClientId;

    @Value("${fiware.orion.client-secret}")
    private String orionClientSecret;

    @Value("${keycloak.token-service.url}")
    private String keycloakTokenServiceURL;

    public static String GRANT_TYPE = "client_credentials";

    public FiwareService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Bean
    Consumer<Message<VehicleDTO>> consumer() {
        return message -> {
            VehicleDTO vehicle = message.getPayload();
            try {
                createEntityOnOrion(vehicle);
                provisionDeviceOnIoTAgent(vehicle);
            } catch (Exception ex) {
                log.error(ex.getMessage(), ex);
            }
        };
    }

    /**
     *  Create a vehicle entity in the Orion Context Broker
     * @param vehicle
     * @throws URISyntaxException
     */
    public void createEntityOnOrion(VehicleDTO vehicle) throws URISyntaxException {
        log.debug("creating entity for vehicle:" + vehicle + " in the Orion context broker at: " + OrionURL);

        CreateEntity dto = new CreateEntity()
            .withId("urn:ngsi-ld:Vehicle:" + vehicle.getVehicleId())
            .withType("vehicle")
            .withVin(new Vin().withType("Text").withValue(vehicle.getVehicleId()))
            .withRegNo(new RegNo().withType("Text").withValue(vehicle.getVehicleRegNo()));

        URI uri = new URI(OrionURL + "/v2/entities");
        restTemplate.postForLocation(uri, dto);
    }

    /**
     * Provision an IoT Device for the vehicle on the IoT Agent
     * @param vehicle
     * @throws URISyntaxException
     */
    public void provisionDeviceOnIoTAgent(VehicleDTO vehicle) throws URISyntaxException {
        log.debug("provisioning of a device for the vehicle: " + vehicle + " in the IoT Agent");
        HttpHeaders headers = getIoTServiceHeaders();
        URI uri = new URI(IotAgentURL + "/iot/devices");
        Attribute attr1 = new Attribute().withObjectId("f").withName("fuelLevel").withType("Inetger");
        Attribute attr2 = new Attribute().withObjectId("v").withName("speed").withType("Inetger");
        Attribute attr3 = new Attribute().withObjectId("l").withName("location").withType("geo:json");
        ArrayList<Attribute> attributes = new ArrayList<>();
        attributes.add(attr1);
        attributes.add(attr2);
        attributes.add(attr3);
        StaticAttribute sattr = new StaticAttribute()
            .withName("refVehicle")
            .withType("Relationship")
            .withValue("urn:ngsi-ld:Vehicle:" + vehicle.getVehicleId());
        List<StaticAttribute> staticAttributes = new ArrayList<>();
        staticAttributes.add(sattr);
        Device device = new Device()
            .withDeviceId(vehicle.getDeviceId())
            .withEntityName("urn:ngsi-ld:IoTDevice:" + vehicle.getDeviceId())
            .withEntityType("IoTDevice")
            .withProtocol("PDI-IoTA-UltraLight")
            .withTransport("MQTT")
            .withTimezone("Asia/Riyadh")
            .withAttributes(attributes)
            .withStaticAttributes(staticAttributes);
        ArrayList<Device> devices = new ArrayList<>();
        devices.add(device);
        ProvisionDevice dto = new ProvisionDevice().withDevices(devices);
        HttpEntity<ProvisionDevice> requestEntity = new HttpEntity<>(dto, headers);
        restTemplate.postForLocation(uri, requestEntity);
    }

    /**
     * Subscribe to changes of state for the IoT Device Entity
     * @throws URISyntaxException
     */
    public String subscribeIoTDeviceChanges(String deviceId) throws URISyntaxException {
        log.debug("subscribing to changes in the entities of IoTDevice");
        HttpHeaders requestHeaders = getIoTServiceHeaders();
        String token = authenticateForOrion();
        Entity entity = new Entity().withIdPattern(deviceId).withType("IoTDevice");
        List<Entity> entities = new ArrayList<>();
        entities.add(entity);
        Condition condition = new Condition().withAttrs(Arrays.asList("location"));
        Subject subject = new Subject().withEntities(entities).withCondition(condition);

        Headers headers = new Headers().withContentType("application/json").withAuthorization("Bearer " + token);
        HttpCustom httpCustom = new HttpCustom().withUrl(notificationServiceURL).withHeaders(headers);
        Notification notification = new Notification().withHttpCustom(httpCustom);
        Calendar time = Calendar.getInstance();
        time.add(Calendar.MINUTE, 5);
        TimeZone tz = TimeZone.getTimeZone("UTC");
        DateFormat df = new SimpleDateFormat("yyy-MM-dd'T'HH:mm:ss'Z'");
        df.setTimeZone(tz);
        String expires = df.format(time.getTime());
        SubscribeToChanges dto = new SubscribeToChanges()
            .withDescription("Notify me of all IoTDevice state changes")
            .withSubject(subject)
            .withNotification(notification)
            .withExpires(expires);

        URI uri = new URI(OrionURL + "/v2/subscriptions");
        HttpEntity<SubscribeToChanges> requestEntity = new HttpEntity<>(dto, requestHeaders);
        URI location = restTemplate.postForLocation(uri, requestEntity);
        Pattern pattern = Pattern.compile("/v2/subscriptions/(.*)");
        Matcher matcher = pattern.matcher(location.toString());
        matcher.find();
        return matcher.group(1);
    }

    private String authenticateForOrion() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("client_id", orionClientId);
        map.add("client_secret", orionClientSecret);
        map.add("grant_type", GRANT_TYPE);

        HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(map, headers);

        ResponseEntity<TokenEntity> response = restTemplate.postForEntity(keycloakTokenServiceURL, entity, TokenEntity.class);
        return response.getBody().getAccessToken();
    }

    public void provisionServiceGroup(String apiKey) {
        HttpHeaders headers = getIoTServiceHeaders();
        com.ahmedmeid.fleet.service.dto.servicegroup.Service service = new com.ahmedmeid.fleet.service.dto.servicegroup.Service()
            .withApikey(apiKey)
            .withCbroker("http://orion:1026")
            .withEntityType("Thing")
            .withResource("");
        List<com.ahmedmeid.fleet.service.dto.servicegroup.Service> services = new ArrayList<>();
        services.add(service);
        ServiceGroup serviceGroup = new ServiceGroup().withServices(services);
        HttpEntity<ServiceGroup> requestEntity = new HttpEntity<>(serviceGroup, headers);
        restTemplate.postForLocation(IotAgentURL + "/iot/services", requestEntity);
    }

    private HttpHeaders getIoTServiceHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("fiware-service", "openiot");
        headers.set("fiware-servicepath", "/");
        return headers;
    }
}
