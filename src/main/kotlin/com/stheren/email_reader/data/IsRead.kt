package com.stheren.email_reader.data

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonPropertyOrder

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder("isRead")
class IsRead {
    @get:JsonProperty("IsRead")
    @set:JsonProperty("IsRead")
    @JsonProperty("IsRead")
    var value : Boolean = false
}