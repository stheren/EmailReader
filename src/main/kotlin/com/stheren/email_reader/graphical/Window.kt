package com.stheren.email_reader.graphical

import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.scene.Scene
import javafx.scene.image.Image
import javafx.scene.layout.AnchorPane
import javafx.stage.Stage


class Window : Application(){
    override fun start(primaryStage: Stage) {
        primaryStage.title = "Email Reader"

        val url = javaClass.getResource("/Connexion.fxml")
        val fxmlLoader = FXMLLoader(url)
        val root = fxmlLoader.load<Any>() as AnchorPane

        primaryStage.scene = Scene(root, root.prefWidth, root.prefHeight)
        primaryStage.icons.add(Image(javaClass.getResourceAsStream("/icons8_outlook_calendar_96px.png")))
        primaryStage.show()
    }
}