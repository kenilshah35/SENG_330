package ca.uvic.seng330.ex4;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class Logger {
    // The database
    private ArrayList<Observation> observationLog;

    // This tracks how many of each species have been observed.
    private HashMap<Whale.WhaleSpecies, Integer> observationCount;

    public Logger() {
        observationLog = new ArrayList<>();
        observationCount = new HashMap<>();
    }

    private void updateSpeciesCount(ArrayList<Whale> whales) {
        assert (whales != null);
        for (Whale w : whales) {
            Whale.WhaleSpecies species = w.getSpecies();
            Integer currentVal = observationCount.getOrDefault(species, 0);
            observationCount.put(species, currentVal + 1);
        }
    }

    public void addObservation(Observation obs) {
        if (obs == null) {
            throw new NullPointerException();
        }

        // Add the number of observed species to the tracker
        updateSpeciesCount(obs.getWhales());

        // Log the observation
        observationLog.add(obs);
    }

    public void addObservation(
            double latitude,
            double longitude,
            SightingPlatform sightingPlatform,
            Date date,
            Cardinal whaleHeading,
            ArrayList<Whale> whales,
            int distance,
            Reporter reporter,
            String extraInfo) {

        Observation obs =
                new Observation(
                        latitude,
                        longitude,
                        sightingPlatform,
                        date,
                        whaleHeading,
                        whales,
                        distance,
                        reporter,
                        extraInfo);

        addObservation(obs);
    }

    public ArrayList<Observation> getObservationLog() {
        return new ArrayList<Observation>(observationLog);
    }

    public Integer getObservationCount(Whale.WhaleSpecies species) {
        return observationCount.getOrDefault(species, 0);
    }
}
