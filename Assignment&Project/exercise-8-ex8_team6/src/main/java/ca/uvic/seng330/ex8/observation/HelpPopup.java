package ca.uvic.seng330.ex8.observation;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Popup;

public class HelpPopup extends VBox {
  private transient final Popup helpNotice;
  private final Label helpText;
  private final Button helpButton;

  HelpPopup() {

    helpButton = new Button("Help");
    helpButton.setStyle(" -fx-background-color: lightgrey; -fx-border-width: 1; -fx-border-color: black;");

    helpText = new Label("Please select a whale then enter the amount\n" +
            "of whales observed, either by selecting a value on\n" +
            "the slider or entering a value in the text box.\n" +
            "Lastly, press submit to confirm your input\n" +
            "or reset to reset the graph.\n\n" +
            "Your first selected whale count\n" +
            "entry method will be collected.\n\n" +
            "Click anywhere to close this popup.\n");
    helpText.setId("helpText");
    helpText.setStyle(" -fx-background-color: lightskyblue; -fx-border-width: 4; -fx-border-color: grey;");
    helpText.setPadding(new Insets(10));
    helpText.centerShapeProperty().setValue(true);


    helpNotice = new Popup();
    helpNotice.setAnchorX(100);
    helpNotice.getContent().add(helpText);
    helpNotice.autoHideProperty().setValue(true);

    getChildren().add(helpButton);

    helpButton.setOnAction(event -> {
      if (!helpNotice.isShowing()) {
        helpNotice.show(helpButton, getBoundsInParent().getMinX(), getBoundsInParent().getCenterY());
      } else {
        helpNotice.hide();
      }
    });
  }
}
