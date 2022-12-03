package ca.uvic.seng330.ex4;



import java.util.*;

/* Observation class
*
* Description: Used to describe an observation made by a reporter
* about a whale or pod of whales. This simulates the idea of
* somebody filling out a form documenting details about their
* sighting, such as their location, time, etc.
*
* Last edited by: Karl Bonnici, V00964805 on September 20, 2020.
*/

enum Cardinal {
    NORTH,
    SOUTH,
    EAST,
    WEST,
    NORTHEAST,
    NORTHWEST,
    SOUTHEAST,
    SOUTHWEST
}

public class Observation implements Iterable<Whale>{

    @Override
    public Iterator<Whale> iterator() {
        ArrayList<Whale> whalesCopy = new ArrayList<>();
        for(Whale whale : whales){
            whalesCopy.add(whale);
        }
        return whalesCopy.iterator();
    }

    public enum Processing_Status {
        Submitted,
        confirmed,
        fake,
    }    
    
    private final double longitude, latitude;
    private final SightingPlatform sightingPlatform;
    private final Date timestamp;
    private ArrayList<Whale> whales = new ArrayList<>();
    private final Cardinal whaleHeading;
    private final int distanceFromReporter;
    private final String extraInfo;
    private final Reporter reporter;
    private Processing_Status processing_Status=Processing_Status.Submitted;
    
    
    public void confirm() {
        if (this.processing_Status == Processing_Status.confirmed){
        System.out.println("It is already confirmed!");
        return;
        }
        System.out.println("It is confirmed!");
        this.processing_Status = Processing_Status.confirmed;
    }

    public void cancel_result() {
        if (this.processing_Status == Processing_Status.Submitted){
        System.out.println("It is not a confirmed or fake observation!");
        return;
        }
        System.out.println("Successfully cancel the confirmation!");
        this.processing_Status = Processing_Status.Submitted;
    }

    
    public void fake() {
        if (this.processing_Status == Processing_Status.fake){
        System.out.println("It is already a fake observation!");
        return;
        }
        System.out.println("It is a fake observation now!");
        this.processing_Status = Processing_Status.fake;
    }









    // Can throw the null pointer exception
    // sightingPlatform and whaleHeading are valid as null
    Observation(
            double latitude,
            double longitude,
            SightingPlatform sightingPlatform,
            Date timestamp,
            Cardinal whaleHeading,
            ArrayList<Whale> whales,
            int distanceFromReporter,
            Reporter reporter,
            String extraInfo)
    {
        if( timestamp == null )
            throw new NullPointerException();
        if( whales == null )
            throw new NullPointerException();
        if( reporter == null )
            throw new NullPointerException();
        if( extraInfo == null )
            extraInfo = "";

        this.latitude = latitude;
        this.longitude = longitude;
        this.sightingPlatform = sightingPlatform;
        this.distanceFromReporter = distanceFromReporter;
        this.whaleHeading = whaleHeading;
        this.timestamp = timestamp;
        this.extraInfo = extraInfo;
        this.reporter = reporter;
        for (Whale whale : whales) {
            add(whale);
        }
    }

    public void add(Whale whale) {
        if (whale == null) throw new RuntimeException("Whale can not be `null`");
        whale.spot();
        this.whales.add(whale);
    }

    public int getNumberOfWhales(){
        return whales.size();
    }

    public double getLongitude() {
        return longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public int getDistanceFromReporter() {
        return distanceFromReporter;
    }

    public String getExtraInfo() {
        return extraInfo;
    }

    public Reporter getReporter() {
        return reporter;
    }

    public Optional<Cardinal> getWhaleHeading() {
        return Optional.ofNullable(whaleHeading);
    }

    public Optional<SightingPlatform> getSightingPlatform() {
        return Optional.ofNullable(sightingPlatform);
    }

    public ArrayList<Whale> getWhales() {
        return (ArrayList<Whale>) whales.clone();
    }

    static class TimestampComparator implements Comparator<Observation> {
        public int compare(Observation o1, Observation o2) {
            return o1.timestamp.compareTo(o2.timestamp);
        }
    }

    static class ReporterComparator implements Comparator<Observation> {
        public int compare(Observation o1, Observation o2) {
            return o1.reporter.getEmail().compareTo(o2.reporter.getEmail());
        }
    }
}
