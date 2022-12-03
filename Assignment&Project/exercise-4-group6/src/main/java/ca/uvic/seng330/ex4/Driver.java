package ca.uvic.seng330.ex4;

import java.util.Date;
import java.util.ArrayList;
import java.util.Optional;

/*Description: Driver class used to get system up and running.
* All get and set functions have been called inorder to test
*
 */

public class Driver {

    public static void main(String[] args) {
        //Logger will hold all the observations
        Logger log = new Logger();

        //Reporter Will Hold the observers Name and contact
        Reporter reporter1 = new Reporter("Bob", "Bob@work.com");

        //Array List to hold all the observed whales
        ArrayList<Whale> whaleList = new ArrayList<>();

        //Whale will hold the observed whales species and a description
        Whale whale = new Whale(Whale.WhaleSpecies.SPERM_WHALE, "Young Male with injury to right fin");
        whaleList.add(whale);
        whaleList.add(new Whale(Whale.WhaleSpecies.RIGHT_WHALE, "Female possibly pregnant"));
        whaleList.add(new Whale(Whale.WhaleSpecies.BLUE_WHALE, "Older Female whale accompanied by calf"));
        whaleList.add(new Whale(Whale.WhaleSpecies.BLUE_WHALE, "male calf with mother"));

        //Sighting Platform will hold the data of what means the observer used to observed the whale.
        SightingPlatform platform1 = new SightingPlatform(SightingPlatform.SightingPlatformType.HELICOPTER);

        //store all data of observation into logger class
        log.addObservation(48.1, 124.2, platform1, new Date(), Cardinal.NORTH, whaleList, 25,
                reporter1, "Various whales spoted in pod");

        ArrayList<Observation> obsArray = log.getObservationLog();
        //Test the get functions
        System.out.println("Latitude: " + obsArray.get(0).getLatitude() + ", Longitude: " +
                obsArray.get(0).getLongitude());
        {
            Optional<SightingPlatform> sightingPlatform = obsArray.get(0).getSightingPlatform();
            if (sightingPlatform.isEmpty()) {
                System.out.println("Sighting Platform: Not provided");
            } else {
                System.out.println("Sighting Platform: " + sightingPlatform.get().getSightingPlatformType());
            }
        }
        System.out.println("Date: " + obsArray.get(0).getTimestamp());
        {
            Optional<Cardinal> cardinal = obsArray.get(0).getWhaleHeading();
            if (cardinal.isEmpty()) {
                System.out.println("Cardinal: Unknown direction");
            } else {
                System.out.println("Cardinal: " + cardinal.get());
            }
        }
        //print out whale list with for loop
        for(int i = 0; i < obsArray.get(0).getWhales().size(); i ++){
            System.out.println("Whale Spotted: " + obsArray.get(0).getWhales().get(i).getSpecies() + ", Notes: "
                    + obsArray.get(0).getWhales().get(i).getDescription());
        }

        System.out.println("Distance From observer: " + obsArray.get(0).getDistanceFromReporter());
        System.out.println("Reporter: " + obsArray.get(0).getReporter().getName() + ", Email: "
                + obsArray.get(0).getReporter().getEmail() );
        System.out.println("Notes: " + obsArray.get(0).getExtraInfo() + "\n") ;
        //print all vales

        //Change Reporters email
        System.out.println("Change Reporters email. Originaly was: " + obsArray.get(0).getReporter().getEmail() );
        //Test the setEmail function
        obsArray.get(0).getReporter().setEmail("Bob@Whales.org") ;
        System.out.println("New email: " + obsArray.get(0).getReporter().getEmail() + "\n");

        //testing the other function of the SightingPlatform
        SightingPlatform platform2 =
                new SightingPlatform(SightingPlatform.SightingPlatformType.OTHER, "Watch Tower");

        //Reuse other values as they have already been tested
        log.addObservation(48.1, 124.2, platform2, new Date(), Cardinal.NORTH, whaleList, 25,
                reporter1, "Various whales spotted in pod");
        //print the value of the Other value in Sighting
        {
            Optional<SightingPlatform> sightingPlatform = log.getObservationLog().get(1).getSightingPlatform();
            if(sightingPlatform.isEmpty()) {
                System.out.println("Sighting Platform Observation 2: Not provided");
            } else {
                System.out.println("Sighting Platform Observation 2: " +
                        sightingPlatform.get().getSightingPlatformType() + "\n");
            }
        }
        // Report whale as dead
        whale.reportDead();

        // Testing methods in SearchObservation
        Date d1 = new Date();
        d1.setTime(d1.getTime());
        log.addObservation(50.00, 122.33, platform2, d1, Cardinal.NORTH, whaleList, 25,
                reporter1, "Various whales spotted in pod");
        System.out.println(log.getObservationLog());
        SearchObservation obs1 = new SearchObservation(log.getObservationLog());
        System.out.println(obs1.getList());
        int index = obs1.byTime(new Observation(50.00, 122.33, platform2, d1, Cardinal.NORTH, whaleList, 25,
                reporter1, "Various whales spotted in pod"));
        System.out.println(index);
        System.out.println(obs1.getList());
    }

}
