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
@JsonPropertyOrder({ "httpCustom" })
@Generated("jsonschema2pojo")
public class Notification {

    @JsonProperty("httpCustom")
    private HttpCustom httpCustom;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("httpCustom")
    public HttpCustom getHttpCustom() {
        return httpCustom;
    }

    @JsonProperty("httpCustom")
    public void setHttpCustom(HttpCustom httpCustom) {
        this.httpCustom = httpCustom;
    }

    public Notification withHttpCustom(HttpCustom httpCustom) {
        this.httpCustom = httpCustom;
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

    public Notification withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Notification.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("httpCustom");
        sb.append('=');
        sb.append(((this.httpCustom == null) ? "<null>" : this.httpCustom));
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
        result = ((result * 31) + ((this.httpCustom == null) ? 0 : this.httpCustom.hashCode()));
        result = ((result * 31) + ((this.additionalProperties == null) ? 0 : this.additionalProperties.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Notification) == false) {
            return false;
        }
        Notification rhs = ((Notification) other);
        return (
            ((this.httpCustom == rhs.httpCustom) || ((this.httpCustom != null) && this.httpCustom.equals(rhs.httpCustom))) &&
            (
                (this.additionalProperties == rhs.additionalProperties) ||
                ((this.additionalProperties != null) && this.additionalProperties.equals(rhs.additionalProperties))
            )
        );
    }
}
