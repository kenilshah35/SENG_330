package ca.uvic.seng330.ex8.observation;

import javafx.application.Platform;
import javafx.stage.Stage;
import org.hamcrest.text.MatchesPattern;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxAssert;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;
import org.testfx.matcher.control.LabeledMatchers;

/**
 * Test the expected response of the ObservationApp GUI.
 * The collected input should only be valid after the submit button is fired.
 */
@ExtendWith(ApplicationExtension.class)
public class ObservationAppTest {
  private ObservationApp obsApp;

  /**
   * Will be called with {@code @Before} semantics, i. e. before each test method.
   *
   * @param stage - Will be injected by the test runner.
   */
  @Start
  private void start(Stage stage) {
    obsApp = new ObservationApp();
    obsApp.start(stage);
  }

  @Test
  void testListContainsWhales() {
    FxAssert.verifyThat(obsApp.listItems().sorted().get(0), MatchesPattern.matchesPattern("Blue"));
    FxAssert.verifyThat(obsApp.listItems().sorted().get(1), MatchesPattern.matchesPattern("Grey"));
    FxAssert.verifyThat(obsApp.listItems().sorted().get(2), MatchesPattern.matchesPattern("Humpback"));
    FxAssert.verifyThat(obsApp.listItems().sorted().get(3), MatchesPattern.matchesPattern("Orca"));
    FxAssert.verifyThat(obsApp.listItems().sorted().get(4), MatchesPattern.matchesPattern("Porpoise"));
  }

  /**
   * @param robot - Will be injected by the test runner.
   */
  @Test
  void testChartUpdatesValues(FxRobot robot) {
    // Enter parameters to chart
    obsApp.setObservationData("Humpback", 2);
    // Submit to update
    robot.clickOn("#submitButton");
    obsApp.setObservationData("Porpoise", 5);
    robot.clickOn("#submitButton");
    // Verify that the observer map GUI has updated the correct key with the correct value.
    FxAssert.verifyThat(obsApp.getChartData().getOrDefault("Humpback", 0).toString(), MatchesPattern.matchesPattern("2"));
    FxAssert.verifyThat(obsApp.getChartData().getOrDefault("Porpoise", 0).toString(), MatchesPattern.matchesPattern("5"));
  }

  /**
   * @param robot - Will be injected by the test runner.
   */
  @Test
  void testInputBoxAndListSelection(FxRobot robot) {
    // Select the parameters of the GUI
    obsApp.setObservationData("Orca", 7);
    // Verify that that the input text box has the correct entered value (thread sync)
    Platform.runLater(() -> FxAssert.verifyThat(obsApp.getInputNum(), MatchesPattern.matchesPattern("7")));
    robot.clickOn("#submitButton");
    // Verify that the selected whale matches the selected item in the list after submitting
    FxAssert.verifyThat(obsApp.getListSelection(), MatchesPattern.matchesPattern("Orca"));
  }

  /**
   * @param robot - Will be injected by the test runner.
   */
  @Test
  void testResetButtonResets(FxRobot robot) {
    // Input some data first to populate the chart
    obsApp.setObservationData("Blue", 9);
    robot.clickOn("#submitButton");
    obsApp.setObservationData("Grey", 12);
    robot.clickOn("#submitButton");
    // Verify that the data entered has registered correctly
    FxAssert.verifyThat(obsApp.getChartData().getOrDefault("Blue", 0).toString(), MatchesPattern.matchesPattern("9"));
    FxAssert.verifyThat(obsApp.getChartData().getOrDefault("Grey", 0).toString(), MatchesPattern.matchesPattern("12"));
    // Reset the chart
    robot.clickOn("Reset Graph");
    // Verify that the reset correctly cleared the values of the keys
    FxAssert.verifyThat(obsApp.getChartData().getOrDefault("Blue", 9).toString(), MatchesPattern.matchesPattern("0"));
    FxAssert.verifyThat(obsApp.getChartData().getOrDefault("Humpback", 12).toString(), MatchesPattern.matchesPattern("0"));
  }

  /**
   * @param robot - Will be injected by the test runner.
   */
  @Test
  void testHelpPopsUp(FxRobot robot) {
    // Click on the help button to trigger the popup
    robot.clickOn("Help");
    String helpMessage = "Please select a whale then enter the amount\n" +
            "of whales observed, either by selecting a value on\n" +
            "the slider or entering a value in the text box.\n" +
            "Lastly, press submit to confirm your input\n" +
            "or reset to reset the graph.\n\n" +
            "Your first selected whale count\n" +
            "entry method will be collected.\n\n" +
            "Click anywhere to close this popup.\n";
    // Verify the popup was correctly triggered
    FxAssert.verifyThat("#helpText", LabeledMatchers.hasText(helpMessage));
  }


  @Test
  void testErrorMessageDisplaysOnNonIntegerInput(FxRobot robot) {
    robot.clickOn("#whaleList");
    robot.clickOn("#inputText");
    robot.write("cat");
    robot.clickOn("#submitButton");
    FxAssert.verifyThat("#errorLabel", LabeledMatchers.hasText("Integer entered was invalid"));
  }

  @Test
  void testErrorMessageDisplaysOnNegativeIntegerInput(FxRobot robot) {
    robot.clickOn("#whaleList");
    robot.clickOn("#inputText");
    robot.write("-10");
    robot.clickOn("#submitButton");
    FxAssert.verifyThat("#errorLabel", LabeledMatchers.hasText("Integer entered was invalid"));
  }

  @Test
  void testNoErrorMessageDisplaysOnValidIntegerInput(FxRobot robot) {
    robot.clickOn("#whaleList");
    robot.clickOn("#inputText");
    robot.write("10");
    robot.clickOn("#submitButton");
    FxAssert.verifyThat("#errorLabel", LabeledMatchers.hasText(""));
  }

  @Test
  void testErrorOnNoWhaleSelected(FxRobot robot){
    robot.clickOn("#inputText");
    robot.write("10");
    robot.clickOn("#submitButton");
    FxAssert.verifyThat("#errorLabel", LabeledMatchers.hasText("No whale species selected"));
  }
}
