package ca.uvic.seng330.ex4;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Date;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ProcessingStatusTest {

    Observation observation;

    @BeforeEach
    void setup() {
        Whale whale = new Whale(Whale.WhaleSpecies.COMMON_DOLPHIN, "Small blue dolphin");
        ArrayList<Whale> whales = new ArrayList<>();
        whales.add(whale);
        observation =
                new Observation(
                        0d,
                        0d,
                        new SightingPlatform(SightingPlatform.SightingPlatformType.LAND),
                        new Date(),
                        Cardinal.NORTH,
                        whales,
                        0,
                        new Reporter("Jaxson", "j@email.com"),
                        "Spotted from dock");
    }

    @Test
    void testStatusChange() {
        assertEquals(observation.getStatus(), Observation.ProcessingStatus.SUBMITTED);
        observation.confirm();
        assertEquals(observation.getStatus(), Observation.ProcessingStatus.CONFIRMED);
        observation.cancelResult();
        assertEquals(observation.getStatus(), Observation.ProcessingStatus.SUBMITTED);
        observation.fake();
        assertEquals(observation.getStatus(), Observation.ProcessingStatus.FAKE);
        observation.cancelResult();
        assertEquals(observation.getStatus(), Observation.ProcessingStatus.SUBMITTED);
    }

    @Test
    void cantGoFromConfirmedToFake() {
        assertThrows(
                InvalidStatusException.class,
                () -> {
                    observation.confirm();
                    observation.fake();
                });
    }

    @Test
    void cantGoFromFakeToConfirmed() {
        assertThrows(
                InvalidStatusException.class,
                () -> {
                    observation.fake();
                    observation.confirm();
                });
    }
}
