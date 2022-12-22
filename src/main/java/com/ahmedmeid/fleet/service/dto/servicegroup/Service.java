package com.ahmedmeid.fleet.service.dto.servicegroup;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.processing.Generated;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "apikey", "cbroker", "entity_type", "resource" })
@Generated("jsonschema2pojo")
public class Service {

    @JsonProperty("apikey")
    private String apikey;

    @JsonProperty("cbroker")
    private String cbroker;

    @JsonProperty("entity_type")
    private String entityType;

    @JsonProperty("resource")
    private String resource;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("apikey")
    public String getApikey() {
        return apikey;
    }

    @JsonProperty("apikey")
    public void setApikey(String apikey) {
        this.apikey = apikey;
    }

    public Service withApikey(String apikey) {
        this.apikey = apikey;
        return this;
    }

    @JsonProperty("cbroker")
    public String getCbroker() {
        return cbroker;
    }

    @JsonProperty("cbroker")
    public void setCbroker(String cbroker) {
        this.cbroker = cbroker;
    }

    public Service withCbroker(String cbroker) {
        this.cbroker = cbroker;
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

    public Service withEntityType(String entityType) {
        this.entityType = entityType;
        return this;
    }

    @JsonProperty("resource")
    public String getResource() {
        return resource;
    }

    @JsonProperty("resource")
    public void setResource(String resource) {
        this.resource = resource;
    }

    public Service withResource(String resource) {
        this.resource = resource;
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

    public Service withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Service.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("apikey");
        sb.append('=');
        sb.append(((this.apikey == null) ? "<null>" : this.apikey));
        sb.append(',');
        sb.append("cbroker");
        sb.append('=');
        sb.append(((this.cbroker == null) ? "<null>" : this.cbroker));
        sb.append(',');
        sb.append("entityType");
        sb.append('=');
        sb.append(((this.entityType == null) ? "<null>" : this.entityType));
        sb.append(',');
        sb.append("resource");
        sb.append('=');
        sb.append(((this.resource == null) ? "<null>" : this.resource));
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
        result = ((result * 31) + ((this.cbroker == null) ? 0 : this.cbroker.hashCode()));
        result = ((result * 31) + ((this.additionalProperties == null) ? 0 : this.additionalProperties.hashCode()));
        result = ((result * 31) + ((this.apikey == null) ? 0 : this.apikey.hashCode()));
        result = ((result * 31) + ((this.resource == null) ? 0 : this.resource.hashCode()));
        result = ((result * 31) + ((this.entityType == null) ? 0 : this.entityType.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Service) == false) {
            return false;
        }
        Service rhs = ((Service) other);
        return (
            (
                (
                    (
                        ((this.cbroker == rhs.cbroker) || ((this.cbroker != null) && this.cbroker.equals(rhs.cbroker))) &&
                        (
                            (this.additionalProperties == rhs.additionalProperties) ||
                            ((this.additionalProperties != null) && this.additionalProperties.equals(rhs.additionalProperties))
                        )
                    ) &&
                    ((this.apikey == rhs.apikey) || ((this.apikey != null) && this.apikey.equals(rhs.apikey)))
                ) &&
                ((this.resource == rhs.resource) || ((this.resource != null) && this.resource.equals(rhs.resource)))
            ) &&
            ((this.entityType == rhs.entityType) || ((this.entityType != null) && this.entityType.equals(rhs.entityType)))
        );
    }
}
