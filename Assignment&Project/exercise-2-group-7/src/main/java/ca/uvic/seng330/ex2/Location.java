package ca.uvic.seng330.ex2;

/**
 * A simple Location class containing two doubles representing longitude and latitude. Allows for
 * mathematical operations to be performed on Locations.
 */
public class Location {
  private double latitude;
  private double longitude;

  /**
   * Constructs a new location.
   *
   * @param latitude The global latitude measurement for the whale observation
   * @param longitude The global longitude measurement for the whale observation
  */
  public Location(double latitude, double longitude) {
    this.latitude = latitude;
    this.longitude = longitude;
  }

  /**
   * Copy constructor to create a new location with fields copied from an existing location.
   *
   * @param location The whale to copy.
   */
  public Location(Location location){
    this.latitude = location.getLatitude();
    this.longitude = location.getLongitude();
  }

  public double getLatitude() {
    return latitude;
  }

  public double getLongitude() {
    return longitude;
  }

  public void setLatitude(double latitude) {
    this.latitude = latitude;
  }

  public void setLongitude(double longitude) {
    this.longitude = longitude;
  }
}
