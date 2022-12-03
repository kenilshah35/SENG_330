package ca.uvic.seng330.ex2;

/**
 * A class representing an observed whale. There may be multiple instances of this class
 * corresponding to the same whale recorded under different observations.
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
  private Behavior[] behaviors;
  private boolean deadOrDistressed;
  private String description;

  /**
   * Constructs a new Whale.
   *
   * @param species The species of the whale.
   * @param confidence Observer's confidence in their identification of the whale's species.
   * @param behaviors The behavior of the whale at the time of observation.
   * @param description Other pertinent observations about this whale.
   */
  public Whale(Species species, Confidence confidence, Behavior[] behaviors,
               boolean deadOrDistressed, String description) {
    this.species = species;
    this.confidence = confidence;
    this.behaviors = behaviors;
    this.deadOrDistressed = deadOrDistressed;
    this.description = description;
  }

  /**
   * Copy constructor to create a new whale with fields copied from an existing whale.
   *
   * @param whale The whale to copy.
   */
  public Whale(Whale whale) {
    this.species = whale.getSpecies();
    this.confidence = whale.getConfidence();
    this.behaviors = whale.getBehaviors();
    this.deadOrDistressed = whale.isDeadOrDistressed();
    this.description = whale.getDescription();
  }

  public Species getSpecies() {
    return species;
  }

  public void setSpecies(Species species) {
    this.species = species;
  }

  public Confidence getConfidence() {
    return confidence;
  }

  public void setConfidence(Confidence confidence) {
    this.confidence = confidence;
  }

  public Behavior[] getBehaviors() {
    return behaviors.clone();
  }

  public void setBehaviors(Behavior[] behaviors) {
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
    this.description = description;
  }
}
