## Observation ID field 

## Status

Accepted

## Context

Previously the observation ID field was set to final. This led to issues while implementing a search strategy using Observation ID. 

## Decision

The field is no longer set to final. This allowed us to implement a setter method for Observation ID

## Consequences

With this change, implementing a method to search observations using observation ID was made simpler and allows much more flexibility for implementation.
Also proper encapsulation should be preserved as the ID field is a String.
