## Whale Confidence Comparator

## Status

Accepted

## Context

We need to implement a method to sort the list of Whales. Sorting Whales by their confidence levels should make the program simple and intuitive for the users and the programmers.

## Decision

Adding a functionality to sort the list of Whales by their confidence level. We will be doing this by the object function strategy of creating nested Comparator class "WhaleConfidenceComparator".

## Consequences

Implementing this sorting strategy will allow the users of this system to sort the observed Whales based on the condifence levels to help them justify their data.
Using the nested Comparator class strategy will keep the program simple and flexible to use for future users and/or programmers.
