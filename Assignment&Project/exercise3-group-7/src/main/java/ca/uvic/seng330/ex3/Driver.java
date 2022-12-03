package ca.uvic.seng330.ex3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class Driver {

  /**
   * Main method which creates an example whale monitor.
   *
   * @param args Unused.
   */
  public static void main(String[] args) {

    // create a new whale monitor
    Monitor monitor = new Monitor();

    // create an observation to add to the whale monitor
    Observation o1 = new Observation(
        15,
        Observation.Direction.NORTH,
        Observation.SeaState.SMALL_WAVES,
        new Date(),
        new Reporter(
            "John Smith",
            "johnsmith@example.com",
            "12501234567"
        ),
        new Location(48.4634, 123.3117),
        new SightingPlatform(SightingPlatform.Platform.SHIP, "HMS BoatyMcBoatFace"),
        new ArrayList<Whale>(Arrays.asList(new Whale(
            Whale.Species.HUMPBACK,
            Whale.Confidence.PROBABLE,
            new Whale.Behavior[]{
                Whale.Behavior.BREACHING,
                Whale.Behavior.SLOW_TRAVEL
            },
            false,
            "Scar on left flipper"
        )))
    );

    monitor.addObservation(o1);
    monitor.addObservation(new Observation(o1));
  }
}
