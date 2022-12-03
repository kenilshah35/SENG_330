package ca.uvic.seng330.ex8.observation;

import javafx.collections.FXCollections;
import javafx.collections.MapChangeListener;
import javafx.collections.ObservableMap;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * The observable object.
 */
public class ObservationData implements MapChangeListener<String, Integer> {

  private final List<Observer> aObservers = new ArrayList<>();
  private final ObservableMap<String, Integer> aObservationData = FXCollections.observableHashMap();

  public ObservationData(){
    aObservationData.addListener(this);
  }

  public void addObserver(Observer pObserver) {
    aObservers.add(pObserver);
  }

  private void notifyObservers() {
    for (Observer observer : aObservers) {
      observer.onUpdatedMap(aObservationData);
    }
  }

  public void setObservationData(Map<String, Integer> observationData) {
    this.aObservationData.clear();
    this.aObservationData.putAll(observationData);
  }

  public void addObservation(String whaleType, Integer whaleCount){
    aObservationData.computeIfPresent(whaleType, (k, v)-> v+whaleCount);
    aObservationData.putIfAbsent(whaleType, whaleCount);
  }

  public ObservableMap<String, Integer> getObservationData(){
    return aObservationData;
  }

  @Override
  public void onChanged(Change change) {
    notifyObservers();
  }
}