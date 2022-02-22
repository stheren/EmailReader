package com.stheren.email_reader.engine

import com.fasterxml.jackson.databind.ObjectMapper
import com.stheren.email_reader.GLOBAL_VARIABLE.PATH_TO_INBOX
import com.stheren.email_reader.data.Email
import java.io.File

object Writer {
    fun write(e : Email){
        ObjectMapper().writeValue(File(PATH_TO_INBOX + "/${e.id}.json"), e)
    }
}