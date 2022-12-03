# Optional return values

## Status

Accepted

## Context

Certain values in the Observation class make sense to be null, so we would rather not reject null values for them outright. This is specifically referring to *Observation.sightingPlatform* and *Observation.whaleHeading*.

## Decision

We propose accepting null values for both *Observation.sightingPlatform* and *Observation.whaleHeading*, and returning in their getters the types Optional<SightingPlatform> and Optional<Cardinal> respectively. 

## Consequences

The downside of this decision is that it not only keeps the complexity of handling null values, but it adds some wordiness to the process as well. One upside is that the Optional type forces the caller to handle the null value in their code, ensuring no unexpected null pointer exceptions happen. Keeping the null value also provides a simple way of representing the fact that *Observation.sightingPlatform* and *Observation.whaleHeading* are optional input fields, nonessential to functionality.
