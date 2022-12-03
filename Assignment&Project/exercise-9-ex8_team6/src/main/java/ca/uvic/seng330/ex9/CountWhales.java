package ca.uvic.seng330.ex9;

import java.time.LocalDate;
import java.util.List;

public class CountWhales {

    private final List<ObservedWhale> observedWhaleList;

    public CountWhales(List<ObservedWhale> obs){
        observedWhaleList = obs;
    }

    public long beforeDate(LocalDate threshold){
        return observedWhaleList.stream().filter(o -> o.getTime().isBefore(threshold)).count();
    }

    public long afterDate(LocalDate threshold){
        return observedWhaleList.stream().filter(o -> o.getTime().isAfter(threshold)).count();
    }

}
