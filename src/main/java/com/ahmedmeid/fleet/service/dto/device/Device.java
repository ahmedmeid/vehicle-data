package com.ahmedmeid.fleet.service.dto.device;

import com.ahmedmeid.fleet.service.dto.entity.Attribute;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.processing.Generated;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "device_id", "entity_name", "entity_type", "protocol", "transport", "timezone", "attributes", "static_attributes" })
@Generated("jsonschema2pojo")
public class Device {

    @JsonProperty("device_id")
    private String deviceId;

    @JsonProperty("entity_name")
    private String entityName;

    @JsonProperty("entity_type")
    private String entityType;

    @JsonProperty("protocol")
    private String protocol;

    @JsonProperty("transport")
    private String transport;

    @JsonProperty("timezone")
    private String timezone;

    @JsonProperty("attributes")
    private List<Attribute> attributes = new ArrayList<Attribute>();

    @JsonProperty("static_attributes")
    private List<StaticAttribute> staticAttributes = new ArrayList<StaticAttribute>();

    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("device_id")
    public String getDeviceId() {
        return deviceId;
    }

    @JsonProperty("device_id")
    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public Device withDeviceId(String deviceId) {
        this.deviceId = deviceId;
        return this;
    }

    @JsonProperty("entity_name")
    public String getEntityName() {
        return entityName;
    }

    @JsonProperty("entity_name")
    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    public Device withEntityName(String entityName) {
        this.entityName = entityName;
        return this;
    }

    @JsonProperty("entity_type")
    public String getEntityType() {
        return entityType;
    }

    @JsonProperty("entity_type")
    public void setEntityType(String entityType) {
        this.entityType = entityType;
    }

    public Device withEntityType(String entityType) {
        this.entityType = entityType;
        return this;
    }

    @JsonProperty("protocol")
    public String getProtocol() {
        return protocol;
    }

    @JsonProperty("protocol")
    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public Device withProtocol(String protocol) {
        this.protocol = protocol;
        return this;
    }

    @JsonProperty("transport")
    public String getTransport() {
        return transport;
    }

    @JsonProperty("transport")
    public void setTransport(String transport) {
        this.transport = transport;
    }

    public Device withTransport(String transport) {
        this.transport = transport;
        return this;
    }

    @JsonProperty("timezone")
    public String getTimezone() {
        return timezone;
    }

    @JsonProperty("timezone")
    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public Device withTimezone(String timezone) {
        this.timezone = timezone;
        return this;
    }

    @JsonProperty("attributes")
    public List<Attribute> getAttributes() {
        return attributes;
    }

    @JsonProperty("attributes")
    public void setAttributes(List<Attribute> attributes) {
        this.attributes = attributes;
    }

    public Device withAttributes(List<Attribute> attributes) {
        this.attributes = attributes;
        return this;
    }

    @JsonProperty("static_attributes")
    public List<StaticAttribute> getStaticAttributes() {
        return staticAttributes;
    }

    @JsonProperty("static_attributes")
    public void setStaticAttributes(List<StaticAttribute> staticAttributes) {
        this.staticAttributes = staticAttributes;
    }

    public Device withStaticAttributes(List<StaticAttribute> staticAttributes) {
        this.staticAttributes = staticAttributes;
        return this;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public Device withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Device.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("deviceId");
        sb.append('=');
        sb.append(((this.deviceId == null) ? "<null>" : this.deviceId));
        sb.append(',');
        sb.append("entityName");
        sb.append('=');
        sb.append(((this.entityName == null) ? "<null>" : this.entityName));
        sb.append(',');
        sb.append("entityType");
        sb.append('=');
        sb.append(((this.entityType == null) ? "<null>" : this.entityType));
        sb.append(',');
        sb.append("protocol");
        sb.append('=');
        sb.append(((this.protocol == null) ? "<null>" : this.protocol));
        sb.append(',');
        sb.append("transport");
        sb.append('=');
        sb.append(((this.transport == null) ? "<null>" : this.transport));
        sb.append(',');
        sb.append("timezone");
        sb.append('=');
        sb.append(((this.timezone == null) ? "<null>" : this.timezone));
        sb.append(',');
        sb.append("attributes");
        sb.append('=');
        sb.append(((this.attributes == null) ? "<null>" : this.attributes));
        sb.append(',');
        sb.append("staticAttributes");
        sb.append('=');
        sb.append(((this.staticAttributes == null) ? "<null>" : this.staticAttributes));
        sb.append(',');
        sb.append("additionalProperties");
        sb.append('=');
        sb.append(((this.additionalProperties == null) ? "<null>" : this.additionalProperties));
        sb.append(',');
        if (sb.charAt((sb.length() - 1)) == ',') {
            sb.setCharAt((sb.length() - 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result * 31) + ((this.protocol == null) ? 0 : this.protocol.hashCode()));
        result = ((result * 31) + ((this.entityName == null) ? 0 : this.entityName.hashCode()));
        result = ((result * 31) + ((this.entityType == null) ? 0 : this.entityType.hashCode()));
        result = ((result * 31) + ((this.timezone == null) ? 0 : this.timezone.hashCode()));
        result = ((result * 31) + ((this.attributes == null) ? 0 : this.attributes.hashCode()));
        result = ((result * 31) + ((this.transport == null) ? 0 : this.transport.hashCode()));
        result = ((result * 31) + ((this.additionalProperties == null) ? 0 : this.additionalProperties.hashCode()));
        result = ((result * 31) + ((this.deviceId == null) ? 0 : this.deviceId.hashCode()));
        result = ((result * 31) + ((this.staticAttributes == null) ? 0 : this.staticAttributes.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Device) == false) {
            return false;
        }
        Device rhs = ((Device) other);
        return (
            (
                (
                    (
                        (
                            (
                                (
                                    (
                                        (
                                            (this.protocol == rhs.protocol) ||
                                            ((this.protocol != null) && this.protocol.equals(rhs.protocol))
                                        ) &&
                                        (
                                            (this.entityName == rhs.entityName) ||
                                            ((this.entityName != null) && this.entityName.equals(rhs.entityName))
                                        )
                                    ) &&
                                    (
                                        (this.entityType == rhs.entityType) ||
                                        ((this.entityType != null) && this.entityType.equals(rhs.entityType))
                                    )
                                ) &&
                                ((this.timezone == rhs.timezone) || ((this.timezone != null) && this.timezone.equals(rhs.timezone)))
                            ) &&
                            ((this.attributes == rhs.attributes) || ((this.attributes != null) && this.attributes.equals(rhs.attributes)))
                        ) &&
                        ((this.transport == rhs.transport) || ((this.transport != null) && this.transport.equals(rhs.transport)))
                    ) &&
                    (
                        (this.additionalProperties == rhs.additionalProperties) ||
                        ((this.additionalProperties != null) && this.additionalProperties.equals(rhs.additionalProperties))
                    )
                ) &&
                ((this.deviceId == rhs.deviceId) || ((this.deviceId != null) && this.deviceId.equals(rhs.deviceId)))
            ) &&
            (
                (this.staticAttributes == rhs.staticAttributes) ||
                ((this.staticAttributes != null) && this.staticAttributes.equals(rhs.staticAttributes))
            )
        );
    }
}
