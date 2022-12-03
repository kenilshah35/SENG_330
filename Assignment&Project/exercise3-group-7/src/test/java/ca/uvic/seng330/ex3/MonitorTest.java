package ca.uvic.seng330.ex3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.junit.jupiter.api.Assertions.*;

class MonitorTest {

    private Monitor observations;
    private Monitor sortedObservationsBySightingTime;

    @BeforeEach
    void beforeEachFunction(){
        Location location1 = new Location(31.784,-51.907);
        Location location2 = new Location(-7.195,-12.120);
        Location location3 = new Location(-8.060,-69.222);
        Location location4 = new Location(6.229,150.679);

        Reporter reporter1 = new Reporter("Gary","gary@whaleReporter.com","778-305-291");
        Reporter reporter2 = new Reporter("Jack","jack@whaleReporter.com","778-048-731");
        Reporter reporter3 = new Reporter("David","david@whaleReporter.com","604-173-335");
        Reporter reporter4 = new Reporter("Peter","peter@whaleReporter.com","778-112-030");

        SightingPlatform platform1 = new SightingPlatform(SightingPlatform.Platform.BEACH, "Shoal Bay");
        SightingPlatform platform2 = new SightingPlatform(SightingPlatform.Platform.BOAT, "Thousand Sunny");
        SightingPlatform platform3 = new SightingPlatform(SightingPlatform.Platform.HELICOPTER, "Sikorsky");
        SightingPlatform platform4 = new SightingPlatform(SightingPlatform.Platform.PLANE, "Boeing 747");

        Whale whale1 = new Whale(Whale.Species.KILLER, Whale.Confidence.CERTAIN, new Whale.Behavior[]{Whale.Behavior.FAST_TRAVEL}, false, "Killer, certain, fast travel, false");
        Whale whale2 = new Whale(Whale.Species.FIN, Whale.Confidence.POSSIBLE, new Whale.Behavior[]{Whale.Behavior.SLOW_TRAVEL}, false, "Fin, possible, slow travel, false");
        Whale whale3 = new Whale(Whale.Species.BLUE, Whale.Confidence.PROBABLE, new Whale.Behavior[]{Whale.Behavior.BOW_RIDING}, false, "Blue, probable, bow riding, false");
        Whale whale4 = new Whale(Whale.Species.GREY, Whale.Confidence.UNCERTAIN, new Whale.Behavior[]{Whale.Behavior.PORPOISING}, true, "Grey, uncertain, porpoising, true");

        Observation observation1 = new Observation(10, Observation.Direction.EAST, Observation.SeaState.HIGH_WAVES, new GregorianCalendar(2014, Calendar.FEBRUARY,11).getTime(), reporter1, location1, platform1, new ArrayList<Whale>(){{add(whale1);}});
        Observation observation2 = new Observation(8, Observation.Direction.WEST, Observation.SeaState.SMALL_WAVES, new GregorianCalendar(2013, Calendar.JANUARY,7).getTime(), reporter2, location2, platform2, new ArrayList<Whale>(){{add(whale2);}});
        Observation observation3 = new Observation(13, Observation.Direction.SOUTH, Observation.SeaState.MODERATE_WAVES, new GregorianCalendar(2017, Calendar.AUGUST,21).getTime(), reporter3, location3, platform3, new ArrayList<Whale>(){{add(whale3);}});
        Observation observation4 = new Observation(3, Observation.Direction.NORTH, Observation.SeaState.SMOOTH, new GregorianCalendar(2015, Calendar.DECEMBER,18).getTime(), reporter4, location4, platform4, new ArrayList<Whale>(){{add(whale4);}});

        // hard code a uuid for observation 1 for testing
        observation1.setObservationId("54947df8-0e9e-4471-a2f9-9af509fb5889");

        observations = new Monitor();
        observations.addObservation(observation1);
        observations.addObservation(observation2);
        observations.addObservation(observation3);
        observations.addObservation(observation4);

        sortedObservationsBySightingTime = new Monitor();
        sortedObservationsBySightingTime.addObservation(observation2);
        sortedObservationsBySightingTime.addObservation(observation1);
        sortedObservationsBySightingTime.addObservation(observation4);
        sortedObservationsBySightingTime.addObservation(observation3);
    }

    @Test
    void sortBySightingTime() {
        observations.sortBySightingTime();
        assertEquals("Jack", observations.getObservations().get(0).getReporter().getName());
        assertEquals("Gary", observations.getObservations().get(1).getReporter().getName());
        assertEquals("Peter", observations.getObservations().get(2).getReporter().getName());
        assertEquals("David", observations.getObservations().get(3).getReporter().getName());
    }

    @Test
    void sortByLatitude(){
        observations.sortByLatitude();
        assertEquals("David", observations.getObservations().get(0).getReporter().getName());
        assertEquals("Jack", observations.getObservations().get(1).getReporter().getName());
        assertEquals("Peter", observations.getObservations().get(2).getReporter().getName());
        assertEquals("Gary", observations.getObservations().get(3).getReporter().getName());
    }

    @Test
    void searchBySightingTime(){
        ArrayList<Observation> result = observations.searchBySightingTime(new GregorianCalendar(2014, Calendar.FEBRUARY,11).getTime());
        String nameFromResult = result.get(0).getReporter().getName();
        assertEquals("Gary",nameFromResult);
    }

    @Test
    void searchByObservationId(){
        Observation result = observations.searchByObservationId("54947df8-0e9e-4471-a2f9-9af509fb5889");
        assertEquals("54947df8-0e9e-4471-a2f9-9af509fb5889", result.getObservationId());
    }
}
