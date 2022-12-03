package ca.uvic.seng330.ex8.observation;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;

import java.util.Map;

public class SpeciesListPanel extends VBox implements Observer {
  private static final int ROW_HEIGHT = 24;
  ListView<String> list = new ListView<>();
  Label aLabel = new Label("Please select the whale that you saw");

  SpeciesListPanel() {
    aLabel.setLabelFor(this);
    aLabel.setPadding(new Insets(10));
    list.setId("whaleList");
    getChildren().add(aLabel);
    getChildren().add(list);
  }

  public String getSelected() {
    var items = list.getSelectionModel().getSelectedItems();
    return hasSelection() ? items.get(0) : "";
  }

  public boolean hasSelection() {
    return list.getSelectionModel().getSelectedItems().size() > 0;
  }

  @Override
  public void onUpdatedMap(Map<String, Integer> dataMap) {
    list.setItems(FXCollections.observableArrayList(dataMap.keySet()));
    list.setPrefHeight(dataMap.size() * ROW_HEIGHT + 2);
  }

  // Helper method used for testing
  public void setSelection(String selectedWhale) {
    list.getSelectionModel().select(selectedWhale);
  }

  // Helper method used for testing
  public ObservableList<String> listItems() {
    return list.getItems();
  }
}
