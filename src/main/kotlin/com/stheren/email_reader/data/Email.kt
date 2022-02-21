package com.stheren.email_reader.data

import com.fasterxml.jackson.annotation.*
import java.util.*
import javax.annotation.processing.Generated

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder("_id", "metadata", "content", "history", "extentions")
class Email {

    @get:JsonProperty("_id")
    @set:JsonProperty("_id")
    @JsonProperty("_id")
    @JsonPropertyDescription("uid RFC4122")
    lateinit var id: UUID

    @get:JsonProperty("metadata")
    @set:JsonProperty("metadata")
    @JsonProperty("metadata")
    lateinit var  metadata: Metadata

    @get:JsonProperty("content")
    @set:JsonProperty("content")
    @JsonProperty("content")
    lateinit var  content: String

    @get:JsonProperty("history")
    @set:JsonProperty("history")
    @JsonProperty("history")
    var history: UUID? = null

    @get:JsonProperty("extentions")
    @set:JsonProperty("extentions")
    @JsonProperty("extentions")
    var  extentions: List<Extention>? = null

    @JsonIgnore
    private val additionalProperties: MutableMap<String, Any> = HashMap()

    constructor() {}

    constructor(
        id: UUID,
        metadata: Metadata,
        content: String,
        history: UUID,
        extentions: List<Extention>
    ) : super() {
        this.id = id
        this.metadata = metadata
        this.content = content
        this.history = history
        this.extentions = extentions
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