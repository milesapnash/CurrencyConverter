package milesapnash.currencyconverter

import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.scene.Scene
import javafx.stage.Stage

class MainApplication : Application() {
    override fun start(stage: Stage) {
        val root =
            FXMLLoader(MainApplication::class.java.getResource("Main.fxml"))
        val scene = Scene(root.load())
        scene.stylesheets.add(
            MainApplication::class.java.getResource("currencyconverter.css")!!
                .toExternalForm()
        )
        stage.title = "Currency Converter"
        stage.isResizable = false
        stage.scene = scene
        stage.show()
    }
}

fun main() {
    Application.launch(MainApplication::class.java)
}