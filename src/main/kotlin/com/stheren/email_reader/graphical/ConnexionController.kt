package com.stheren.email_reader.graphical

import com.fasterxml.jackson.core.JsonFactory
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.stheren.email_reader.engine.data.Sender
import javafx.event.EventHandler
import javafx.fxml.FXML
import javafx.fxml.Initializable
import javafx.scene.control.Button
import javafx.scene.control.TextField
import javafx.scene.text.Text
import java.io.File
import java.net.URL
import java.util.*


class ConnexionController : Initializable {

    lateinit var User : Sender

    lateinit var process: (Sender) -> Unit

    private val EmailRegex = """(?:[a-z0-9!#${'$'}%&'*+/=?^_`{|}~-]+(?:\.[a-z0-9!#${'$'}%&'*+/=?^_`{|}~-]+)*|"(?:[\x01-\x08\x0b\x0c\x0e-\x1f\x21\x23-\x5b\x5d-\x7f]|\\[\x01-\x09\x0b\x0c\x0e-\x7f])*")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\x01-\x08\x0b\x0c\x0e-\x1f\x21-\x5a\x53-\x7f]|\\[\x01-\x09\x0b\x0c\x0e-\x7f])+)\])""".toRegex()

    @FXML
    lateinit var nameField : TextField
    lateinit var lastnameField: TextField
    lateinit var accountField: TextField
    lateinit var emailField: TextField

    lateinit var nameText: Text
    lateinit var lastnameText: Text
    lateinit var accountText: Text
    lateinit var emailText: Text

    lateinit var validButton: Button

    override fun initialize(location: URL?, resources: ResourceBundle?) {
        cleanAllText()

        if(getCacheUser()){
            nameField.text = User.name
            lastnameField.text = User.lastName
            accountField.text = User.account
            emailField.text = User.mail
        }

        validButton.onAction = EventHandler {
            cleanAllText()
            if( nameField.text.isEmpty() ||
                lastnameField.text.isEmpty() ||
                accountField.text.isEmpty() ||
                emailField.text.isEmpty()){

                if(nameField.text.isEmpty()) nameText.text = "Need to be define !"
                if(lastnameField.text.isEmpty()) lastnameText.text = "Need to be define !"
                if(accountField.text.isEmpty()) accountText.text = "Need to be define !"
                if(emailField.text.isEmpty()) emailText.text = "Need to be define !"


                return@EventHandler
            }

            if(!EmailRegex.matches(emailField.text)){
                emailText.text = "Email is not with the good format !"
                return@EventHandler
            }

            User.name = nameField.text
            User.lastName = lastnameField.text
            User.account = accountField.text
            User.mail = emailField.text

            val obj = ObjectMapper()
            File("cache.json").writeText(obj.writeValueAsString(User))

            process(User)

        }
    }

    private fun cleanAllText(){
        nameText.text = ""
        lastnameText.text = ""
        accountText.text = ""
        emailText.text = ""
    }

    fun getCacheUser() : Boolean{
        return try {
            val json = File("cache.json").readText()
            val mapper = jacksonObjectMapper()
            User = mapper.readValue(json, Sender::class.java)
            true
        }catch (e : Exception){
            User = Sender()
            false
        }
    }

}