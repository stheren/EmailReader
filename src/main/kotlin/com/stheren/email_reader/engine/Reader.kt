package com.stheren.email_reader.engine

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.stheren.email_reader.GLOBAL_VARIABLE
import com.stheren.email_reader.data.Email
import net.pwall.json.schema.JSONSchema
import java.io.File
import java.nio.file.Files

object Reader {

    private val schema = JSONSchema.parseFile(javaClass.getResource("/core_mail.schema.json")!!.path)
    val List_Email = arrayListOf<Email>()

    fun synchronize() {
        List_Email.clear()
        if (File(GLOBAL_VARIABLE.PATH_TO_INBOX).exists()) {
            Files.list(File(GLOBAL_VARIABLE.PATH_TO_INBOX).toPath()).forEach { filePath ->
                val json = File(filePath.toUri()).readText()
                val output = schema.validateBasic(json)

                output.errors?.forEach {
                    println("${it.error} - ${it.instanceLocation}")
                }

                if(output.valid){
                    val mapper = jacksonObjectMapper()
                    val state = mapper.readValue(json, Email::class.java)
                    List_Email.add(state)
                }
            }
        }
        List_Email.sortByDescending { it.metadata.date }
    }
}