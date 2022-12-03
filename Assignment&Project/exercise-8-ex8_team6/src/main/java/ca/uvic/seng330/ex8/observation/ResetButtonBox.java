package ca.uvic.seng330.ex8.observation;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class ResetButtonBox extends HBox {
  private final String label = "Reset Graph";
  private final Button clearButton;

  ResetButtonBox(EventHandler<ActionEvent> clearAction) {
    clearButton = new Button(label);
    clearButton.setId("resetButton");
    clearButton.setOnAction(clearAction);
    getChildren().add(clearButton);
  }
}
