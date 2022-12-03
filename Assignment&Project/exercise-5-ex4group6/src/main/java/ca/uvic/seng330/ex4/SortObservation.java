package ca.uvic.seng330.ex4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SortObservation {

    private ArrayList<Observation> observationsList;

    // Constructor
    public SortObservation(ArrayList<Observation> observationsList) {
        if (observationsList == null) {
            throw new RuntimeException("List can't be null");
        }

        this.observationsList = new ArrayList<>();

        for (Observation obs : observationsList) {
            this.observationsList.add(obs);
        }
    }

    /** @return the ArrayList of observations */
    public ArrayList<Observation> getList() {
        return observationsList;
    }

    /** Sorts Observation Arraylist by their Time Stamp */
    public void byTime() {
        Collections.sort(observationsList, new Observation.TimestampComparator());
    }

    /**
     * Sorts Observation Arraylist by a custom Observation comparator
     *
     * @param c Observation comparator based upon which to sort the list
     */
    public void byCustom(Comparator<Observation> c) {
        Collections.sort(observationsList, c);
    }
}
