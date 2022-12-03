package ca.uvic.seng330.ex8.observation;

import java.util.Map;

/**
 * Abstract observer role for the model.
 */
interface Observer {

  void onUpdatedMap(Map<String, Integer> dataMap);

}

