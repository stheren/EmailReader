package com.stheren.email_reader.graphical

import javafx.event.EventHandler
import javafx.scene.layout.Pane

class ButtonPane : Pane() {
    init {
        style="-fx-border-color: BLACK; -fx-background-color: #C0C0C0;"

        onMouseEntered = EventHandler {
            style = "-fx-border-color: BLACK; -fx-background-color: #DCDCDC;"
        }
        onMouseExited = EventHandler {
            style = "-fx-border-color: BLACK; -fx-background-color: #C0C0C0;"
        }
    }
}