package com.ahmedmeid.fleet.service.dto.entity;

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
@JsonPropertyOrder({ "id", "type", "vin", "regNo" })
@Generated("jsonschema2pojo")
public class CreateEntity {

    @JsonProperty("id")
    private String id;

    @JsonProperty("type")
    private String type;

    @JsonProperty("vin")
    private Vin vin;

    @JsonProperty("regNo")
    private RegNo regNo;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    public CreateEntity withId(String id) {
        this.id = id;
        return this;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    public CreateEntity withType(String type) {
        this.type = type;
        return this;
    }

    @JsonProperty("vin")
    public Vin getVin() {
        return vin;
    }

    @JsonProperty("vin")
    public void setVin(Vin vin) {
        this.vin = vin;
    }

    public CreateEntity withVin(Vin vin) {
        this.vin = vin;
        return this;
    }

    @JsonProperty("regNo")
    public RegNo getRegNo() {
        return regNo;
    }

    @JsonProperty("regNo")
    public void setRegNo(RegNo regNo) {
        this.regNo = regNo;
    }

    public CreateEntity withRegNo(RegNo regNo) {
        this.regNo = regNo;
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

    public CreateEntity withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(CreateEntity.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("id");
        sb.append('=');
        sb.append(((this.id == null) ? "<null>" : this.id));
        sb.append(',');
        sb.append("type");
        sb.append('=');
        sb.append(((this.type == null) ? "<null>" : this.type));
        sb.append(',');
        sb.append("vin");
        sb.append('=');
        sb.append(((this.vin == null) ? "<null>" : this.vin));
        sb.append(',');
        sb.append("regNo");
        sb.append('=');
        sb.append(((this.regNo == null) ? "<null>" : this.regNo));
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
        result = ((result * 31) + ((this.regNo == null) ? 0 : this.regNo.hashCode()));
        result = ((result * 31) + ((this.vin == null) ? 0 : this.vin.hashCode()));
        result = ((result * 31) + ((this.id == null) ? 0 : this.id.hashCode()));
        result = ((result * 31) + ((this.additionalProperties == null) ? 0 : this.additionalProperties.hashCode()));
        result = ((result * 31) + ((this.type == null) ? 0 : this.type.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof CreateEntity) == false) {
            return false;
        }
        CreateEntity rhs = ((CreateEntity) other);
        return (
            (
                (
                    (
                        ((this.regNo == rhs.regNo) || ((this.regNo != null) && this.regNo.equals(rhs.regNo))) &&
                        ((this.vin == rhs.vin) || ((this.vin != null) && this.vin.equals(rhs.vin)))
                    ) &&
                    ((this.id == rhs.id) || ((this.id != null) && this.id.equals(rhs.id)))
                ) &&
                (
                    (this.additionalProperties == rhs.additionalProperties) ||
                    ((this.additionalProperties != null) && this.additionalProperties.equals(rhs.additionalProperties))
                )
            ) &&
            ((this.type == rhs.type) || ((this.type != null) && this.type.equals(rhs.type)))
        );
    }
}
