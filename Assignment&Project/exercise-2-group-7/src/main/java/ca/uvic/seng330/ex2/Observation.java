package ca.uvic.seng330.ex2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

public class Observation {

    public enum Direction {
        NORTH,
        SOUTH,
        EAST,
        WEST,
        NORTHWEST,
        NORTHEAST,
        SOUTHWEST,
        SOUTHEAST
    }

    private Direction direction;
    private String conditions;
    private final String observationID;
    private ArrayList<Whale> whales = new ArrayList<Whale>();
    private Date sightingTime;
    private Reporter reporter;
    private Location location;
    private SightingPlatform sightingPlatform;

    public Observation() {
        observationID = UUID.randomUUID().toString();
    }

    /**
     *
     *@param direction The direction the whales were seen moving.
     * @param conditions The weather conditions at the time of observation.
     * @param sightingTime The time and date of the whale sighting.
     * @param reporter Contact details for whoever made the sighting.
     * @param location Geographical location of the sighting.
     * @param sightingPlatform Platform from which whales were observed.
     */
    public Observation(Direction direction, String conditions, Date sightingTime, Reporter reporter, Location location, SightingPlatform sightingPlatform) {
        observationID = UUID.randomUUID().toString();
        this.direction = direction;
        this.conditions = conditions;
        this.sightingTime = sightingTime;
        this.reporter = reporter;
        this.location = location;
        this.sightingPlatform = sightingPlatform;
    }

    /**
     * Copy constructor to create a new observation with fields copied from an existing observation.
     *
     * @param observation the observation to copy.
     */
    public Observation(Observation observation) {
        this.direction = observation.getDirection();
        this.conditions = observation.getConditions();
        this.observationID = observation.getObservationID();
        this.whales = observation.getWhales();
        this.sightingTime = observation.getSightingTime();
        this.reporter = observation.getReporter();
        this.location = observation.getLocation();
        this.sightingPlatform = observation.getSightingPlatform();
    }


    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public String getConditions() {
        return conditions;
    }

    public void setConditions(String conditions) {
        this.conditions = conditions;
    }

    public String getObservationID() {
        return observationID;
    }

    /**
     * Get a list of all the whales currently associated with this Observation. Changes to the
     * returned whales will not effect those whales stored in this Observation.
     *
     * @return Copies of all the Whales associated with this Observation.
     */
    public ArrayList<Whale> getWhales() {
        ArrayList<Whale> whalesClone = new ArrayList<Whale>();
        for(Whale whale: whales){
            whalesClone.add(new Whale(whale));
        }

        return whalesClone;
    }

    public Whale getWhalesByIndex(int index) {
        return getWhales().get(index);
    }

    public void addWhale(Whale whale) {
        whales.add(whale);
    }

    //Takes date and time as a string input in a specific format
    public void setSightingTime(String dateAndTime ) throws ParseException {
        SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy kk:mm");
        sightingTime = df.parse(dateAndTime);
    }

    public Date getSightingTime() {
        return sightingTime;
    }

    public Reporter getReporter() {
        return reporter;
    }

    public void setReporter(Reporter reporter) {
        this.reporter = reporter;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public SightingPlatform getSightingPlatform() {
        return sightingPlatform;
    }

    public void setSightingPlatform(SightingPlatform sightingPlatform) {
        this.sightingPlatform = sightingPlatform;
    }

}
