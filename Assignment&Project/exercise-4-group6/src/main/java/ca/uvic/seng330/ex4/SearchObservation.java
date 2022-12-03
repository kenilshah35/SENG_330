package ca.uvic.seng330.ex4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SearchObservation{

    private ArrayList<Observation> observationsList;

    //Constructor
    public SearchObservation(ArrayList<Observation> observationsList){
        if(observationsList == null){throw new RuntimeException("List can't be null");}

        this.observationsList = new ArrayList<>();

        for(Observation obs : observationsList){
            this.observationsList.add(obs);
        }
    }

    /**
     * @return the ArrayList of observations
     */
    public ArrayList<Observation> getList(){
        return observationsList;
    }

    /**
     * Searches Observation Arraylist by their Time Stamp
     * @param obs Observation containing a specific Time Stamp
     * @return index of the matching observation in the ArrayList
     */
    public int byTime(Observation obs){
        if(observationsList == null) return -1;
        if(obs == null) return -1;

        SortObservation sortedObservationList = new SortObservation(observationsList);
        sortedObservationList.byTime();

        return Collections.binarySearch(sortedObservationList.getList(),obs,new Observation.TimestampComparator());
    }

    /**
     * Searches Observation Arraylist by a custom Observation Comparator
     * @param obs Observation object containing a specific field to be searched
     * @param c Observation comparator based upon which to sort/search the list
     * @return
     */
    public int byCustom(Observation obs, Comparator<Observation> c){
        if(observationsList == null) return -1;
        if(obs == null) return -1;

        SortObservation sortedObservationList = new SortObservation(observationsList);
        sortedObservationList.byCustom(c);

        return Collections.binarySearch(sortedObservationList.getList(),obs,c);
    }

}
