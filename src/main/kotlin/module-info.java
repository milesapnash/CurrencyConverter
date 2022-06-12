module milesapnash.currencyconverter {
  requires javafx.controls;
  requires javafx.fxml;
  requires kotlin.stdlib;


  opens milesapnash.currencyconverter to javafx.fxml;
  exports milesapnash.currencyconverter;
}