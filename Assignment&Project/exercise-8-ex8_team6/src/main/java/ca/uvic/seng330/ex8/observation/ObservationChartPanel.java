package ca.uvic.seng330.ex8.observation;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.HBox;
import javafx.util.StringConverter;

import java.util.Map;

/**
 * A BarChart showing whale counts per Observation
 * see https://openjfx.io/javadoc/11/javafx.controls/javafx/scene/chart/BarChart.html
 */
public class ObservationChartPanel extends HBox implements Observer {
  private final transient NumberAxis xAxis = new NumberAxis();
  private final transient CategoryAxis yAxis = new CategoryAxis();
  private final transient BarChart<Number, String> barChart = new BarChart<>(xAxis, yAxis);
  private final XYChart.Series<Number, String> output = new XYChart.Series<>();

  //Using converter so that the X Axis label only take integer values
  private final StringConverter<Number> converter = new StringConverter<>() {
    @Override
    public String toString(Number object) {
      return object.doubleValue() == object.intValue()
              ? object.intValue() + ""
              : "";
    }

    @Override
    public Number fromString(String string) {
      return 0;
    }
  };

  ObservationChartPanel() {
    barChart.setTitle("Observation Summary");
    barChart.legendVisibleProperty().setValue(false);

    xAxis.setLabel("Count");
    xAxis.setTickLabelRotation(90);
    xAxis.setTickLabelFormatter(converter);
    xAxis.setMinorTickVisible(false);
    yAxis.setLabel("Species");

    barChart.getData().add(output);
    getChildren().add(barChart);
  }

  @Override
  public void onUpdatedMap(Map<String, Integer> dataMap) {
    ObservableList<XYChart.Data<Number, String>> updatedSeries = FXCollections.observableArrayList();

    for (Map.Entry<String, Integer> e : dataMap.entrySet()) {
      final XYChart.Data<Number, String> newData = new XYChart.Data<>(e.getValue(), e.getKey());
      updatedSeries.add(newData);
    }
    output.setData(updatedSeries);
    xAxis.setAnimated(false);
  }
}
