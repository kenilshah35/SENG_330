package ca.uvic.seng330.ex3;

import java.util.*;

public class SearchTest {

    public static void main(String[] args) {

        Monitor monitor = new Monitor();
        Date d1 = new Date();
        d1 = new Date(d1.getTime());

        Observation o1 = new Observation(
                0,
                Observation.Direction.NORTH,
                Observation.SeaState.SMALL_WAVES,
                d1,
                new Reporter(
                        "John Smith",
                        "johnsmith@example.com",
                        "12501234567"
                ),
                new Location(48.4634, 123.3117),
                new SightingPlatform(SightingPlatform.Platform.SHIP, "HMS BoatyMcBoatFace"),
                new ArrayList<Whale>(Arrays.asList(new Whale(
                        Whale.Species.HUMPBACK,
                        Whale.Confidence.PROBABLE,
                        new Whale.Behavior[]{
                                Whale.Behavior.BREACHING,
                                Whale.Behavior.SLOW_TRAVEL
                        },
                        false,
                        "Scar on left flipper"
                )))
        );

        Observation o2 = new Observation(
                1,
                Observation.Direction.SOUTH,
                Observation.SeaState.HIGH_WAVES,
                d1,
                new Reporter(
                        "Kenil Shah",
                        "kenilshah@example.com",
                        "12505556666"
                ),
                new Location(50.4634, 223.3117),
                new SightingPlatform(SightingPlatform.Platform.HELICOPTER, "fff BootyMcBoatFace"),
                new ArrayList<Whale>(Arrays.asList(new Whale(
                        Whale.Species.KILLER,
                        Whale.Confidence.CERTAIN,
                        new Whale.Behavior[]{
                                Whale.Behavior.BOW_RIDING,
                                Whale.Behavior.FEEDING
                        },
                        false,
                        "Scar on right flipper"
                )))
        );

        Observation o3 = new Observation(
                2,
                Observation.Direction.EAST,
                Observation.SeaState.MODERATE_WAVES,
                d1,
                new Reporter(
                        "John Doe",
                        "johndoe@example.com",
                        "12308887777"
                ),
                new Location(61.4634, 133.3117),
                new SightingPlatform(SightingPlatform.Platform.PLANE, "lll BootyMcBoatFace"),
                new ArrayList<Whale>(Arrays.asList(new Whale(
                        Whale.Species.SPERM,
                        Whale.Confidence.POSSIBLE,
                        new Whale.Behavior[]{
                                Whale.Behavior.FLUKING,
                                Whale.Behavior.SPY_HOPPING
                        },
                        false,
                        "Scar on belly"
                )))
        );

        Observation o4 = new Observation(
                3,
                Observation.Direction.WEST,
                Observation.SeaState.SMOOTH,
                d1,
                new Reporter(
                        "Jane Doe",
                        "janedoe@example.com",
                        "12223334444"
                ),
                new Location(91.4634, 155.3117),
                new SightingPlatform(SightingPlatform.Platform.PLANE, "ofdo BootyMcBoatFace"),
                new ArrayList<Whale>(Arrays.asList(new Whale(
                        Whale.Species.GREY,
                        Whale.Confidence.PROBABLE,
                        new Whale.Behavior[]{
                                Whale.Behavior.PORPOISING,
                                Whale.Behavior.FEEDING
                        },
                        false,
                        "Scar on top"
                )))
        );

        Observation o5 = new Observation(
                4,
                Observation.Direction.EAST,
                Observation.SeaState.MODERATE_WAVES,
                d1,
                new Reporter(
                        "John Doe",
                        "johndoe@example.com",
                        "12308887777"
                ),
                new Location(61.4634, 133.3117),
                new SightingPlatform(SightingPlatform.Platform.PLANE, "lll BootyMcBoatFace"),
                new ArrayList<Whale>(Arrays.asList(new Whale(
                        Whale.Species.SPERM,
                        Whale.Confidence.POSSIBLE,
                        new Whale.Behavior[]{
                                Whale.Behavior.FLUKING,
                                Whale.Behavior.SPY_HOPPING
                        },
                        false,
                        "Scar on belly"
                )))
        );

        Observation o6 = new Observation(
                5,
                Observation.Direction.EAST,
                Observation.SeaState.MODERATE_WAVES,
                new Date(),
                new Reporter(
                        "John Doe",
                        "johndoe@example.com",
                        "12308887777"
                ),
                new Location(61.4634, 133.3117),
                new SightingPlatform(SightingPlatform.Platform.PLANE, "lll BootyMcBoatFace"),
                new ArrayList<Whale>(Arrays.asList(new Whale(
                        Whale.Species.SPERM,
                        Whale.Confidence.POSSIBLE,
                        new Whale.Behavior[]{
                                Whale.Behavior.FLUKING,
                                Whale.Behavior.SPY_HOPPING
                        },
                        false,
                        "Scar on belly"
                )))
        );

        Observation o7 = new Observation(
                6,
                Observation.Direction.EAST,
                Observation.SeaState.MODERATE_WAVES,
                new Date(),
                new Reporter(
                        "John Doe",
                        "johndoe@example.com",
                        "12308887777"
                ),
                new Location(61.4634, 133.3117),
                new SightingPlatform(SightingPlatform.Platform.PLANE, "lll BootyMcBoatFace"),
                new ArrayList<Whale>(Arrays.asList(new Whale(
                        Whale.Species.SPERM,
                        Whale.Confidence.POSSIBLE,
                        new Whale.Behavior[]{
                                Whale.Behavior.FLUKING,
                                Whale.Behavior.SPY_HOPPING
                        },
                        false,
                        "Scar on belly"
                )))
        );

        Observation o8 = new Observation(
                7,
                Observation.Direction.EAST,
                Observation.SeaState.MODERATE_WAVES,
                new Date(),
                new Reporter(
                        "John Doe",
                        "johndoe@example.com",
                        "12308887777"
                ),
                new Location(61.4634, 133.3117),
                new SightingPlatform(SightingPlatform.Platform.PLANE, "lll BootyMcBoatFace"),
                new ArrayList<Whale>(Arrays.asList(new Whale(
                        Whale.Species.SPERM,
                        Whale.Confidence.POSSIBLE,
                        new Whale.Behavior[]{
                                Whale.Behavior.FLUKING,
                                Whale.Behavior.SPY_HOPPING
                        },
                        false,
                        "Scar on belly"
                )))
        );

        Observation o9 = new Observation(
                8,
                Observation.Direction.EAST,
                Observation.SeaState.MODERATE_WAVES,
                new Date(),
                new Reporter(
                        "John Doe",
                        "johndoe@example.com",
                        "12308887777"
                ),
                new Location(61.4634, 133.3117),
                new SightingPlatform(SightingPlatform.Platform.PLANE, "lll BootyMcBoatFace"),
                new ArrayList<Whale>(Arrays.asList(new Whale(
                        Whale.Species.SPERM,
                        Whale.Confidence.POSSIBLE,
                        new Whale.Behavior[]{
                                Whale.Behavior.FLUKING,
                                Whale.Behavior.SPY_HOPPING
                        },
                        false,
                        "Scar on belly"
                )))
        );

        Observation o10 = new Observation(
                9,
                Observation.Direction.EAST,
                Observation.SeaState.MODERATE_WAVES,
                new Date(),
                new Reporter(
                        "John Doe",
                        "johndoe@example.com",
                        "12308887777"
                ),
                new Location(61.4634, 133.3117),
                new SightingPlatform(SightingPlatform.Platform.PLANE, "lll BootyMcBoatFace"),
                new ArrayList<Whale>(Arrays.asList(new Whale(
                        Whale.Species.SPERM,
                        Whale.Confidence.POSSIBLE,
                        new Whale.Behavior[]{
                                Whale.Behavior.FLUKING,
                                Whale.Behavior.SPY_HOPPING
                        },
                        false,
                        "Scar on belly"
                )))
        );

        Observation o11 = new Observation(
                10,
                Observation.Direction.EAST,
                Observation.SeaState.MODERATE_WAVES,
                d1,
                new Reporter(
                        "John Doe",
                        "johndoe@example.com",
                        "12308887777"
                ),
                new Location(61.4634, 133.3117),
                new SightingPlatform(SightingPlatform.Platform.PLANE, "lll BootyMcBoatFace"),
                new ArrayList<Whale>(Arrays.asList(new Whale(
                        Whale.Species.SPERM,
                        Whale.Confidence.POSSIBLE,
                        new Whale.Behavior[]{
                                Whale.Behavior.FLUKING,
                                Whale.Behavior.SPY_HOPPING
                        },
                        false,
                        "Scar on belly"
                )))
        );

        Observation o12 = new Observation(
                11,
                Observation.Direction.EAST,
                Observation.SeaState.MODERATE_WAVES,
                d1,
                new Reporter(
                        "John Doe",
                        "johndoe@example.com",
                        "12308887777"
                ),
                new Location(61.4634, 133.3117),
                new SightingPlatform(SightingPlatform.Platform.PLANE, "lll BootyMcBoatFace"),
                new ArrayList<Whale>(Arrays.asList(new Whale(
                        Whale.Species.SPERM,
                        Whale.Confidence.POSSIBLE,
                        new Whale.Behavior[]{
                                Whale.Behavior.FLUKING,
                                Whale.Behavior.SPY_HOPPING
                        },
                        false,
                        "Scar on belly"
                )))
        );

        Observation o13 = new Observation(
                3,
                Observation.Direction.WEST,
                Observation.SeaState.SMOOTH,
                new Date(),
                new Reporter(
                        "Jane Doe",
                        "janedoe@example.com",
                        "12223334444"
                ),
                new Location(91.4634, 155.3117),
                new SightingPlatform(SightingPlatform.Platform.PLANE, "ofdo BootyMcBoatFace"),
                new ArrayList<Whale>(Arrays.asList(new Whale(
                        Whale.Species.GREY,
                        Whale.Confidence.PROBABLE,
                        new Whale.Behavior[]{
                                Whale.Behavior.PORPOISING,
                                Whale.Behavior.FEEDING
                        },
                        false,
                        "Scar on top"
                )))
        );

        Observation o14 = new Observation(
                3,
                Observation.Direction.WEST,
                Observation.SeaState.SMOOTH,
                new Date(),
                new Reporter(
                        "Jane Doe",
                        "janedoe@example.com",
                        "12223334444"
                ),
                new Location(91.4634, 155.3117),
                new SightingPlatform(SightingPlatform.Platform.PLANE, "ofdo BootyMcBoatFace"),
                new ArrayList<Whale>(Arrays.asList(new Whale(
                        Whale.Species.GREY,
                        Whale.Confidence.PROBABLE,
                        new Whale.Behavior[]{
                                Whale.Behavior.PORPOISING,
                                Whale.Behavior.FEEDING
                        },
                        false,
                        "Scar on top"
                )))
        );

        Observation o15 = new Observation(
                3,
                Observation.Direction.WEST,
                Observation.SeaState.SMOOTH,
                new Date(),
                new Reporter(
                        "Jane Doe",
                        "janedoe@example.com",
                        "12223334444"
                ),
                new Location(91.4634, 155.3117),
                new SightingPlatform(SightingPlatform.Platform.PLANE, "ofdo BootyMcBoatFace"),
                new ArrayList<Whale>(Arrays.asList(new Whale(
                        Whale.Species.GREY,
                        Whale.Confidence.PROBABLE,
                        new Whale.Behavior[]{
                                Whale.Behavior.PORPOISING,
                                Whale.Behavior.FEEDING
                        },
                        false,
                        "Scar on top"
                )))
        );

        Observation o16 = new Observation(
                3,
                Observation.Direction.WEST,
                Observation.SeaState.SMOOTH,
                new Date(),
                new Reporter(
                        "Jane Doe",
                        "janedoe@example.com",
                        "12223334444"
                ),
                new Location(91.4634, 155.3117),
                new SightingPlatform(SightingPlatform.Platform.PLANE, "ofdo BootyMcBoatFace"),
                new ArrayList<Whale>(Arrays.asList(new Whale(
                        Whale.Species.GREY,
                        Whale.Confidence.PROBABLE,
                        new Whale.Behavior[]{
                                Whale.Behavior.PORPOISING,
                                Whale.Behavior.FEEDING
                        },
                        false,
                        "Scar on top"
                )))
        );

        Observation o17 = new Observation(
                3,
                Observation.Direction.WEST,
                Observation.SeaState.SMOOTH,
                new Date(),
                new Reporter(
                        "Jane Doe",
                        "janedoe@example.com",
                        "12223334444"
                ),
                new Location(91.4634, 155.3117),
                new SightingPlatform(SightingPlatform.Platform.PLANE, "ofdo BootyMcBoatFace"),
                new ArrayList<Whale>(Arrays.asList(new Whale(
                        Whale.Species.GREY,
                        Whale.Confidence.PROBABLE,
                        new Whale.Behavior[]{
                                Whale.Behavior.PORPOISING,
                                Whale.Behavior.FEEDING
                        },
                        false,
                        "Scar on top"
                )))
        );

        Observation o18 = new Observation(
                3,
                Observation.Direction.WEST,
                Observation.SeaState.SMOOTH,
                new Date(),
                new Reporter(
                        "Jane Doe",
                        "janedoe@example.com",
                        "12223334444"
                ),
                new Location(91.4634, 155.3117),
                new SightingPlatform(SightingPlatform.Platform.PLANE, "ofdo BootyMcBoatFace"),
                new ArrayList<Whale>(Arrays.asList(new Whale(
                        Whale.Species.GREY,
                        Whale.Confidence.PROBABLE,
                        new Whale.Behavior[]{
                                Whale.Behavior.PORPOISING,
                                Whale.Behavior.FEEDING
                        },
                        false,
                        "Scar on top"
                )))
        );

        Observation o19 = new Observation(
                3,
                Observation.Direction.WEST,
                Observation.SeaState.SMOOTH,
                d1,
                new Reporter(
                        "Jane Doe",
                        "janedoe@example.com",
                        "12223334444"
                ),
                new Location(91.4634, 155.3117),
                new SightingPlatform(SightingPlatform.Platform.PLANE, "ofdo BootyMcBoatFace"),
                new ArrayList<Whale>(Arrays.asList(new Whale(
                        Whale.Species.GREY,
                        Whale.Confidence.PROBABLE,
                        new Whale.Behavior[]{
                                Whale.Behavior.PORPOISING,
                                Whale.Behavior.FEEDING
                        },
                        false,
                        "Scar on top"
                )))
        );

        Observation o20 = new Observation(
                3,
                Observation.Direction.WEST,
                Observation.SeaState.SMOOTH,
                d1,
                new Reporter(
                        "Jane Doe",
                        "janedoe@example.com",
                        "12223334444"
                ),
                new Location(91.4634, 155.3117),
                new SightingPlatform(SightingPlatform.Platform.PLANE, "ofdo BootyMcBoatFace"),
                new ArrayList<Whale>(Arrays.asList(new Whale(
                        Whale.Species.GREY,
                        Whale.Confidence.PROBABLE,
                        new Whale.Behavior[]{
                                Whale.Behavior.PORPOISING,
                                Whale.Behavior.FEEDING
                        },
                        false,
                        "Scar on top"
                )))
        );

        Observation o21 = new Observation(
                3,
                Observation.Direction.WEST,
                Observation.SeaState.SMOOTH,
                new Date(),
                new Reporter(
                        "Jane Doe",
                        "janedoe@example.com",
                        "12223334444"
                ),
                new Location(91.4634, 155.3117),
                new SightingPlatform(SightingPlatform.Platform.PLANE, "ofdo BootyMcBoatFace"),
                new ArrayList<Whale>(Arrays.asList(new Whale(
                        Whale.Species.GREY,
                        Whale.Confidence.PROBABLE,
                        new Whale.Behavior[]{
                                Whale.Behavior.PORPOISING,
                                Whale.Behavior.FEEDING
                        },
                        false,
                        "Scar on top"
                )))
        );

        Observation o22 = new Observation(
                3,
                Observation.Direction.WEST,
                Observation.SeaState.SMOOTH,
                new Date(),
                new Reporter(
                        "Jane Doe",
                        "janedoe@example.com",
                        "12223334444"
                ),
                new Location(91.4634, 155.3117),
                new SightingPlatform(SightingPlatform.Platform.PLANE, "ofdo BootyMcBoatFace"),
                new ArrayList<Whale>(Arrays.asList(new Whale(
                        Whale.Species.GREY,
                        Whale.Confidence.PROBABLE,
                        new Whale.Behavior[]{
                                Whale.Behavior.PORPOISING,
                                Whale.Behavior.FEEDING
                        },
                        false,
                        "Scar on top"
                )))
        );

        Observation o23 = new Observation(
                3,
                Observation.Direction.WEST,
                Observation.SeaState.SMOOTH,
                d1,
                new Reporter(
                        "Jane Doe",
                        "janedoe@example.com",
                        "12223334444"
                ),
                new Location(91.4634, 155.3117),
                new SightingPlatform(SightingPlatform.Platform.PLANE, "ofdo BootyMcBoatFace"),
                new ArrayList<Whale>(Arrays.asList(new Whale(
                        Whale.Species.GREY,
                        Whale.Confidence.PROBABLE,
                        new Whale.Behavior[]{
                                Whale.Behavior.PORPOISING,
                                Whale.Behavior.FEEDING
                        },
                        false,
                        "Scar on top"
                )))
        );

        Observation o24 = new Observation(
                3,
                Observation.Direction.WEST,
                Observation.SeaState.SMOOTH,
                new Date(),
                new Reporter(
                        "Jane Doe",
                        "janedoe@example.com",
                        "12223334444"
                ),
                new Location(91.4634, 155.3117),
                new SightingPlatform(SightingPlatform.Platform.PLANE, "ofdo BootyMcBoatFace"),
                new ArrayList<Whale>(Arrays.asList(new Whale(
                        Whale.Species.GREY,
                        Whale.Confidence.PROBABLE,
                        new Whale.Behavior[]{
                                Whale.Behavior.PORPOISING,
                                Whale.Behavior.FEEDING
                        },
                        false,
                        "Scar on top"
                )))
        );

        Observation o25 = new Observation(
                3,
                Observation.Direction.WEST,
                Observation.SeaState.SMOOTH,
                d1,
                new Reporter(
                        "Jane Doe",
                        "janedoe@example.com",
                        "12223334444"
                ),
                new Location(91.4634, 155.3117),
                new SightingPlatform(SightingPlatform.Platform.PLANE, "ofdo BootyMcBoatFace"),
                new ArrayList<Whale>(Arrays.asList(new Whale(
                        Whale.Species.GREY,
                        Whale.Confidence.PROBABLE,
                        new Whale.Behavior[]{
                                Whale.Behavior.PORPOISING,
                                Whale.Behavior.FEEDING
                        },
                        false,
                        "Scar on top"
                )))
        );

        Observation o26 = new Observation(
                3,
                Observation.Direction.WEST,
                Observation.SeaState.SMOOTH,
                new Date(),
                new Reporter(
                        "Jane Doe",
                        "janedoe@example.com",
                        "12223334444"
                ),
                new Location(91.4634, 155.3117),
                new SightingPlatform(SightingPlatform.Platform.PLANE, "ofdo BootyMcBoatFace"),
                new ArrayList<Whale>(Arrays.asList(new Whale(
                        Whale.Species.GREY,
                        Whale.Confidence.PROBABLE,
                        new Whale.Behavior[]{
                                Whale.Behavior.PORPOISING,
                                Whale.Behavior.FEEDING
                        },
                        false,
                        "Scar on top"
                )))
        );

        Observation o27 = new Observation(
                3,
                Observation.Direction.WEST,
                Observation.SeaState.SMOOTH,
                new Date(),
                new Reporter(
                        "Jane Doe",
                        "janedoe@example.com",
                        "12223334444"
                ),
                new Location(91.4634, 155.3117),
                new SightingPlatform(SightingPlatform.Platform.PLANE, "ofdo BootyMcBoatFace"),
                new ArrayList<Whale>(Arrays.asList(new Whale(
                        Whale.Species.GREY,
                        Whale.Confidence.PROBABLE,
                        new Whale.Behavior[]{
                                Whale.Behavior.PORPOISING,
                                Whale.Behavior.FEEDING
                        },
                        false,
                        "Scar on top"
                )))
        );

        Observation o28 = new Observation(
                3,
                Observation.Direction.WEST,
                Observation.SeaState.SMOOTH,
                new Date(),
                new Reporter(
                        "Jane Doe",
                        "janedoe@example.com",
                        "12223334444"
                ),
                new Location(91.4634, 155.3117),
                new SightingPlatform(SightingPlatform.Platform.PLANE, "ofdo BootyMcBoatFace"),
                new ArrayList<Whale>(Arrays.asList(new Whale(
                        Whale.Species.GREY,
                        Whale.Confidence.PROBABLE,
                        new Whale.Behavior[]{
                                Whale.Behavior.PORPOISING,
                                Whale.Behavior.FEEDING
                        },
                        false,
                        "Scar on top"
                )))
        );

        Observation o29 = new Observation(
                3,
                Observation.Direction.WEST,
                Observation.SeaState.SMOOTH,
                d1,
                new Reporter(
                        "Jane Doe",
                        "janedoe@example.com",
                        "12223334444"
                ),
                new Location(91.4634, 155.3117),
                new SightingPlatform(SightingPlatform.Platform.PLANE, "ofdo BootyMcBoatFace"),
                new ArrayList<Whale>(Arrays.asList(new Whale(
                        Whale.Species.GREY,
                        Whale.Confidence.PROBABLE,
                        new Whale.Behavior[]{
                                Whale.Behavior.PORPOISING,
                                Whale.Behavior.FEEDING
                        },
                        false,
                        "Scar on top"
                )))
        );

        Observation o30 = new Observation(
                3,
                Observation.Direction.WEST,
                Observation.SeaState.SMOOTH,
                d1,
                new Reporter(
                        "Jane Doe",
                        "janedoe@example.com",
                        "12223334444"
                ),
                new Location(91.4634, 155.3117),
                new SightingPlatform(SightingPlatform.Platform.PLANE, "ofdo BootyMcBoatFace"),
                new ArrayList<Whale>(Arrays.asList(new Whale(
                        Whale.Species.GREY,
                        Whale.Confidence.PROBABLE,
                        new Whale.Behavior[]{
                                Whale.Behavior.PORPOISING,
                                Whale.Behavior.FEEDING
                        },
                        false,
                        "Scar on top"
                )))
        );


        monitor.addObservation(o1);
        monitor.addObservation(o2);
        monitor.addObservation(o3);
        monitor.addObservation(o4);
        monitor.addObservation(o5);
        monitor.addObservation(o6);
        monitor.addObservation(o7);
        monitor.addObservation(o8);
        monitor.addObservation(o9);
        monitor.addObservation(o10);
        monitor.addObservation(o11);
        monitor.addObservation(o12);
        monitor.addObservation(o13);
        monitor.addObservation(o14);
        monitor.addObservation(o15);
        monitor.addObservation(o16);
        monitor.addObservation(o17);
        monitor.addObservation(o18);
        monitor.addObservation(o19);
        monitor.addObservation(o20);
        monitor.addObservation(o21);
        monitor.addObservation(o22);
        monitor.addObservation(o23);
        monitor.addObservation(o24);
        monitor.addObservation(o25);
        monitor.addObservation(o26);
        monitor.addObservation(o27);
        monitor.addObservation(o28);
        monitor.addObservation(o29);
        monitor.addObservation(o30);

        System.out.println(o1.getSightingTime() + o1.getReporter().getName());
        System.out.println(o2.getSightingTime() + o2.getReporter().getName());
        System.out.println(o3.getSightingTime() + o3.getReporter().getName());
        System.out.println(o4.getSightingTime() + o4.getReporter().getName());

        System.out.println(monitor.searchBySightingTime(d1));
        System.out.println(monitor.searchBySightingTime(d1).size());

        /*System.out.println(monitor.searchBySightingTime(d1).get(0).getWindSpeed());
        System.out.println(monitor.searchBySightingTime(d1).get(1).getWindSpeed());
        System.out.println(monitor.searchBySightingTime(d1).get(2).getWindSpeed());
        System.out.println(monitor.searchBySightingTime(d1).get(3).getWindSpeed());
        System.out.println(monitor.searchBySightingTime(d1).get(4).getWindSpeed());
        System.out.println(monitor.searchBySightingTime(d1).get(5).getWindSpeed());
        System.out.println(monitor.searchBySightingTime(d1).get(6).getWindSpeed());
        System.out.println(monitor.searchBySightingTime(d1).get(7).getWindSpeed());
        System.out.println(monitor.searchBySightingTime(d1).get(8).getWindSpeed());
        System.out.println(monitor.searchBySightingTime(d1).get(9).getWindSpeed());*/

        System.out.println(monitor.searchByObservationId(o3.getObservationId()));
    }

}