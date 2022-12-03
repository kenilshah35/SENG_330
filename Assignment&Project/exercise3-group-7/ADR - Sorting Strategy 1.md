## Sorting Strategy 1 - Sort by Sighting Time

## Status

Accepted

## Context

A method to sort our list of Observations is needed. Sorting by their the time the observation took place should be a simple and intuitive method, both to the user and to the implementer.

## Decision

Add functionality to sort a list of Observations by their SightingTime. This will be done using the an nested factory method which anonymous creates a Comparator for Observations sighting time.

## Consequences

Adding this sorting strategy should reflect typical use of the system by end users. It will allow users of the system to order all Observations present by their recency.
We hope using the nested factory method for the Comparator will balance code simplicity, readability, and future proofing for if/when the system evolves and changes. Also this method should help maintain object encapsulation.
Ideally, this will keep the system as flexible as possible for future user/designers/programmers etc.
