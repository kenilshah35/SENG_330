# Logger

## Status

Accepted

## Context

The relationships of the data themselves are defined, but the structure in which to contain them needs to be determined. The Observation class in our design contains the references to both the Reporter and Whale classes. We need to decide on a way to represent a collection of Observations.

## Decision

We chose to add a new class called Logger. The Logger class encapsulates all the data being logged for the Whale Monitoring System. It provides in its public interface a method for adding new observations, a method for retrieving a copy of the observation log, and a method for checking how many observations of a given species have been submitted. The internal implementation includes a simple ArrayList of Observation objects, and a HashMap tracking the number of observations of each species. This HashMap maps the type Whale.Whalespecies to the type Integer.

## Consequences

The drawbacks of this decision are reducible to the drawbacks of adding a new class to any codebase. It introduces more work upfront and more complexity. However the benefits of a Logger class are many - namely extensibility and flexibility.
    
- It encapsulates all the data for the Whale Monitoring System, allowing us to constrain retrieval and modification of the internal data.
    
- It would allow us to easily implement additional tracking and data analysis by simply including them in the Logger class. Tracking the number of each species is implemented as an example of this feature.
    
- It enables us to separate the interface from the underlying data representation.
    
- It enables multiple independent databases. This could be used to store a history of the database, or separate data according to some set of conditions.
