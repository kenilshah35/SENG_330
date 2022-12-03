# Search strategy - 2 by Sighting Time

## Status

Accepted

## Context

A method to search our list of whale observation was needed.
Searching the list using the sighting time, which returns all the whale observation made at the same time.

## Decision

Added a functionality to search the list of whale obsevervation corresponding to a sighting time. As well as have all Observations that match the given time be returned.

## Consequences

Adding this search strategy, will help the user find all the whale observations made during a certain time. This data can help them to pinpoint whale locations with higher accuracy. In addition, we can build off our implementation of sorting by sighting time.
However this implementation is lacking, as it requires and exact date and time to search for. Moving forward, we would consider adding flexibility to the sighting time requested. For example, a user could pass a day, week, or month, and receive all Observations for that period.
