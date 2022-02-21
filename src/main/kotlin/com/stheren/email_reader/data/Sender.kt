package com.stheren.email_reader.data

import com.fasterxml.jackson.annotation.*
import javax.annotation.processing.Generated

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder("name", "lastName", "account", "mail")
class Sender {
    @get:JsonProperty("name")
    @set:JsonProperty("name")
    @JsonProperty("name")
    lateinit var  name: String

    @get:JsonProperty("lastName")
    @set:JsonProperty("lastName")
    @JsonProperty("lastName")
    lateinit var  lastName: String

    @get:JsonProperty("account")
    @set:JsonProperty("account")
    @JsonProperty("account")
    lateinit var  account: String

    @get:JsonProperty("mail")
    @set:JsonProperty("mail")
    @JsonProperty("mail")
    lateinit var  mail: String

    @JsonIgnore
    private val additionalProperties: MutableMap<String, Any> = HashMap()

    constructor() {}

    constructor(name: String, lastName: String, account: String, mail: String) : super() {
        this.name = name
        this.lastName = lastName
        this.account = account
        this.mail = mail
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