package ca.uvic.seng330.ex2;

import java.util.ArrayList;
import java.util.Date;

public class Monitor {

    private ArrayList<Observation> observations;

    public Monitor() {
        observations = new ArrayList<Observation>();
    }

    public Monitor(Observation obs){
        observations = new ArrayList<Observation>();
        observations.add(obs);
    }

    public Monitor(ArrayList<Observation> obs){
        observations = new ArrayList<Observation>();
        observations.addAll(obs);
    }

    public Observation getObservationsById(int index) {
        return observations.get(index);
    }

    public void setObservations(ArrayList<Observation> observations) {
        this.observations.clear();

        for(int i=0; i<observations.size(); i++){

            /* deep copying location */
            double latitude = observations.get(i).getLocation().getLatitude();
            double longitude = observations.get(i).getLocation().getLongitude();
            Location location_clone = new Location(latitude, longitude);

            /* deep copying reporter */
            String reporter_name = observations.get(i).getReporter().getName();
            String email = observations.get(i).getReporter().getEmail();
            String phone = observations.get(i).getReporter().getPhone();
            Reporter reporter_clone = new Reporter(reporter_name,email,phone);

            /* deep copying Sighting Origin */
            SightingPlatform.Platform platform = observations.get(i).getSightingPlatform().getPlatform();
            String sight_name = observations.get(i).getSightingPlatform().getName();
            SightingPlatform sightingPlatform_clone = new SightingPlatform(platform, sight_name);

            /* deep copying observation */
            Observation.Direction direction = observations.get(i).getDirection();
            String conditions = observations.get(i).getConditions();
            ArrayList<Whale> whales = new ArrayList<Whale>();
            Date sightingTime = observations.get(i).getSightingTime();
            whales = observations.get(i).getWhales();
            String observationID = observations.get(i).getObservationID();


            /* putting all the cloned variables into the newly created observation */
            Observation observation_clone = new Observation(direction,conditions,sightingTime,reporter_clone,location_clone,sightingPlatform_clone);
            observation_clone.setSightingPlatform(sightingPlatform_clone);
            // How to add whales?
            // How to copy observationID?

            /* add the newly created observation to ArrayList */
            this.observations.add(observation_clone);
        }
    }

    public void deleteObservationById(int index){
        observations.remove(index);
    }
}
