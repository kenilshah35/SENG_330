package ca.uvic.seng330.ex8.observation;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxAssert;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;
import org.testfx.matcher.control.LabeledMatchers;

/**
 * Test the expected response of a GUI list of whales.
 * The collected input should only be valid after the submit button is fired.
 */
@ExtendWith(ApplicationExtension.class)
public class SpeciesListPanelTest {
  private Label selectionLabel;
  private Button submitButton;
  private ListView<String> whaleList;

  /**
   * Will be called with {@code @Before} semantics, i. e. before each test method.
   *
   * @param stage - Will be injected by the test runner.
   */
  @Start
  private void start(Stage stage) {
    HBox root = new HBox();
    Scene scene = new Scene(root, 500, 200);
    selectionLabel = new Label("No Selected Whale");
    submitButton = new Button("Submit");
    whaleList = new ListView<String>();

    selectionLabel.setId("selectionLabel");
    whaleList.setId("whaleList");
    submitButton.setId("submitButton");

    ObservableList<String> items = FXCollections.observableArrayList(
            "Orca", "Humpback", "Grey", "Porpoise"); //hmm, we've seen this before
    whaleList.setItems(items);
    submitButton.setOnAction(actionEvent -> selectionLabel.setText("Selected Whale: " + whaleList.getSelectionModel().getSelectedItem()));

    root.getChildren().addAll(whaleList, selectionLabel, new StackPane(submitButton));
    stage.setScene(scene);
    stage.show();
  }

  /**
   * @param robot - Will be injected by the test runner.
   */
  @Test
  void shouldContainListOfWhales(FxRobot robot) {
    robot.clickOn("#whaleList");
    FxAssert.verifyThat("#whaleList", Node::isVisible);
    FxAssert.verifyThat(whaleList.getItems().get(0), LabeledMatchers.hasText("Orca"));
    FxAssert.verifyThat(whaleList.getItems().get(1), LabeledMatchers.hasText("Humpback"));
    FxAssert.verifyThat(whaleList.getItems().get(2), LabeledMatchers.hasText("Grey"));
    FxAssert.verifyThat(whaleList.getItems().get(3), LabeledMatchers.hasText("Porpoise"));
  }

  /**
   * @param robot - Will be injected by the test runner.
   */
  @Test
  void selectWhaleNoLabelUpdate(FxRobot robot) {
    robot.clickOn("Porpoise");

    FxAssert.verifyThat(whaleList.getSelectionModel().getSelectedItem(), LabeledMatchers.hasText("Porpoise"));
    FxAssert.verifyThat("#selectionLabel", LabeledMatchers.hasText("No Selected Whale"));
  }

  /**
   * @param robot - Will be injected by the test runner.
   */
  @Test
  void updateLabelWhenSubmitIsClicked(FxRobot robot) {
    robot.clickOn("Humpback");
    robot.clickOn(".button");

    FxAssert.verifyThat(whaleList.getSelectionModel().getSelectedItem(), LabeledMatchers.hasText("Humpback"));
    FxAssert.verifyThat("#selectionLabel", LabeledMatchers.hasText("Selected Whale: Humpback"));
  }
}

