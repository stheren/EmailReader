package com.stheren.email_reader.data

import com.fasterxml.jackson.annotation.*
import java.util.*
import javax.annotation.processing.Generated

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder("sender", "receiver", "subject", "categories", "date")
class Metadata {

    @get:JsonProperty("sender")
    @set:JsonProperty("sender")
    @JsonProperty("sender")
    lateinit var  sender: Sender

    @get:JsonProperty("receiver")
    @set:JsonProperty("receiver")
    @JsonProperty("receiver")
    lateinit var  receiver: String

    @get:JsonProperty("subject")
    @set:JsonProperty("subject")
    @JsonProperty("subject")
    lateinit var  subject: String

    @get:JsonProperty("categories")
    @set:JsonProperty("categories")
    @JsonProperty("categories")
    var  categories: List<String>? = null

    @get:JsonProperty("date")
    @set:JsonProperty("date")
    @JsonProperty("date")
    @JsonPropertyDescription("ISO8601")
    lateinit var date: String

    @JsonIgnore
    private val additionalProperties: MutableMap<String, Any> = HashMap()


    constructor() {}

    constructor(
        sender: Sender,
        receiver: String,
        subject: String,
        categories: List<String>,
        date: String
    ) : super() {
        this.sender = sender
        this.receiver = receiver
        this.subject = subject
        this.categories = categories
        this.date = date
    }

    @JsonAnyGetter
    fun getAdditionalProperties(): Map<String, Any> {
        return additionalProperties
    }

    @JsonAnySetter
    fun setAdditionalProperty(name: String, value: Any) {
        additionalProperties[name] = value
    }
}