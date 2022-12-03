# Whale Observations

## Status

✅ accepted

## Context

Whales can travel in groups but also as one, we need a way to capture whales traveling as a group but also as one in our `Observation` class

## Decision

We choose to use an `ArrayList` of type `Whale` class to specify a group of whales in our `Observation` Class

## Consequences

- Easier to grab the whole set of whales from the observation
- Downside is many observations will just have an array list of size 1 specifying that the observers only saw one whale which seems like a waste of having a list of size 1
