package ca.uvic.seng330.ex4;

public class SightingPlatform {
    public enum SightingPlatformType {
        AIRPLANE,
        HELICOPTER,
        FERRY,
        KAYAK,
        LAND,
        MOTOR_VESSEL,
        SAILBOAT,
        OTHER
    }

    private final SightingPlatformType sightingPlatformType;
    private final String otherType;

    public SightingPlatform(SightingPlatformType sightingPlatformType) {
        this(sightingPlatformType, "");
    }

    // Converts null values into valid values
    public SightingPlatform(SightingPlatformType sightingPlatformType, String otherType) {
        if (sightingPlatformType == null) {
            sightingPlatformType = SightingPlatformType.OTHER;
        }
        this.sightingPlatformType = sightingPlatformType;
        // if sightingPlatformType is other
        if (sightingPlatformType == SightingPlatformType.OTHER) {
            if (otherType == null) {
                otherType = "Unknown";
            }
            this.otherType = otherType;
        } else {
            this.otherType = "";
        }
    }

    public String getSightingPlatformType() {
        if (sightingPlatformType == SightingPlatformType.OTHER) {
            return otherType;
        } else {
            return sightingPlatformType.toString();
        }
    }
}
