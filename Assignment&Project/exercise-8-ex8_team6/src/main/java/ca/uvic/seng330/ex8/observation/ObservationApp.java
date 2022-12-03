package ca.uvic.seng330.ex8.observation;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.Map;

public class ObservationApp extends Application {

  public static final int WIDTH = 200;
  public final static String ORCA = "Orca";
  public final static String GREY = "Grey";
  public final static String HUMPBACK = "Humpback";
  public final static String PORPOISE = "Porpoise";
  public final static String BLUE = "Blue";

  private static final int GAP = 10;
  private static final int MARGIN = 20;
  private InputObservationText observationText;
  private SpeciesListPanel speciesListPanel;
  private ObservationChartPanel chart;
  private ObservationData modelData;
  private HelpPopup helpPopup;
  private ErrorLabel errorLabel;

  /**
   * Launches the application.
   *
   * @param pArgs This program takes no argument.
   */
  public static void main(String[] pArgs) {
    launch(pArgs);
  }

  /*
   * Helper method to hid the details of creating
   * a nice looking grid.
   */
  private static GridPane createPane() {
    GridPane root = new GridPane();
    root.setHgap(GAP);
    root.setVgap(GAP);
    root.setPadding(new Insets(MARGIN));
    return root;
  }

  @Override
  public void start(Stage pPrimaryStage) {

    modelData = new ObservationData();

    final Map<String, Integer> initialData = Map.of(ObservationApp.ORCA, 0, ObservationApp.PORPOISE, 0,
            ObservationApp.GREY, 0, ObservationApp.HUMPBACK, 0, ObservationApp.BLUE, 0);

    chart = new ObservationChartPanel();
    speciesListPanel = new SpeciesListPanel();
    final InputObservationPanel observationPanel = new InputObservationPanel();
    observationText = new InputObservationText();
    helpPopup = new HelpPopup();
    errorLabel = new ErrorLabel();

    modelData.addObserver(chart);
    modelData.addObserver(speciesListPanel);

    modelData.setObservationData(initialData);

    final GridPane root = createPane(); // The root of the GUI component graph
    root.add(chart, 0, 0, 1, 5);
    root.add(helpPopup, 3, 4, 1, 1);
    root.add(speciesListPanel, 1, 0, 2, 1);
    root.add(observationPanel, 1, 1, 2, 1);
    root.add(observationText, 1, 2, 2, 1);
    root.add(errorLabel, 1, 3, 2, 1);
    root.add(new SubmitButtonBox(
            actionEvent -> {
              if (speciesListPanel.hasSelection()) {
                if (observationText.hasInput()) {
                  if(observationText.isInputValid()) {
                    modelData.addObservation(speciesListPanel.getSelected(), observationText.getInputValue());
                    observationText.wipe();
                    errorLabel.clearError();
                  } else {
                    errorLabel.setErrorMessage("Integer entered was invalid");
                  }
                } else {
                  modelData.addObservation(speciesListPanel.getSelected(), observationPanel.getSliderValue());
                  observationPanel.reset();
                  errorLabel.clearError();
                }
              } else {
                errorLabel.setErrorMessage("No whale species selected");
              }
            }), 1, 4, 1, 1);

    root.add(new ResetButtonBox(
                    actionEvent -> modelData.setObservationData(initialData))
            , 2, 4, 1, 1);

    pPrimaryStage.setTitle("Observation App");
    pPrimaryStage.setResizable(false);
    pPrimaryStage.setScene(new Scene(root));
    pPrimaryStage.show();
  }

  public void setObservationData(String whaleType, Integer whaleCount) {
    Platform.runLater(() -> observationText.setInput(whaleCount));
    Platform.runLater(() -> speciesListPanel.setSelection(whaleType));
  }

  public String getListSelection() {
    return speciesListPanel.getSelected();
  }

  // Helper method used for testing
  public String getInputNum() {
    return String.valueOf(observationText.getInputValue());
  }

  // Helper method used for testing
  public ObservableMap<String, Integer> getChartData() {
    return modelData.getObservationData();
  }

  // Helper method used for testing
  public ObservableList<String> listItems() {
    return speciesListPanel.listItems();
  }
}