# Title
Observation Collection Search Implementation

## Status

Accepted

## Context

Some method to search a collection of observations needs to exist.
Our team has decided on using comparators to distinguish one observation
from another.

## Decision

Inside our search() method, we have decided to use Collections.binarySearch().

## Consequences

Because binary search simply returns a single index - the index of an observation
in the collection matching the given criteria, only a single observation will be
returned. It is entirely possible that multiple observations in the collection possess
the appropriate attributes to be returned, and thus it would be difficult to implement
a strategy to find them all, while using the binary search algorithm. For this reason,
our team will keep using binary search, however at a later date, this strategy will be
re-thought, with the possibility of returning multiple observations kept in mind.
