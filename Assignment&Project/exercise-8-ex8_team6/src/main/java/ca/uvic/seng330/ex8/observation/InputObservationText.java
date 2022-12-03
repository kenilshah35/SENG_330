package ca.uvic.seng330.ex8.observation;

import javafx.animation.FadeTransition;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import javafx.util.converter.IntegerStringConverter;

public class InputObservationText extends VBox {
  private transient final Label aLabel;
  private transient final Label orLabel;
  private transient final TextField inputText;

  InputObservationText() {
    orLabel = new Label("OR");
    aLabel = new Label("Please enter the number of whales in the pod.");

    orLabel.setPadding(new Insets(20, 100, 0, 120));
    aLabel.setPadding(new Insets(10));

    inputText = new TextField();
    inputText.setId("inputText");
    inputText.setPromptText("Enter a valid integer");
    inputText.setPrefColumnCount(10);
    getChildren().add(orLabel);
    getChildren().add(aLabel);
    getChildren().add(inputText);
  }

  public boolean isInputValid() {
    int currentValue;
    try {
      currentValue = Integer.parseInt(inputText.getText());
    } catch (Exception e) {
      return false;
    }

    return currentValue > 0;
  }

  public int getInputValue() {
    return Integer.parseInt(inputText.getText());
  }

  public boolean hasInput() {
    return inputText.getText().length() > 0;
  }

  public void wipe() {
    inputText.clear();
  }

  // Helper method used for testing
  public void setInput(Integer value) {
    inputText.setText(String.valueOf(value));
  }

}
