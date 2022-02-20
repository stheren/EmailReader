package com.stheren.email_reader.engine.data;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.JsonNode;

import javax.annotation.processing.Generated;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "name",
    "_id",
    "reference",
    "version"
})
@Generated("jsonschema2pojo")
public class Extention {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("name")
    private String name;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("_id")
    private UUID id;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("reference")
    private JsonNode reference;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("version")
    private String version;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Extention() {
    }

    /**
     * 
     * @param reference
     * @param name
     * @param id
     * @param version
     */
    public Extention(String name, UUID id, JsonNode reference, String version) {
        super();
        this.name = name;
        this.id = id;
        this.reference = reference;
        this.version = version;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("_id")
    public UUID getId() {
        return id;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("_id")
    public void setId(UUID id) {
        this.id = id;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("reference")
    public JsonNode getReference() {
        return reference;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("reference")
    public void setReference(JsonNode reference) {
        this.reference = reference;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("version")
    public String getVersion() {
        return version;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("version")
    public void setVersion(String version) {
        this.version = version;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
