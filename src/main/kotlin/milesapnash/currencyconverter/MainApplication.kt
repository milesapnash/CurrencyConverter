package milesapnash.currencyconverter

import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.scene.Scene
import javafx.scene.image.Image
import javafx.stage.Stage

class MainApplication : Application() {
    override fun start(stage: Stage) {
        val root =
            FXMLLoader(MainApplication::class.java.getResource("Main.fxml"))
        val scene = Scene(root.load())
        val icon = Image("file:icon.png")
        scene.stylesheets.add(
            MainApplication::class.java.getResource("currencyconverter.css")!!
                .toExternalForm()
        )
        stage.icons.add(icon)
        stage.title = "Currency Converter"
        stage.isResizable = false
        stage.scene = scene
        stage.show()
    }
}

fun main() {
    Application.launch(MainApplication::class.java)
}