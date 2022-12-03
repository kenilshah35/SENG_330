package ca.uvic.seng330.ex3;

import java.util.*;

/**
 * An single Observation of a group of one of more Whales, made by a Reporter.
 */

public class Observation implements Iterable<Whale>, Comparable<Observation> {

  @Override
  public Iterator<Whale> iterator() {
    ArrayList<Whale> whalesCopy = new ArrayList<>();
    for (Whale whale : whales) {
      whalesCopy.add(new Whale(whale));
    }
    return whalesCopy.iterator();

  }

  @Override
  public int compareTo(Observation o) {
    return this.observationId.compareTo(o.observationId);
  }


  public enum Direction {
    NORTH, SOUTH, EAST, WEST, NORTHWEST, NORTHEAST, SOUTHWEST, SOUTHEAST
  }

  public enum SeaState {
    SMOOTH, SMALL_WAVES, MODERATE_WAVES, HIGH_WAVES
  }

  private String observationId;
  private int windSpeed;
  private Direction direction;
  private SeaState seaState;
  private Date sightingTime;
  private Reporter reporter;
  private Location location;
  private SightingPlatform sightingPlatform;
  private ArrayList<Whale> whales;

  /**
   * Observation constructor specifying all fields.
   *
   * @param windSpeed        Wind speed at the time of the sighting, int knots.
   * @param direction        The direction the whales were seen moving.
   * @param seaState         The weather conditions at the time of observation.
   * @param sightingTime     The time and date of the whale sighting.
   * @param reporter         Contact details for whoever made the sighting.
   * @param location         Geographical location of the whales in this sighting.
   * @param sightingPlatform Where the reporter was when they made the sighting.
   */
  public Observation(int windSpeed, Direction direction, SeaState seaState, Date sightingTime,
                     Reporter reporter, Location location, SightingPlatform sightingPlatform,
                     List<Whale> whales) {
    observationId = UUID.randomUUID().toString();
    setWindSpeed(windSpeed);
    setDirection(direction);
    setSeaState(seaState);
    setSightingTime(sightingTime);
    setReporter(reporter);
    setLocation(location);
    setSightingPlatform(sightingPlatform);
    setWhales(whales);
  }

  /**
   * Copy constructor to create a new Observation with fields copied from an existing Observation.
   * The copied observation will have a new ID.
   *
   * @param observation The Observation to copy.
   */
  public Observation(Observation observation) {
    setObservationId(observation.getObservationId());
    setWindSpeed(observation.getWindSpeed());
    setDirection(observation.getDirection());
    setSeaState(observation.getSeaState());
    setSightingTime(observation.getSightingTime());
    setReporter(observation.getReporter());
    setLocation(observation.getLocation());
    setSightingPlatform(observation.getSightingPlatform());
    setWhales(observation.getWhales());
  }

  /**
   * Gets all the whales which were seen in this observation.
   *
   * @return An ArrayList containing copies of the whales associated with this observation.
   */
  private ArrayList<Whale> getWhales() {
    ArrayList<Whale> whalesCopy = new ArrayList<>();
    for (Whale whale : whales) {
      whalesCopy.add(new Whale(whale));
    }
    return whalesCopy;
  }

  /**
   * Replace the whales currently associated with this observation with a new list of whales.
   *
   * @param whales A new list of whales to associate with this observation.
   */
  public void setWhales(List<Whale> whales) {
    if (whales == null) {
      throw new IllegalArgumentException("Whales can't be null.");
    }

    if (this.whales == null) {
      this.whales = new ArrayList<Whale>();
    } else {
      this.whales.clear();
    }

    for (Whale whale : whales) {
      this.whales.add(new Whale(whale));
    }

  }

  public String getObservationId() {
    return observationId;
  }

  public void setObservationId(String observationId) {
    this.observationId = observationId;
  }

  public int getWindSpeed() {
    return windSpeed;
  }

  public void setWindSpeed(int windSpeed) {
    this.windSpeed = windSpeed;
  }

  public Direction getDirection() {
    return direction;
  }

  public void setDirection(Direction direction) {
    if (direction == null) {
      throw new IllegalArgumentException("Direction can't be null.");
    }

    this.direction = direction;
  }

  public SeaState getSeaState() {
    return seaState;
  }

  public void setSeaState(SeaState seaState) {
    if (seaState == null) {
      throw new IllegalArgumentException("SeaState can't be null.");
    }

    this.seaState = seaState;
  }

  public Date getSightingTime() {
    return new Date(sightingTime.getTime());
  }

  public void setSightingTime(Date sightingTime) {
    if (sightingTime == null) {
      throw new IllegalArgumentException("SightingTime can't be null.");
    }

    this.sightingTime = new Date(sightingTime.getTime());
  }

  public Reporter getReporter() {
    return new Reporter(reporter);
  }

  public void setReporter(Reporter reporter) {
    if (reporter == null) {
      throw new IllegalArgumentException("Reporter can't be null.");
    }

    this.reporter = new Reporter(reporter);
  }

  public Location getLocation() {
    return new Location(location);
  }

  public void setLocation(Location location) {
    if (location == null) {
      throw new IllegalArgumentException("Location can't be null.");
    }

    this.location = new Location(location);
  }

  public SightingPlatform getSightingPlatform() {
    return new SightingPlatform(sightingPlatform);
  }

  public void setSightingPlatform(SightingPlatform sightingPlatform) {
    if (sightingPlatform == null) {
      throw new IllegalArgumentException("SightingPlatform can't be null.");
    }

    this.sightingPlatform = new SightingPlatform(sightingPlatform);
  }

  /**
   * Nested class comparator factory method
   *
   * @return a comparator for Observation's sighting time
   */
  public static Comparator<Observation> createBySightingTimeComparator() {
    return new Comparator<Observation>() {
      @Override
      public int compare(Observation o1, Observation o2) {
        return o1.getSightingTime().compareTo(o2.getSightingTime());
      }
    };
  }

  /**
   * Nested class comparator factory method
   *
   * @return a comparator for Observation's latitude
   */
  public static Comparator<Observation> createByLatitudeComparator() {
    return new Comparator<Observation>() {
      @Override
      public int compare(Observation o1, Observation o2) {
        if (o1.getLocation().getLatitude() < o2.getLocation().getLatitude()) {
          return -1;
        } else if (o1.getLocation().getLatitude() > o2.getLocation().getLatitude()) {
          return 1;
        } else {
          return 0;
        }
      }
    };
  }
}