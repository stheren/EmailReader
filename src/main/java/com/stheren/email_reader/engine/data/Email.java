package com.stheren.email_reader.engine.data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.annotation.processing.Generated;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "_id",
    "metadata",
    "content",
    "history",
    "extentions"
})
@Generated("jsonschema2pojo")
public class Email {

    /**
     * uid RFC4122
     * (Required)
     * 
     */
    @JsonProperty("_id")
    @JsonPropertyDescription("uid RFC4122")
    private UUID id;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("metadata")
    private Metadata metadata;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("content")
    private String content;
    @JsonProperty("history")
    private UUID history;
    @JsonProperty("extentions")
    private List<Extention> extentions = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Email() {
    }

    /**
     * 
     * @param extentions
     * @param metadata
     * @param id
     * @param history
     * @param content
     */
    public Email(UUID id, Metadata metadata, String content, UUID history, List<Extention> extentions) {
        super();
        this.id = id;
        this.metadata = metadata;
        this.content = content;
        this.history = history;
        this.extentions = extentions;
    }

    /**
     * uid RFC4122
     * (Required)
     * 
     */
    @JsonProperty("_id")
    public UUID getId() {
        return id;
    }

    /**
     * uid RFC4122
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
    @JsonProperty("metadata")
    public Metadata getMetadata() {
        return metadata;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("metadata")
    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("content")
    public String getContent() {
        return content;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("content")
    public void setContent(String content) {
        this.content = content;
    }

    @JsonProperty("history")
    public UUID getHistory() {
        return history;
    }

    @JsonProperty("history")
    public void setHistory(UUID history) {
        this.history = history;
    }

    @JsonProperty("extentions")
    public List<Extention> getExtentions() {
        return extentions;
    }

    @JsonProperty("extentions")
    public void setExtentions(List<Extention> extentions) {
        this.extentions = extentions;
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
