# A Monitor class to manage Observation instances

## Status

Accepted.

## Context

Each instance of our Observation class stores information related to a single whale spotting. In
a realistic whale monitoring system, the user would want to store many observations. Two
potential options are to leave it up to the user to store the observations in their own data
structure, or to create a class to manage the storage of observations for the user.

## Decision

We decided to create a Monitor class that maintains an internal ArrayList of whale observations.
The user of the monitor class interacts with the stored observations though the various methods
in Monitor.java class which restricts their access to the underlying ArrayList.

## Consequences

This change lets us dictate how Observations are stored, allowing us to more easily implement
features requiring changes to that storage strategy. We are able to switch between storage
strategies without introducing breaking changes to whatever codebases might already be using the 
whale monitoring system. We can also use this layer as a place to implement functionality like 
sorting, filtering, or exporting observations.
