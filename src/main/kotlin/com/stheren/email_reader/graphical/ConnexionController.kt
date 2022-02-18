package com.stheren.email_reader.graphical

import javafx.event.EventHandler
import javafx.fxml.FXML
import javafx.fxml.Initializable
import javafx.scene.control.Button
import javafx.scene.control.TextField
import javafx.scene.text.Text
import java.net.URL
import java.util.*

class ConnexionController : Initializable {

    lateinit var process: (String, String, String, String) -> Any

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

            process(nameField.text, lastnameField.text, accountField.text, emailField.text)

        }
    }

    private fun cleanAllText(){
        nameText.text = ""
        lastnameText.text = ""
        accountText.text = ""
        emailText.text = ""
    }

}