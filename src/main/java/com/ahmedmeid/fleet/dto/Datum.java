package com.ahmedmeid.fleet.dto;

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
@JsonPropertyOrder({ "id", "type", "TimeInstant", "fuelLevel", "location", "refVehicle", "speed" })
@Generated("jsonschema2pojo")
public class Datum {

    @JsonProperty("id")
    private String id;

    @JsonProperty("type")
    private String type;

    @JsonProperty("TimeInstant")
    private TimeInstant timeInstant;

    @JsonProperty("fuelLevel")
    private FuelLevel fuelLevel;

    @JsonProperty("location")
    private Location location;

    @JsonProperty("refVehicle")
    private RefVehicle refVehicle;

    @JsonProperty("speed")
    private Speed speed;

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

    public Datum withId(String id) {
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

    public Datum withType(String type) {
        this.type = type;
        return this;
    }

    @JsonProperty("TimeInstant")
    public TimeInstant getTimeInstant() {
        return timeInstant;
    }

    @JsonProperty("TimeInstant")
    public void setTimeInstant(TimeInstant timeInstant) {
        this.timeInstant = timeInstant;
    }

    public Datum withTimeInstant(TimeInstant timeInstant) {
        this.timeInstant = timeInstant;
        return this;
    }

    @JsonProperty("fuelLevel")
    public FuelLevel getFuelLevel() {
        return fuelLevel;
    }

    @JsonProperty("fuelLevel")
    public void setFuelLevel(FuelLevel fuelLevel) {
        this.fuelLevel = fuelLevel;
    }

    public Datum withFuelLevel(FuelLevel fuelLevel) {
        this.fuelLevel = fuelLevel;
        return this;
    }

    @JsonProperty("location")
    public Location getLocation() {
        return location;
    }

    @JsonProperty("location")
    public void setLocation(Location location) {
        this.location = location;
    }

    public Datum withLocation(Location location) {
        this.location = location;
        return this;
    }

    @JsonProperty("refVehicle")
    public RefVehicle getRefVehicle() {
        return refVehicle;
    }

    @JsonProperty("refVehicle")
    public void setRefVehicle(RefVehicle refVehicle) {
        this.refVehicle = refVehicle;
    }

    public Datum withRefVehicle(RefVehicle refVehicle) {
        this.refVehicle = refVehicle;
        return this;
    }

    @JsonProperty("speed")
    public Speed getSpeed() {
        return speed;
    }

    @JsonProperty("speed")
    public void setSpeed(Speed speed) {
        this.speed = speed;
    }

    public Datum withSpeed(Speed speed) {
        this.speed = speed;
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

    public Datum withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Datum.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("id");
        sb.append('=');
        sb.append(((this.id == null) ? "<null>" : this.id));
        sb.append(',');
        sb.append("type");
        sb.append('=');
        sb.append(((this.type == null) ? "<null>" : this.type));
        sb.append(',');
        sb.append("timeInstant");
        sb.append('=');
        sb.append(((this.timeInstant == null) ? "<null>" : this.timeInstant));
        sb.append(',');
        sb.append("fuelLevel");
        sb.append('=');
        sb.append(((this.fuelLevel == null) ? "<null>" : this.fuelLevel));
        sb.append(',');
        sb.append("location");
        sb.append('=');
        sb.append(((this.location == null) ? "<null>" : this.location));
        sb.append(',');
        sb.append("refVehicle");
        sb.append('=');
        sb.append(((this.refVehicle == null) ? "<null>" : this.refVehicle));
        sb.append(',');
        sb.append("speed");
        sb.append('=');
        sb.append(((this.speed == null) ? "<null>" : this.speed));
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
        result = ((result * 31) + ((this.refVehicle == null) ? 0 : this.refVehicle.hashCode()));
        result = ((result * 31) + ((this.fuelLevel == null) ? 0 : this.fuelLevel.hashCode()));
        result = ((result * 31) + ((this.timeInstant == null) ? 0 : this.timeInstant.hashCode()));
        result = ((result * 31) + ((this.location == null) ? 0 : this.location.hashCode()));
        result = ((result * 31) + ((this.id == null) ? 0 : this.id.hashCode()));
        result = ((result * 31) + ((this.additionalProperties == null) ? 0 : this.additionalProperties.hashCode()));
        result = ((result * 31) + ((this.type == null) ? 0 : this.type.hashCode()));
        result = ((result * 31) + ((this.speed == null) ? 0 : this.speed.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Datum) == false) {
            return false;
        }
        Datum rhs = ((Datum) other);
        return (
            (
                (
                    (
                        (
                            (
                                (
                                    (
                                        (this.refVehicle == rhs.refVehicle) ||
                                        ((this.refVehicle != null) && this.refVehicle.equals(rhs.refVehicle))
                                    ) &&
                                    (
                                        (this.fuelLevel == rhs.fuelLevel) ||
                                        ((this.fuelLevel != null) && this.fuelLevel.equals(rhs.fuelLevel))
                                    )
                                ) &&
                                (
                                    (this.timeInstant == rhs.timeInstant) ||
                                    ((this.timeInstant != null) && this.timeInstant.equals(rhs.timeInstant))
                                )
                            ) &&
                            ((this.location == rhs.location) || ((this.location != null) && this.location.equals(rhs.location)))
                        ) &&
                        ((this.id == rhs.id) || ((this.id != null) && this.id.equals(rhs.id)))
                    ) &&
                    (
                        (this.additionalProperties == rhs.additionalProperties) ||
                        ((this.additionalProperties != null) && this.additionalProperties.equals(rhs.additionalProperties))
                    )
                ) &&
                ((this.type == rhs.type) || ((this.type != null) && this.type.equals(rhs.type)))
            ) &&
            ((this.speed == rhs.speed) || ((this.speed != null) && this.speed.equals(rhs.speed)))
        );
    }
}
