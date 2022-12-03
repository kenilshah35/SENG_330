package ca.uvic.seng330.ex3;

import java.util.Comparator;

/**
 * An observed whale. There may be multiple instances of this class corresponding to the same whale
 * recorded under different observations.
 */
public class Whale {
  public enum Species {
    KILLER,
    HUMPBACK,
    GREY,
    MINKE,
    FIN,
    SPERM,
    SEI,
    BLUE,
    NORTH_PACIFIC_RIGHT,
    BAIRDS_BEAKED,
    CUVIERS_BEAKED,
    STEJNEGERS_BEAKED,
    HUBBS_BEAKED
  }

  public enum Confidence {
    CERTAIN, PROBABLE, POSSIBLE, UNCERTAIN
  }

  public enum Behavior {
    SLOW_TRAVEL,
    FAST_TRAVEL,
    SPY_HOPPING,
    FLUKING,
    FEEDING,
    BREACHING,
    BOW_RIDING,
    PORPOISING
  }

  private Species species;
  private Confidence confidence;

  // Represents an ordered sequence of behaviors seen during a single observation.
  // see: https://github.com/SENG330/exercise-2-group-7/pull/1
  private Behavior[] behaviors;
  private boolean deadOrDistressed;
  private String description;

  /**
   * Constructs a new Whale.
   *
   * @param species          The species of the whale.
   * @param confidence       Observer's confidence in their identification of the whale's species.
   * @param behaviors        The behavior of the whale at the time of observation.
   * @param deadOrDistressed Boolean value indicating whether this whale was dead or distressed.
   * @param description      Other pertinent observations about this whale.
   */
  public Whale(Species species, Confidence confidence, Behavior[] behaviors,
               boolean deadOrDistressed, String description) {
    setSpecies(species);
    setConfidence(confidence);
    setBehaviors(behaviors);
    setDeadOrDistressed(deadOrDistressed);
    setDescription(description);
  }

  /**
   * Copy constructor to create a new whale with fields copied from an existing whale.
   *
   * @param whale The whale to copy.
   */
  public Whale(Whale whale) {
    if (whale == null) {
      throw new IllegalArgumentException("Whale can't be null.");
    }

    setSpecies(whale.getSpecies());
    setConfidence(whale.getConfidence());
    setBehaviors(whale.getBehaviors());
    setDeadOrDistressed(whale.isDeadOrDistressed());
    setDescription(whale.getDescription());
  }

  public Species getSpecies() {
    return species;
  }

  public void setSpecies(Species species) {
    if (species == null) {
      throw new IllegalArgumentException("Species can't be null.");
    }

    this.species = species;
  }

  public Confidence getConfidence() {
    return confidence;
  }

  public void setConfidence(Confidence confidence) {
    if (confidence == null) {
      throw new IllegalArgumentException("Confidence can't be null.");
    }

    this.confidence = confidence;
  }

  public Behavior[] getBehaviors() {
    return behaviors.clone();
  }

  public void setBehaviors(Behavior[] behaviors) {
    if (behaviors == null) {
      throw new IllegalArgumentException("Behavior array can't be null.");
    }

    for (Behavior behavior : behaviors) {
      if (behavior == null) {
        throw new IllegalArgumentException("No null behaviors.");
      }
    }

    this.behaviors = behaviors.clone();
  }

  public boolean isDeadOrDistressed() {
    return deadOrDistressed;
  }

  public void setDeadOrDistressed(boolean deadOrDistressed) {
    this.deadOrDistressed = deadOrDistressed;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    if (description == null) {
      throw new IllegalArgumentException("Description can't be null");
    }

    this.description = description;
  }

  /*
   *  Nested class to implement Comparator based on confidence
   */
  static class WhaleConfidenceComparator implements Comparator<Whale> {
    public int compare(Whale o1, Whale o2) {
      return o1.getConfidence().compareTo(o2.getConfidence());
    }
  }
}