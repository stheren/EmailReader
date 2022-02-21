package com.stheren.email_reader.data

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonPropertyOrder

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder("Color")
class Color(c: String) {
    @get:JsonProperty("Color")
    @set:JsonProperty("Color")
    @JsonProperty("Color")
    var c : String = c

}