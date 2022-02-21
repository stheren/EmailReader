package com.stheren.email_reader.graphical

import com.stheren.email_reader.engine.Reader
import com.stheren.email_reader.data.Sender
import javafx.event.EventHandler
import javafx.fxml.FXML
import javafx.fxml.FXMLLoader
import javafx.fxml.Initializable
import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.scene.Scene
import javafx.scene.control.Label
import javafx.scene.control.ScrollPane
import javafx.scene.control.Tooltip
import javafx.scene.image.Image
import javafx.scene.image.ImageView
import javafx.scene.layout.AnchorPane
import javafx.scene.layout.HBox
import javafx.scene.layout.Pane
import javafx.scene.layout.VBox
import javafx.scene.paint.Color
import javafx.scene.text.Font
import javafx.scene.text.Text
import javafx.scene.web.WebView
import javafx.stage.Modality
import javafx.stage.Stage
import javafx.util.Duration
import java.net.URL
import java.util.*


class WindowController : Initializable {

    val r = Reader("Inbox")
    lateinit var parentStage: Stage

    lateinit var user: Sender

    @FXML
    lateinit var EMAIL_LIST: VBox
    lateinit var DISPLAY: AnchorPane

    lateinit var NEWMAIL_BTN: Pane
    lateinit var SYNCHRONIZE_BTN: Pane

    lateinit var ITEMS_COUNT: Text
    lateinit var NOT_READ: Text


    override fun initialize(location: URL?, resources: ResourceBundle?) {
        SYNCHRONIZE_BTN.onMouseClicked = EventHandler {
            refreshEmailList()
        }
        NEWMAIL_BTN.onMouseClicked = EventHandler {
            val dialog = Stage();
            val fxmlMailLoader = FXMLLoader(javaClass.getResource("/NewMail.fxml"))
            val mailScene = fxmlMailLoader.load<Any>() as AnchorPane
            val mailController = fxmlMailLoader.getController() as WriteEmailController
            mailController.user = user

            dialog.icons.add(Image(javaClass.getResourceAsStream("/icons8_new_message_96px_3.png")))
            dialog.title = "New Email"

            dialog.scene = Scene(mailScene, mailScene.prefWidth, mailScene.prefHeight)
            dialog.initOwner(parentStage);
            dialog.initModality(Modality.APPLICATION_MODAL);
            dialog.showAndWait();
            refreshEmailList()
        }

    }

    fun printToDisplayPart(e: com.stheren.email_reader.data.Email) {
        DISPLAY.children.clear()
        DISPLAY.children.addAll(
            VBox().also { header ->
                AnchorPane.setTopAnchor(header, 0.0)
                AnchorPane.setLeftAnchor(header, 0.0)
                AnchorPane.setRightAnchor(header, 0.0)
                header.spacing = 10.0
                header.style += "-fx-background-color: #DCDCDC;"

                header.children.addAll(
                    Label(e.metadata.subject).also {
                        it.font = Font("Monospace bold", 25.0)
                    },
                    VBox(
                        Label("From : ${e.metadata.sender.name} <${e.metadata.sender.mail}>"),
                        Label("To : ${e.metadata.receiver}")
                    )
                )
            },
            ScrollPane(VBox().also { body ->
                body.isFillWidth = true
                body.children.add(
                    WebView().also { content ->
                        content.engine.loadContent(e.content)
                    }
                )
            }).also { scrolling ->
                AnchorPane.setBottomAnchor(scrolling, 0.0)
                AnchorPane.setLeftAnchor(scrolling, 0.0)
                AnchorPane.setRightAnchor(scrolling, 0.0)
                AnchorPane.setTopAnchor(scrolling, 75.0)

                scrolling.isFitToHeight = true
                scrolling.isFitToWidth = true
            },
        )
    }

    fun refreshEmailList() {
        r.synchronize()
        EMAIL_LIST.children.clear()
        ITEMS_COUNT.text =
            "Items : ${r.List_Email.count { e -> e.metadata.sender.mail == user.mail || e.metadata.receiver == user.mail }}"
        NOT_READ.text = "Not Read : ${r.List_Email.count { e -> e.metadata.receiver == user.mail }}"

        for (e in r.List_Email) {
            if (e.metadata.sender.mail != user.mail && e.metadata.receiver != user.mail) continue
            EMAIL_LIST.spacing = 10.0
            EMAIL_LIST.children.add(
                HBox(
                    ImageView().also {
                        if(e.metadata.sender.mail == user.mail) {
                            it.image = Image(javaClass.getResourceAsStream("/icons8_send_48px.png"))
                            Tooltip.install(it, Tooltip("Send by you.").also {
                                it.showDelay = Duration(0.0)
                            })
                        }else {
                            it.image = Image(javaClass.getResourceAsStream("/icons8_received_48px.png"))
                            Tooltip.install(it, Tooltip("This element is received.").also {
                                it.showDelay = Duration(0.0)
                            })
                        }
                        it.fitHeight = 50.0
                        it.isPreserveRatio = true
                    },
                    VBox().also { mail ->
                        mail.prefWidth = 400.0
                        mail.style += "-fx-border-color: ${e.extentions?.first()?.reference?.get("Color") ?: "#0000FF"}; -fx-border-width: 0 0 0 2;"
                        mail.padding = Insets(10.0)
                        mail.children.addAll(
                            Label(e.metadata.sender.name).also { title ->
                                title.font = Font("Monospace bold", 20.0)
                            },
                            Label(e.metadata.subject).also { content ->
                                content.textFill = Color.BLUE
                            },
                            Label(e.metadata.date.toString()).also { content ->
                                content.font = Font("Arial bold", 10.0)
                                content.textFill = Color.BLUE
                            }
                        )
                    }
                ).also { hbox ->
                    hbox.alignment = Pos.CENTER
                    hbox.onMouseEntered = EventHandler {
                        hbox.style += "-fx-background-color: #DCDCDC;"
                    }
                    hbox.onMouseExited = EventHandler {
                        hbox.style += "-fx-background-color: #F4F4F4;"
                    }

                    hbox.onMouseClicked = EventHandler {
                        printToDisplayPart(e)
                    }
                }
            )
        }
    }


}