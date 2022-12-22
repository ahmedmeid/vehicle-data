package com.ahmedmeid.fleet.service.dto;

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
@JsonPropertyOrder({ "access_token", "expires_in", "refresh_expires_in", "token_type", "not-before-policy", "scope" })
@Generated("jsonschema2pojo")
public class TokenEntity {

    @JsonProperty("access_token")
    private String accessToken;

    @JsonProperty("expires_in")
    private Integer expiresIn;

    @JsonProperty("refresh_expires_in")
    private Integer refreshExpiresIn;

    @JsonProperty("token_type")
    private String tokenType;

    @JsonProperty("not-before-policy")
    private Integer notBeforePolicy;

    @JsonProperty("scope")
    private String scope;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("access_token")
    public String getAccessToken() {
        return accessToken;
    }

    @JsonProperty("access_token")
    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public TokenEntity withAccessToken(String accessToken) {
        this.accessToken = accessToken;
        return this;
    }

    @JsonProperty("expires_in")
    public Integer getExpiresIn() {
        return expiresIn;
    }

    @JsonProperty("expires_in")
    public void setExpiresIn(Integer expiresIn) {
        this.expiresIn = expiresIn;
    }

    public TokenEntity withExpiresIn(Integer expiresIn) {
        this.expiresIn = expiresIn;
        return this;
    }

    @JsonProperty("refresh_expires_in")
    public Integer getRefreshExpiresIn() {
        return refreshExpiresIn;
    }

    @JsonProperty("refresh_expires_in")
    public void setRefreshExpiresIn(Integer refreshExpiresIn) {
        this.refreshExpiresIn = refreshExpiresIn;
    }

    public TokenEntity withRefreshExpiresIn(Integer refreshExpiresIn) {
        this.refreshExpiresIn = refreshExpiresIn;
        return this;
    }

    @JsonProperty("token_type")
    public String getTokenType() {
        return tokenType;
    }

    @JsonProperty("token_type")
    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public TokenEntity withTokenType(String tokenType) {
        this.tokenType = tokenType;
        return this;
    }

    @JsonProperty("not-before-policy")
    public Integer getNotBeforePolicy() {
        return notBeforePolicy;
    }

    @JsonProperty("not-before-policy")
    public void setNotBeforePolicy(Integer notBeforePolicy) {
        this.notBeforePolicy = notBeforePolicy;
    }

    public TokenEntity withNotBeforePolicy(Integer notBeforePolicy) {
        this.notBeforePolicy = notBeforePolicy;
        return this;
    }

    @JsonProperty("scope")
    public String getScope() {
        return scope;
    }

    @JsonProperty("scope")
    public void setScope(String scope) {
        this.scope = scope;
    }

    public TokenEntity withScope(String scope) {
        this.scope = scope;
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

    public TokenEntity withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(TokenEntity.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("accessToken");
        sb.append('=');
        sb.append(((this.accessToken == null) ? "<null>" : this.accessToken));
        sb.append(',');
        sb.append("expiresIn");
        sb.append('=');
        sb.append(((this.expiresIn == null) ? "<null>" : this.expiresIn));
        sb.append(',');
        sb.append("refreshExpiresIn");
        sb.append('=');
        sb.append(((this.refreshExpiresIn == null) ? "<null>" : this.refreshExpiresIn));
        sb.append(',');
        sb.append("tokenType");
        sb.append('=');
        sb.append(((this.tokenType == null) ? "<null>" : this.tokenType));
        sb.append(',');
        sb.append("notBeforePolicy");
        sb.append('=');
        sb.append(((this.notBeforePolicy == null) ? "<null>" : this.notBeforePolicy));
        sb.append(',');
        sb.append("scope");
        sb.append('=');
        sb.append(((this.scope == null) ? "<null>" : this.scope));
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
        result = ((result * 31) + ((this.expiresIn == null) ? 0 : this.expiresIn.hashCode()));
        result = ((result * 31) + ((this.notBeforePolicy == null) ? 0 : this.notBeforePolicy.hashCode()));
        result = ((result * 31) + ((this.scope == null) ? 0 : this.scope.hashCode()));
        result = ((result * 31) + ((this.additionalProperties == null) ? 0 : this.additionalProperties.hashCode()));
        result = ((result * 31) + ((this.accessToken == null) ? 0 : this.accessToken.hashCode()));
        result = ((result * 31) + ((this.tokenType == null) ? 0 : this.tokenType.hashCode()));
        result = ((result * 31) + ((this.refreshExpiresIn == null) ? 0 : this.refreshExpiresIn.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof TokenEntity) == false) {
            return false;
        }
        TokenEntity rhs = ((TokenEntity) other);
        return (
            (
                (
                    (
                        (
                            (
                                ((this.expiresIn == rhs.expiresIn) || ((this.expiresIn != null) && this.expiresIn.equals(rhs.expiresIn))) &&
                                (
                                    (this.notBeforePolicy == rhs.notBeforePolicy) ||
                                    ((this.notBeforePolicy != null) && this.notBeforePolicy.equals(rhs.notBeforePolicy))
                                )
                            ) &&
                            ((this.scope == rhs.scope) || ((this.scope != null) && this.scope.equals(rhs.scope)))
                        ) &&
                        (
                            (this.additionalProperties == rhs.additionalProperties) ||
                            ((this.additionalProperties != null) && this.additionalProperties.equals(rhs.additionalProperties))
                        )
                    ) &&
                    ((this.accessToken == rhs.accessToken) || ((this.accessToken != null) && this.accessToken.equals(rhs.accessToken)))
                ) &&
                ((this.tokenType == rhs.tokenType) || ((this.tokenType != null) && this.tokenType.equals(rhs.tokenType)))
            ) &&
            (
                (this.refreshExpiresIn == rhs.refreshExpiresIn) ||
                ((this.refreshExpiresIn != null) && this.refreshExpiresIn.equals(rhs.refreshExpiresIn))
            )
        );
    }
}
