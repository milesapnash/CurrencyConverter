package milesapnash.currencyconverter

import javafx.collections.FXCollections
import javafx.fxml.FXML
import javafx.scene.control.Button
import javafx.scene.control.ChoiceBox
import javafx.scene.control.Label
import javafx.scene.control.TextField
import javafx.scene.image.Image
import javafx.scene.image.ImageView
import kotlin.math.roundToInt

class Controller {
    private val nationalities = FXCollections.observableArrayList("UK", "USA")
    private val nationsToCurrencies: HashMap<String, String> =
        hashMapOf("UK" to "GBP", "USA" to "USD")
    private lateinit var currentInputDenomination: String
    private lateinit var currentOutputDenomination: String

    @FXML
    private lateinit var inputTextField: TextField

    @FXML
    private lateinit var outputTextField: TextField

    @FXML
    private lateinit var inputDenominationLabel: Label

    @FXML
    private lateinit var outputDenominationLabel: Label

    @FXML
    private lateinit var inputChoiceBox: ChoiceBox<String>

    @FXML
    private lateinit var outputChoiceBox: ChoiceBox<String>

    @FXML
    private lateinit var reverseButton: Button

    @FXML
    fun initialize() {
        val view = ImageView(Image("file:reverseSymbol.png"))
        view.isPreserveRatio = true
        view.fitWidth = 32.0
        view.fitHeight = 32.0
        reverseButton.graphic = view

        inputChoiceBox.items = nationalities
        inputChoiceBox.value = nationalities[0]
        outputChoiceBox.items = nationalities
        outputChoiceBox.value = nationalities[1]
    }

    fun attemptConversion() {
        val input = inputTextField.text
        if (valid(input)) {
            outputTextField.text =
                ((convert(input.toDouble()) * 100.0).roundToInt() / 100.0).toString()
        } else {
            // WARNING MESSAGE OR REMOVE CONVERT BUTTON
        }
    }

    fun inputChoiceBoxChanged() {
        currentInputDenomination =
            nationsToCurrencies[inputChoiceBox.value].toString()
        inputDenominationLabel.text = currentInputDenomination
    }

    fun outputChoiceBoxChanged() {
        currentOutputDenomination =
            nationsToCurrencies[outputChoiceBox.value].toString()
        outputDenominationLabel.text = currentOutputDenomination
    }

    fun switchBoxValues() {
        val placeholder = inputChoiceBox.value
        inputChoiceBox.value = outputChoiceBox.value
        outputChoiceBox.value = placeholder
    }

    private fun convert(
        input: Double
    ): Double {
        val rate = 1.231649
        return if (currentInputDenomination == currentOutputDenomination) {
            input
        } else if ((currentInputDenomination == "GBP") && (currentOutputDenomination == "USD")) {
            (input * rate)
        } else {
            (input / rate)
        }
    }

    private fun valid(input: String): Boolean {
        return Regex("(\\d{1,3},(\\d{3},)*\\d{3}|\\d+)(.\\d\\d)?\$").containsMatchIn(
            input
        )
    }
}