package ca.uvic.seng330.ex3;

import java.util.*;

/**
 * A whale monitor which manages a collection of whale sightings, where each whale sighting is
 * represented by an instance of the observation class.
 */
public class Monitor {

  private ArrayList<Observation> observations;

  public Monitor() {
    observations = new ArrayList<>();
  }

  /**
   * Gets all the observations managed by this whale monitor.
   *
   * @return An ArrayList of the observations stored by this whale monitor.
   */
  public ArrayList<Observation> getObservations() {
    ArrayList<Observation> observationsCopy = new ArrayList<>();
    for (Observation observation : observations) {
      observationsCopy.add(new Observation(observation));
    }
    return observationsCopy;
  }

  /**
   * Gets a copy of a single observations by its observation ID.
   *
   * @param observationId The ID of the observation to get.
   * @return The observation with the given ID if it exists, otherwise null.
   */
  public Observation getObservationById(String observationId) {
    for (Observation observation : observations) {
      if (observation.getObservationId().equals(observationId)) {
        return new Observation(observation);
      }
    }
    return null;
  }

  /**
   * Adds a single observation to this monitor.
   *
   * @param observation The observation to record.
   */
  public void addObservation(Observation observation) {
    if (observation == null) {
      throw new IllegalArgumentException("Observation can't be null");
    }

    observations.add(new Observation(observation));
  }

  /**
   * Replaces all the observations known to this monitor with a new set of observations.
   *
   * @param observations The new set of observations for this monitor to manage.
   */
  public void setObservations(List<Observation> observations) {
    if (observations == null) {
      throw new IllegalArgumentException("Observations can't be null.");
    }

    observations.clear();
    for (Observation observation : observations) {
      addObservation(observation);
    }
  }

  /**
   * Removes a single observation from this monitor based on its unique ID.
   *
   * @param observationId The observation ID of the observation to delete.
   * @return The observation which was removed, or null if there was no matching observation.
   */
  public Observation deleteObservationById(String observationId) {
    for (int i = 0; i < observations.size(); i++) {
      if (observations.get(i).getObservationId().equals(observationId)) {
        return new Observation(observations.remove(i));
      }
    }
    return null;
  }

  /**
   * Sorts observations ArrayList by their sighting time
   * Uses an nested factory method implementation
   */
  public void sortBySightingTime() {
    Collections.sort(observations, Observation.createBySightingTimeComparator());
  }

  /**
   * Sorts observations ArrayList by their latitude
   * Uses an nested factory method implementation
   */
  public void sortByLatitude() {
    Collections.sort(observations, Observation.createByLatitudeComparator());
  }

  /**
   * Searches the observations ArrayList based on sighting time
   *
   * @param sightingTime The sighting time of the whale observation
   * @return ArrayList of Whale Observations corresponding to the sighting time
   */
  public ArrayList<Observation> searchBySightingTime(Date sightingTime) {
    ArrayList<Observation> observationsCopy = getObservations();
    ArrayList<Observation> observationsReturn = new ArrayList<>();

    Observation tempObs = new Observation(
        15,
        Observation.Direction.NORTH,
        Observation.SeaState.SMALL_WAVES,
        sightingTime,
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

    observationsCopy.sort(new Comparator<Observation>() {
      public int compare(Observation o1, Observation o2) {
        return o1.getSightingTime().compareTo(o2.getSightingTime());
      }
    });

    int index = 0;
        /*
        This loop calls Collections.binarySearch() on observationsCopy and stores the index of that observation.
        If the index is valid, we add it to the observationsReturn arraylist and remove it from observationsCopy.
        Validity is confirmed by checking if the index returned is >0 and less than the size of the arrayList.
         */
    while (index >= 0 && index < observationsCopy.size()) {

      index = Collections.binarySearch(observationsCopy, tempObs, new Comparator<Observation>() {
        public int compare(Observation o1, Observation o2) {
          return o1.getSightingTime().compareTo(o2.getSightingTime());
        }
      });
            /*
            If the index is valid, the Observation object at that index is removed from observationsCopy
            and added to observationsReturn
             */
      if (index >= 0 && index < observationsCopy.size()) {
        observationsReturn.add(observationsCopy.remove(index));
      }
    }

    return observationsReturn;
  }

  /**
   * Searches the observations ArrayList based on Observation ID
   *
   * @param observationId the observation ID of the whale observation
   * @return A unique observation corresponding to the ID
   */
  public Observation searchByObservationId(String observationId) {
    ArrayList<Observation> observationsCopy = getObservations();

    Observation tempObs = new Observation(
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
    tempObs.setObservationId(observationId);

    observationsCopy.sort(new Comparator<Observation>() {
      public int compare(Observation o1, Observation o2) {
        return o1.getObservationId().compareTo(o2.getObservationId());
      }
    });

    int index = Collections.binarySearch(observationsCopy, tempObs, new Comparator<Observation>() {
      public int compare(Observation o1, Observation o2) {
        return o1.getObservationId().compareTo(o2.getObservationId());
      }
    });

    return observationsCopy.get(index);
  }
}
