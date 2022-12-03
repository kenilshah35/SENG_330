package ca.uvic.seng330.ex8.observation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyMap;
import static org.mockito.Mockito.*;

/**
 * Test the expected response of the Model.
 * When the model is updated, the subscribers will be notified.
 * The model should notify the Observer for any method of data change.
 * Mocks have been used to separate the GUI from the domain code.
 */
public class ObservationDataTest {

  ObservationData dataModel;
  Observer subscriber;

  @BeforeEach
  public void init(){
    dataModel = new ObservationData();
    subscriber = mock(Observer.class);
    dataModel.addObserver(subscriber);
  }

  @Test
  public void testDataIsUpdatedOnSingleObservation(){
    dataModel.addObservation("Orca", 1);
    verify(subscriber).onUpdatedMap(anyMap());
    assertThat(dataModel.getObservationData()).contains(Map.entry("Orca", 1));
  }

  @Test
  public void testDataIsUpdatedOnNewMap(){
    Map<String , Integer> newData = Map.of("Fish", 10, "Whales", 11);
    dataModel.setObservationData(newData);
    verify(subscriber, atLeastOnce()).onUpdatedMap(newData);
  }

  @Test
  public void testDataIsUpdatedWithExternalAccess(){
    dataModel.getObservationData().put("Tower", 1);
    verify(subscriber).onUpdatedMap(anyMap());
  }

  @Test
  public void testMultipleSubscribers(){
    Observer secondSubscriber = mock(Observer.class);
    dataModel.addObserver(secondSubscriber);
    dataModel.addObservation("Fish", 3);
    verify(subscriber).onUpdatedMap(anyMap());
    verify(secondSubscriber).onUpdatedMap(anyMap());
  }



}

