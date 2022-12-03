# Comparators

## Status

Accepted

## Context

In order to meet requirements we need to have two strategies for both searching and sorting our observations.

## Decision

We chose to implement the Comparator<T> interface from the java.util library as an interface for two comparator implementations. One compares the timestamps of the observations, and the other compares the reporters' emails. They are defined in the Observation class.

## Consequences

Defining the comparators inside the Observation class removes their dependency on the Observation class's getters, enabling them to be removed in the future.

Comparing observations based on their timestamps is a straightforward choice. It allows us to, for instance, see the most recent observations once the list is sorted. It's also a nearly unique identifier, enabling us to perform a binary search that is very likely to return the observation we're looking for. On the other hand, since it's not truly unique, there could be rare problem cases. Adding a unique identifier to the Observation class and using it as a basis for comparison would be one way of solving this issue.

Using the reporter's email to compare observations is the alternative provided strategy. It doesn't work very well as an identifier of the observation, but is useful nonetheless. It is not unlikely for a reporter's email to be associated with several observations. This means using it as a basis for searching the collection would return an arbitrary observation made by the given reporter. However this strategy has a clear upside of allowing us to sort the observations by their reporter, and in the future, collect a list of observations made by a reporter. This is possible thanks to email being a unique identifier of a reporter.
