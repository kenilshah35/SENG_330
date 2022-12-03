package ca.uvic.seng330.ex2;

public class SightingPlatform {

    public enum Platform {
        SHIP,
        BOAT,
        BEACH,
        PLANE,
        HELICOPTER
    }

    private Platform platform;
    private String name;

    public SightingPlatform(Platform platform, String name) {
        this.platform = platform;
        this.name = name;
    }
    
    public SightingPlatform(SightingPlatform sightingPlatform) {
        platform = sightingPlatform.platform;
        name = sightingPlatform.name;
    }

    public Platform getPlatform() {
        return platform;
    }

    public void setPlatform(Platform platform) {
        this.platform = platform;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
