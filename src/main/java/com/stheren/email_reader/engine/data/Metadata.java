package com.stheren.email_reader.engine.data;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    "sender",
    "receiver",
    "subject",
    "categories",
    "date"
})
@Generated("jsonschema2pojo")
public class Metadata {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("sender")
    private Sender sender;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("receiver")
    private String receiver;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("subject")
    private String subject;
    @JsonProperty("categories")
    private List<String> categories = null;
    /**
     * ISO8601
     * (Required)
     * 
     */
    @JsonProperty("date")
    @JsonPropertyDescription("ISO8601")
    private Date date;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Metadata() {
    }

    /**
     * 
     * @param date
     * @param receiver
     * @param sender
     * @param subject
     * @param categories
     */
    public Metadata(Sender sender, String receiver, String subject, List<String> categories, Date date) {
        super();
        this.sender = sender;
        this.receiver = receiver;
        this.subject = subject;
        this.categories = categories;
        this.date = date;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("sender")
    public Sender getSender() {
        return sender;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("sender")
    public void setSender(Sender sender) {
        this.sender = sender;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("receiver")
    public String getReceiver() {
        return receiver;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("receiver")
    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("subject")
    public String getSubject() {
        return subject;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("subject")
    public void setSubject(String subject) {
        this.subject = subject;
    }

    @JsonProperty("categories")
    public List<String> getCategories() {
        return categories;
    }

    @JsonProperty("categories")
    public void setCategories(List<String> categories) {
        this.categories = categories;
    }

    /**
     * ISO8601
     * (Required)
     * 
     */
    @JsonProperty("date")
    public Date getDate() {
        return date;
    }

    /**
     * ISO8601
     * (Required)
     * 
     */
    @JsonProperty("date")
    public void setDate(Date date) {
        this.date = date;
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
