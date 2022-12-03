# Change codebase according to TA feedback

## Status

Accepted

## Context

In order to start working on this exercise, we need an existing codebase which fits our requirements and is functional.

## Decision

For our codebase, we have decided to go with Blaise MacIsaac's ex 3 code.

## Consequences

This particular codebase was chosen because the Driver class does a good job in showing the code's functionality, which makes it easier for other members to understand functionality of each class. The codebase had extensive and well documented unit testing. Also, having a way to count number of observations per whale species using a hash map had tangible real world usage.

On the other hand, this code has to be reformatted to meet checkstyle requirements. Also, there is no interface implemented for Iterable over a collection of observations. Plus, the ObservationCollection class, even though well encapsulated is cluttered.




