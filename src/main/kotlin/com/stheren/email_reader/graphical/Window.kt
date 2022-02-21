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

        val fxmlConnexionLoader = FXMLLoader(javaClass.getResource("/Connexion.fxml"))
        val connexionScene = fxmlConnexionLoader.load<Any>() as AnchorPane
        val connexionController = fxmlConnexionLoader.getController() as ConnexionController

        primaryStage.scene = Scene(connexionScene, connexionScene.prefWidth, connexionScene.prefHeight)
        primaryStage.icons.add(Image(javaClass.getResourceAsStream("/icons8_outlook_calendar_96px.png")))
        primaryStage.show()

        connexionController.process = { User ->
            val fxmlMainLoader = FXMLLoader(javaClass.getResource("/AppTemplate.fxml"))
            val mainScene = fxmlMainLoader.load<Any>() as AnchorPane
            val mainController = fxmlMainLoader.getController() as WindowController
            mainController.parentStage = primaryStage
            mainController.user = User
            mainController.refreshEmailList()

            primaryStage.scene = Scene(mainScene, mainScene.prefWidth, mainScene.prefHeight)
        }
    }
}