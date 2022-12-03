package ca.uvic.seng330.ex8.observation;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class SubmitButtonBox extends HBox {
    private final String label = "Submit";
    private final Button submitButton;

    SubmitButtonBox(EventHandler<ActionEvent> submitAction) {
      submitButton = new Button(label);
      submitButton.setId("submitButton");
      submitButton.setOnAction(submitAction);
      getChildren().add(submitButton);
    }
  }

