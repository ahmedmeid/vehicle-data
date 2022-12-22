package com.ahmedmeid.fleet.service.dto.subscription;

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
@JsonPropertyOrder({ "Content-Type", "Authorization" })
@Generated("jsonschema2pojo")
public class Headers {

    @JsonProperty("Content-Type")
    private String contentType;

    @JsonProperty("Authorization")
    private String authorization;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("Content-Type")
    public String getContentType() {
        return contentType;
    }

    @JsonProperty("Content-Type")
    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public Headers withContentType(String contentType) {
        this.contentType = contentType;
        return this;
    }

    @JsonProperty("Authorization")
    public String getAuthorization() {
        return authorization;
    }

    @JsonProperty("Authorization")
    public void setAuthorization(String authorization) {
        this.authorization = authorization;
    }

    public Headers withAuthorization(String authorization) {
        this.authorization = authorization;
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

    public Headers withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Headers.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("contentType");
        sb.append('=');
        sb.append(((this.contentType == null) ? "<null>" : this.contentType));
        sb.append(',');
        sb.append("authorization");
        sb.append('=');
        sb.append(((this.authorization == null) ? "<null>" : this.authorization));
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
        result = ((result * 31) + ((this.authorization == null) ? 0 : this.authorization.hashCode()));
        result = ((result * 31) + ((this.additionalProperties == null) ? 0 : this.additionalProperties.hashCode()));
        result = ((result * 31) + ((this.contentType == null) ? 0 : this.contentType.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Headers) == false) {
            return false;
        }
        Headers rhs = ((Headers) other);
        return (
            (
                (
                    (this.authorization == rhs.authorization) ||
                    ((this.authorization != null) && this.authorization.equals(rhs.authorization))
                ) &&
                (
                    (this.additionalProperties == rhs.additionalProperties) ||
                    ((this.additionalProperties != null) && this.additionalProperties.equals(rhs.additionalProperties))
                )
            ) &&
            ((this.contentType == rhs.contentType) || ((this.contentType != null) && this.contentType.equals(rhs.contentType)))
        );
    }
}
