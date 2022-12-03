package ca.uvic.seng330.ex9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.BiPredicate;

/**
 * Dedicated SortWhales class, which can be used to sort whales using specific comparators.
 * Also contains a findHeavierWhaleObservation method.
 */
public class SortWhales {
    private final List<ObservedWhale> observationsList;
    public static final BiPredicate<ObservedWhale, ObservedWhale> heavierWhale = (o1, o2) -> {
        return o1.getWeight() > o2.getWeight();
    };

    //Constructor
    public SortWhales(List<ObservedWhale> observationsList){
        if(observationsList == null){throw new RuntimeException("List can't be null");}

        this.observationsList = new ArrayList<>();

        this.observationsList.addAll(observationsList);
    }

    /**
     * @return the List of observations
     */
    public List<ObservedWhale> getList(){
        return observationsList;
    }

    /**
     * Takes in two observations and returns the one with the heavier whale
     * @param obs1 First Observation to be compared
     * @param obs2 Second Observation to be compared
     * @return Observation with the heavier whale
     */
    public static ObservedWhale findHeavierWhale(ObservedWhale obs1, ObservedWhale obs2){
        if(heavierWhale.test(obs1,obs2)) return obs1;
        else return obs2;
    }

    /**
     * A private comparator method which takes in two observations and
     * compares weights of whales using a BiPredicate instance
     * @param obs1 First Observation to be compared
     * @param obs2 Second Observation to be compared
     * @return  1 if obs1 > obs2 or -1 if obs1 < obs2
     */
    private static int compareByWeight(ObservedWhale obs1, ObservedWhale obs2){
        if(heavierWhale.test(obs1,obs2)) return 1;
        else return -1;
    }

    /**
     * Sorts the list of observations in ascending order according to weight of the whales
     */
    public void byWeight(){
        Collections.sort(observationsList,SortWhales::compareByWeight);
    }
}
