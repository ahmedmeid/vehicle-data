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
@JsonPropertyOrder({ "description", "subject", "notification", "expires" })
@Generated("jsonschema2pojo")
public class SubscribeToChanges {

    @JsonProperty("description")
    private String description;

    @JsonProperty("subject")
    private Subject subject;

    @JsonProperty("notification")
    private Notification notification;

    @JsonProperty("expires")
    private String expires;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    public SubscribeToChanges withDescription(String description) {
        this.description = description;
        return this;
    }

    @JsonProperty("subject")
    public Subject getSubject() {
        return subject;
    }

    @JsonProperty("subject")
    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public SubscribeToChanges withSubject(Subject subject) {
        this.subject = subject;
        return this;
    }

    @JsonProperty("notification")
    public Notification getNotification() {
        return notification;
    }

    @JsonProperty("notification")
    public void setNotification(Notification notification) {
        this.notification = notification;
    }

    public SubscribeToChanges withNotification(Notification notification) {
        this.notification = notification;
        return this;
    }

    @JsonProperty("expires")
    public String getExpires() {
        return expires;
    }

    @JsonProperty("expires")
    public void setExpires(String expires) {
        this.expires = expires;
    }

    public SubscribeToChanges withExpires(String expires) {
        this.expires = expires;
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

    public SubscribeToChanges withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(SubscribeToChanges.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("description");
        sb.append('=');
        sb.append(((this.description == null) ? "<null>" : this.description));
        sb.append(',');
        sb.append("subject");
        sb.append('=');
        sb.append(((this.subject == null) ? "<null>" : this.subject));
        sb.append(',');
        sb.append("notification");
        sb.append('=');
        sb.append(((this.notification == null) ? "<null>" : this.notification));
        sb.append(',');
        sb.append("expires");
        sb.append('=');
        sb.append(((this.expires == null) ? "<null>" : this.expires));
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
        result = ((result * 31) + ((this.description == null) ? 0 : this.description.hashCode()));
        result = ((result * 31) + ((this.notification == null) ? 0 : this.notification.hashCode()));
        result = ((result * 31) + ((this.expires == null) ? 0 : this.expires.hashCode()));
        result = ((result * 31) + ((this.additionalProperties == null) ? 0 : this.additionalProperties.hashCode()));
        result = ((result * 31) + ((this.subject == null) ? 0 : this.subject.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof SubscribeToChanges) == false) {
            return false;
        }
        SubscribeToChanges rhs = ((SubscribeToChanges) other);
        return (
            (
                (
                    (
                        (
                            (this.description == rhs.description) ||
                            ((this.description != null) && this.description.equals(rhs.description))
                        ) &&
                        (
                            (this.notification == rhs.notification) ||
                            ((this.notification != null) && this.notification.equals(rhs.notification))
                        )
                    ) &&
                    ((this.expires == rhs.expires) || ((this.expires != null) && this.expires.equals(rhs.expires)))
                ) &&
                (
                    (this.additionalProperties == rhs.additionalProperties) ||
                    ((this.additionalProperties != null) && this.additionalProperties.equals(rhs.additionalProperties))
                )
            ) &&
            ((this.subject == rhs.subject) || ((this.subject != null) && this.subject.equals(rhs.subject)))
        );
    }
}
