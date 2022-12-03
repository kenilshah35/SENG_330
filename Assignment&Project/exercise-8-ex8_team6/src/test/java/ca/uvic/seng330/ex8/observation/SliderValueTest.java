package ca.uvic.seng330.ex8.observation;

import javafx.beans.binding.Bindings;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxAssert;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;
import org.testfx.matcher.control.LabeledMatchers;

/**
 * Test the expected response of a GUI slider.
 * The collected input should only be valid after the submit button is fired.
 */
@ExtendWith(ApplicationExtension.class)
public class SliderValueTest {
  private static final double initialValue = 5.0;
  private Slider testSlider;
  private Label sliderLabel;
  private Button submitButton;

  /**
   * Will be called with {@code @Before} semantics, i. e. before each test method.
   *
   * @param stage - Will be injected by the test runner.
   */
  @Start
  private void start(Stage stage) {
    HBox root = new HBox();
    Scene scene = new Scene(root, 500, 200);
    testSlider = new Slider(1, 10, 5);
    sliderLabel = new Label("Slider initial value is: " + initialValue);
    submitButton = new Button("Submit");
    IntegerProperty sliderIntValue = new SimpleIntegerProperty();

    testSlider.setShowTickMarks(true);
    testSlider.setShowTickLabels(true);
    testSlider.setMinWidth(ObservationApp.WIDTH);
    testSlider.setMajorTickUnit(1);
    testSlider.setBlockIncrement(1);
    testSlider.setMinorTickCount(0);
    testSlider.setSnapToTicks(true);
    submitButton.setId("submitButton");

    sliderIntValue.bind(Bindings.createIntegerBinding(() -> (int) Math.round(testSlider.getValue()), testSlider.valueProperty()));
    submitButton.setOnAction(e -> sliderLabel.setText("Slider changed from " + initialValue + " to " + testSlider.getValue()));

    StackPane buttonPane = new StackPane();
    StackPane.setAlignment(submitButton, Pos.BOTTOM_CENTER);
    buttonPane.getChildren().add(submitButton);
    root.getChildren().addAll(testSlider, new StackPane(sliderLabel), buttonPane);
    stage.setScene(scene);
    stage.show();
  }

  /**
   * @param robot - Will be injected by the test runner.
   */
  @Test
  void updateSliderValueToSelected(FxRobot robot) {
    robot.drag(testSlider.lookup(".thumb"), MouseButton.PRIMARY);
    robot.dropTo("2");
    System.out.println(testSlider.valueChangingProperty().getValue());
    robot.release(MouseButton.PRIMARY);

    FxAssert.verifyThat(testSlider.getValue(), Matchers.equalTo(2.0));
  }

  /**
   * @param robot - Will be injected by the test runner.
   */
  @Test
  void noLabelUpdateWhenSubmitNotClicked(FxRobot robot) {
    robot.drag(testSlider.lookup(".thumb"), MouseButton.PRIMARY);
    robot.dropTo("10");
    robot.release(MouseButton.PRIMARY);

    FxAssert.verifyThat(sliderLabel.textProperty().getValue(), LabeledMatchers.hasText("Slider initial value is: 5.0"));
  }

  /**
   * @param robot - Will be injected by the test runner.
   */
  @Test
  void updateLabelWhenClickedSubmit(FxRobot robot) {
    robot.drag(testSlider.lookup(".thumb"), MouseButton.PRIMARY);
    robot.dropTo("8");
    robot.release(MouseButton.PRIMARY);
    robot.clickOn("#submitButton");

    FxAssert.verifyThat(testSlider.getValue(), Matchers.equalTo(8.0));
    FxAssert.verifyThat(sliderLabel.textProperty().getValue(), LabeledMatchers.hasText("Slider changed from 5.0 to 8.0"));
  }
}
