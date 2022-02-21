package com.stheren.email_reader.data

import com.fasterxml.jackson.annotation.*
import com.fasterxml.jackson.databind.JsonNode
import java.util.*
import javax.annotation.processing.Generated

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder("name", "_id", "reference", "version")
class Extention {

    @get:JsonProperty("name")
    @set:JsonProperty("name")
    @JsonProperty("name")
    lateinit var name: String

    @get:JsonProperty("_id")
    @set:JsonProperty("_id")
    @JsonProperty("_id")
    lateinit var id: UUID

    @get:JsonProperty("reference")
    @set:JsonProperty("reference")
    @JsonProperty("reference")
    lateinit var reference: JsonNode

    @get:JsonProperty("version")
    @set:JsonProperty("version")
    @JsonProperty("version")
    lateinit var version: String

    @JsonIgnore
    private val additionalProperties: MutableMap<String, Any> = HashMap()


    constructor() {}

    constructor(name: String, id: UUID, reference: JsonNode, version: String) : super() {
        this.name = name
        this.id = id
        this.reference = reference
        this.version = version
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