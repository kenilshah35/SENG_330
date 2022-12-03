package ca.uvic.seng330.ex9;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@JsonPropertyOrder(value = {"date", "species", "est_size", "gridref", "gender"})
public class ObservedWhale {

  @JsonProperty("species")
  private final String species;

  @JsonProperty("date")
  private final LocalDate time;

  @JsonProperty("est_size")
  private final int weight;

  @JsonProperty("gridref")
  private final long gridref;

  @JsonProperty("gender")
  private final Gender gender;


  /**
   * @pre est_size must be > 0
   * @pre unformattedDate is formatted correctly
   * @param unformattedDate String with date formatted as yyyyMMdd
   * @param species the whale's species
   * @param est_size the whale's estimated weight
   * @param gridref location information
   * @param gender the whale's gender
   */
  public ObservedWhale(@JsonProperty("date") String unformattedDate,
                       @JsonProperty("species") String species,
                       @JsonProperty("est_size") int est_size,
                       @JsonProperty("gridref") long gridref,
                       @JsonProperty("gender") String gender){

    this.gender = Gender.fromString(gender);
    this.gridref = gridref;

    assert est_size > 0 : "Weight must be greater than 0";
    this.weight = est_size;
    this.species = species;

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd", Locale.ENGLISH);
    this.time = LocalDate.parse(unformattedDate,formatter);


  }

  public String getSpecies() {
    return species;
  }

  public LocalDate getTime() {
    return time;
  }

  public int getWeight() {
    return weight;
  }

  public long getGridref() {
    return gridref;
  }

  public Gender getGender() {
    return gender;
  }

  @Override
  public String toString() {
    return "Species " + getSpecies();
  }

  enum Gender{
    MALE,
    FEMALE,
    UNKNOWN;



    public static Gender fromString(String gender){
      if(gender.toLowerCase().equals("m")){
        return MALE;
      } else if(gender.equalsIgnoreCase("f")) {
        return FEMALE;
      } else {
        return UNKNOWN;
      }
    }

    public boolean isMale(){
      return this == MALE;
    }

    public boolean isFemale(){
      return this == FEMALE;
    }
  }

  public static boolean orcaTest(ObservedWhale obs){
    return (!obs.getSpecies().equalsIgnoreCase("orca"));
  }

}
