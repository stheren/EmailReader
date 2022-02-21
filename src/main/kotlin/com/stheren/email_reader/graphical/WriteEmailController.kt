package com.stheren.email_reader.graphical

import com.fasterxml.jackson.databind.ObjectMapper
import com.stheren.email_reader.GLOBAL_VARIABLE
import com.stheren.email_reader.data.Email
import com.stheren.email_reader.data.*
import javafx.application.Platform
import javafx.event.EventHandler
import javafx.fxml.FXML
import javafx.fxml.Initializable
import javafx.scene.control.ColorPicker
import javafx.scene.control.TextField
import javafx.scene.text.Text
import javafx.scene.web.HTMLEditor
import javafx.stage.Stage
import java.io.File
import java.net.URL
import java.text.SimpleDateFormat
import java.time.format.DateTimeFormatter
import java.util.*

class WriteEmailController : Initializable {
    private val EmailRegex =
        """(?:[a-z0-9!#${'$'}%&'*+/=?^_`{|}~-]+(?:\.[a-z0-9!#${'$'}%&'*+/=?^_`{|}~-]+)*|"(?:[\x01-\x08\x0b\x0c\x0e-\x1f\x21\x23-\x5b\x5d-\x7f]|\\[\x01-\x09\x0b\x0c\x0e-\x7f])*")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\x01-\x08\x0b\x0c\x0e-\x1f\x21-\x5a\x53-\x7f]|\\[\x01-\x09\x0b\x0c\x0e-\x7f])+)\])""".toRegex()

    @FXML
    lateinit var BTN_SEND: ButtonPane

    lateinit var receiverField: TextField
    lateinit var receiverError: Text

    lateinit var subjectField: TextField
    lateinit var subjectError: Text

    lateinit var colorField: ColorPicker
    lateinit var colorError: Text

    lateinit var categoryField: TextField
    lateinit var categoryError: Text

    lateinit var CONTENT: HTMLEditor

    var user: Sender? = null
        set(value) {
            field = value
            CONTENT.htmlText += """
                <br><br><br>
                Best regards,
                <br><br>
                ${value?.name} ${value?.lastName}
                <br>
                ${value?.mail}
            """.trimIndent()
        }

    override fun initialize(location: URL?, resources: ResourceBundle?) {
        BTN_SEND.onMouseClicked = EventHandler {
            if (validateField()) {
                val e = Email()
                e.id = UUID.randomUUID()
                e.metadata = Metadata(
                    user!!,
                    receiverField.text,
                    subjectField.text,
                    categoryField.text.split(','),
                    SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").format(Date())
                )
                e.content = CONTENT.htmlText
                e.extentions = arrayListOf(
                    Extention(
                        "Color",
                        GLOBAL_VARIABLE.UUID_COLOR_EXTENSION,
                        ObjectMapper().valueToTree(Color(colorField.value.toString())),
                        "0.0.1"
                    ),
                    Extention(
                        "IsReaded",
                        GLOBAL_VARIABLE.UUID_IS_READ_EXTENSION,
                        ObjectMapper().valueToTree(IsRead()),
                        "0.0.1"
                    ),
                )

                ObjectMapper().writeValue(File("Inbox/${e.id}.json"), e);
                (BTN_SEND.scene.window as Stage).close()
            }
        }
    }

    private fun validateField(): Boolean {
        cleanAllErrors()
        var result = true
        result = validateReceiver() && result
        result = validateSubject() && result
        result = validateColor() && result
        result = validateCategory() && result
        return result
    }

    private fun validateReceiver(): Boolean {
        return if (receiverField.text.isEmpty()) {
            receiverError.text = "E-mail is required here."
            false
        } else if (!EmailRegex.matches(receiverField.text)) {
            receiverError.text = "The email is not in the right format."
            false
        } else {
            true
        }
    }

    private fun validateSubject(): Boolean {
        return if (subjectField.text.isEmpty()) {
            subjectError.text = "Subject is required here."
            false
        } else {
            true
        }
    }

    private fun validateColor(): Boolean {
        return true
    }

    private fun validateCategory(): Boolean {
        return true
    }

    private fun cleanAllErrors() {
        receiverError.text = ""
        subjectError.text = ""
        colorError.text = ""
        categoryError.text = ""
    }
}