package ca.uvic.seng330.ex3;

/**
 * The "Platform" that a whale sighting was made from.
 */
public class SightingPlatform {

  public enum Platform {
    SHIP, BOAT, BEACH, PLANE, HELICOPTER
  }

  private Platform platform;
  private String name;

  public SightingPlatform(Platform platform, String name) {
    setPlatform(platform);
    setName(name);
  }

  public SightingPlatform(SightingPlatform sightingPlatform) {
    if (sightingPlatform == null) {
      throw new IllegalArgumentException("SightingPlatform can't be null.");
    }

    setPlatform(sightingPlatform.getPlatform());
    setName(sightingPlatform.getName());
  }

  public Platform getPlatform() {
    return platform;
  }

  public void setPlatform(Platform platform) {
    if (platform == null) {
      throw new IllegalArgumentException("Platform can't be null.");
    }

    this.platform = platform;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    if (name == null) {
      throw new IllegalArgumentException("Name can't be null.");
    }

    this.name = name;
  }
}