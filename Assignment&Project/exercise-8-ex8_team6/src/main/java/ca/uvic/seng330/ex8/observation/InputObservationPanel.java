package ca.uvic.seng330.ex8.observation;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.VBox;

public class InputObservationPanel extends VBox {
  private transient final Slider aSlider = createSlider();


  InputObservationPanel() {
    super();

    Label aLabel = new Label("Please choose the number of whales in the pod");
    aLabel.setPadding(new Insets(10));

    getChildren().add(aLabel);
    getChildren().add(aSlider);
  }

  private static Slider createSlider() {
    final Slider slider = new Slider(1, 10, 5);
    slider.setShowTickMarks(true);
    slider.setShowTickLabels(true);
    slider.setMinWidth(ObservationApp.WIDTH);
    slider.setMajorTickUnit(1);
    slider.setBlockIncrement(1);
    slider.setMinorTickCount(0);
    slider.setSnapToTicks(true);
    return slider;
  }


  public int getSliderValue() {
    return (int) aSlider.getValue();
  }

  public void reset() {
    aSlider.setValue(5);
  }

}

