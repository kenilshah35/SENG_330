package ca.uvic.seng330.ex8.observation;

import javafx.animation.FadeTransition;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

public class ErrorLabel extends VBox {
  private transient final Label errorLabel;
  private final transient FadeTransition ft;

  public ErrorLabel(){
    errorLabel = new Label("");
    ft = new FadeTransition(Duration.millis(500),errorLabel);
    ft.setFromValue(0);
    ft.setToValue(1);

    errorLabel.setPadding(new Insets(0, 30, 5, 60));
    errorLabel.setId("errorLabel");

    getChildren().add(errorLabel);

  }

  public void setErrorMessage(String message){
    errorLabel.setText(message);
    ft.play();
  }

  public void clearError(){
    errorLabel.setText("");
  }

}
