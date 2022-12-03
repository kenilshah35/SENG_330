package ca.uvic.seng330.ex4;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OptionalTest {
    Observation obs;

    @BeforeEach
    void setup() {
        obs =
                new Observation(
                        48.1,
                        124.2,
                        null,
                        new Date(2020, 12, 5),
                        null,
                        new ArrayList<>(),
                        25,
                        new Reporter(null, null),
                        null);
    }

    @Test
    void testOptional() {
        Optional<SightingPlatform> optPlatform = obs.getSightingPlatform();
        assertTrue(optPlatform.isEmpty());

        Optional<Cardinal> optHeading = obs.getWhaleHeading();
        assertTrue(optHeading.isEmpty());
    }

    @Test
    void testNullAutoConversion() {
        assertNotEquals(obs.getExtraInfo(), null);
        assertNotEquals(obs.getWhaleHeading(), null);
        assertNotEquals(obs.getSightingPlatform(), null);
        assertNotEquals(obs.getReporter().getName(), null);
        assertNotEquals(obs.getReporter().getEmail(), null);

        SightingPlatform platform = new SightingPlatform(null);
        assertNotEquals(platform.getSightingPlatformType(), null);

        Whale whale = new Whale(Whale.WhaleSpecies.COMMON_DOLPHIN, null);
        assertNotEquals(whale.getDescription(), null);
    }

    @Test
    void testWhaleConstructionExceptions() {
        assertThrows(
                NullPointerException.class,
                () -> {
                    new Whale(null, "5/7 whale");
                });
    }

    @Test
    void testObservationConstructionExceptions() {
        assertThrows(
                NullPointerException.class,
                () -> {
                    Observation ob =
                            new Observation(
                                    48.1,
                                    124.2,
                                    new SightingPlatform(
                                            SightingPlatform.SightingPlatformType.LAND),
                                    null,
                                    Cardinal.NORTH,
                                    new ArrayList<>(),
                                    25,
                                    new Reporter("", ""),
                                    "observation");
                });

        assertThrows(
                NullPointerException.class,
                () -> {
                    Observation ob =
                            new Observation(
                                    48.1,
                                    124.2,
                                    new SightingPlatform(
                                            SightingPlatform.SightingPlatformType.AIRPLANE),
                                    new Date(2020, 12, 5),
                                    Cardinal.NORTH,
                                    null,
                                    25,
                                    new Reporter("", ""),
                                    "observation");
                });

        assertThrows(
                NullPointerException.class,
                () -> {
                    Observation ob =
                            new Observation(
                                    48.1,
                                    124.2,
                                    new SightingPlatform(
                                            SightingPlatform.SightingPlatformType.AIRPLANE),
                                    new Date(2020, 12, 5),
                                    Cardinal.NORTH,
                                    new ArrayList<>(),
                                    25,
                                    null,
                                    "observation");
                });
    }
}
