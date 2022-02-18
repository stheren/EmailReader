package com.stheren.email_reader.graphical

import com.stheren.email_reader.engine.Reader
import com.stheren.email_reader.engine.data.Email
import javafx.event.EventHandler
import javafx.fxml.FXML
import javafx.fxml.Initializable
import javafx.geometry.Insets
import javafx.scene.control.Label
import javafx.scene.control.ScrollPane
import javafx.scene.layout.AnchorPane
import javafx.scene.layout.Pane
import javafx.scene.layout.VBox
import javafx.scene.paint.Color
import javafx.scene.text.Font
import javafx.scene.text.Text
import java.net.URL
import java.util.*


class WindowController : Initializable {

    val  r = Reader("Inbox")

    @FXML
    lateinit var EMAIL_LIST: VBox
    lateinit var DISPLAY: AnchorPane

    lateinit var SYNCHRONIZE_BTN: Pane

    lateinit var ITEMS_COUNT: Text
    lateinit var NOT_READ: Text


    override fun initialize(location: URL?, resources: ResourceBundle?) {
        refreshEmailList()

        SYNCHRONIZE_BTN.onMouseEntered = EventHandler {
            SYNCHRONIZE_BTN.style += "-fx-background-color: #DCDCDC;"
        }
        SYNCHRONIZE_BTN.onMouseExited = EventHandler {
            SYNCHRONIZE_BTN.style += "-fx-background-color: #F4F4F4;"
        }
        SYNCHRONIZE_BTN.onMouseClicked = EventHandler {
            refreshEmailList()
        }

    }

    fun printToDisplayPart(e : Email){
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
                body.children.add(Text(e.content).also { content ->
                    println(body.width)
                    content.wrappingWidth = 600.0
                })
            }).also { scrolling ->
                AnchorPane.setBottomAnchor(scrolling, 0.0)
                AnchorPane.setLeftAnchor(scrolling, 0.0)
                AnchorPane.setRightAnchor(scrolling, 0.0)
                AnchorPane.setTopAnchor(scrolling, 75.0)

                scrolling.isFitToWidth = true
            },
        )
    }

    fun refreshEmailList(){
        r.synchronize()
        EMAIL_LIST.children.clear()
        ITEMS_COUNT.text = "Items : ${r.List_Email.count()}"
        NOT_READ.text = "Not Read : ${r.List_Email.count()}"
        for (e in r.List_Email) {
            EMAIL_LIST.spacing = 10.0
            EMAIL_LIST.children.add(
                VBox().also { mail ->
                    mail.prefWidth = 400.0
                    mail.style += "-fx-border-color: blue; -fx-border-width: 0 0 0 2;"
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
                    mail.onMouseEntered = EventHandler {
                        mail.style += "-fx-background-color: #DCDCDC;"
                    }
                    mail.onMouseExited = EventHandler {
                        mail.style += "-fx-background-color: #F4F4F4;"
                    }

                    mail.onMouseClicked = EventHandler {
                        printToDisplayPart(e)
                    }
                }
            )
        }
    }


}