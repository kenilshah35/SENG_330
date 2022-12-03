package ca.uvic.seng330.ex4;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

class StatusTest {

    Whale whale;

    @BeforeEach void setup() {
        whale = new Whale(Whale.WhaleSpecies.COMMON_DOLPHIN, "Small blue dolphin");
    }

    @Test void testStatusChange() {
        assertEquals(whale.getStatus(), Whale.Status.UNDISCOVERED);
        whale.spot();
        assertEquals(whale.getStatus(), Whale.Status.SPOTTED);
        whale.reportDead();
        assertEquals(whale.getStatus(), Whale.Status.DEAD);
    }

    @Test void testObservationChangesStatus() {
        ArrayList<Whale> whales = new ArrayList<>();
        whales.add(whale);
        Observation obs = new Observation(0d, 0d,
          new SightingPlatform(SightingPlatform.SightingPlatformType.LAND), new Date(),
          Cardinal.NORTH,
          whales, 0,
          new Reporter("Jaxson", "j@email.com"),
          "Spotted from dock"
        );
        assertEquals(whale.getStatus(), Whale.Status.SPOTTED);
        whale.reportDead();
        assertEquals(whale.getStatus(), Whale.Status.DEAD);
    }

    @Test void cantReportDeadTwice() {
        assertThrows(Whale.InvalidStatusException.class, () -> {
          whale.reportDead();
          assertEquals(whale.getStatus(), Whale.Status.DEAD);
          whale.reportDead();
        });
    }
}
