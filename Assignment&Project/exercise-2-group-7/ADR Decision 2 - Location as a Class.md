
# How to implement the Location of an Observation

## Status

Accepted.

## Context

Location of the whale or whales is an important field to record in an observation. It could be done a several different ways. A decision needed to be made on how to implement it. This decision would effect later use of the system, especially when analyzing observations and tracking the locations they took place.

## Decision

We decided to have Location be its own small class consisting of two doubles. "latitude" and "longitude" as they are a familiar method for global positioning  .

## Consequences

With our decision, entering location should be simple for the user as latitude/longitude measurements are very common throughout the world.
More yet, having Location in its own class with doubles will all for mathematical operations to simply be performed. Since at the time writing this we are unaware of how this system will be used, this decision allows the greatest flexibility for users.
A possible use we foresaw was computing the distance between pairs of observations to track a certain whale or whale pod. With the decision we have gone with, this would be easy.
