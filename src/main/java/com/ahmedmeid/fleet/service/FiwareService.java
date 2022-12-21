package com.ahmedmeid.fleet.service;

import com.ahmedmeid.fleet.config.KafkaSseConsumer;
import com.ahmedmeid.fleet.service.dto.Attribute;
import com.ahmedmeid.fleet.service.dto.Condition;
import com.ahmedmeid.fleet.service.dto.CreateEntity;
import com.ahmedmeid.fleet.service.dto.Device;
import com.ahmedmeid.fleet.service.dto.Entity;
import com.ahmedmeid.fleet.service.dto.Http;
import com.ahmedmeid.fleet.service.dto.Notification;
import com.ahmedmeid.fleet.service.dto.ProvisionDevice;
import com.ahmedmeid.fleet.service.dto.RegNo;
import com.ahmedmeid.fleet.service.dto.StaticAttribute;
import com.ahmedmeid.fleet.service.dto.Subject;
import com.ahmedmeid.fleet.service.dto.SubscribeToChanges;
import com.ahmedmeid.fleet.service.dto.VehicleDTO;
import com.ahmedmeid.fleet.service.dto.Vin;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;
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

    public FiwareService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    //TODO: replace deprecated API calls to functional model
    @StreamListener(value = KafkaSseConsumer.CHANNELNAME, copyHeaders = "false")
    public void consumeVehicleCreatedEventMessage(Message<VehicleDTO> message) {
        VehicleDTO vehicle = message.getPayload();
        try {
            createEntityOnOrion(vehicle);
            provisionDeviceOnIoTAgent(vehicle);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
        }
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
        restTemplate.postForEntity(uri, dto, CreateEntity.class);
    }

    /**
     * Provision an IoT Device for the vehicle on the IoT Agent
     * @param vehicle
     * @throws URISyntaxException
     */
    public void provisionDeviceOnIoTAgent(VehicleDTO vehicle) throws URISyntaxException {
        log.debug("provisioning of a device for the vehicle: " + vehicle + " in the IoT Agent");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("fiware-service", "openiot");
        headers.set("fiware-servicepath", "/");
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
        restTemplate.postForEntity(uri, requestEntity, ProvisionDevice.class);
    }

    /**
     * Subscribe to changes of state for the IoT Device Entity
     * @throws URISyntaxException
     */
    public void subscribeIoTDeviceChanges() throws URISyntaxException {
        log.debug("subscribing to changes in the entities of IoTDevice");

        Entity entity = new Entity().withIdPattern(".*").withType("IoTDevice");
        List<Entity> entities = new ArrayList<>();
        entities.add(entity);
        Condition condition = new Condition().withAttrs(Arrays.asList("location"));
        Subject subject = new Subject().withEntities(entities).withCondition(condition);
        Http http = new Http().withUrl(notificationServiceURL);
        Notification notification = new Notification().withHttp(http);
        SubscribeToChanges dto = new SubscribeToChanges()
            .withDescription("Notify me of all IoTDevice state changes")
            .withSubject(subject)
            .withNotification(notification);

        URI uri = new URI(OrionURL + "/v2/subscriptions");
        restTemplate.postForEntity(uri, dto, SubscribeToChanges.class);
    }
}
