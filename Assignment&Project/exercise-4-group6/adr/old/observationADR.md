# Observation Object

## Status

Accepted

## Context

In order to create the backend for a whale monitoring system, we need to have some way to capture the idea
of an observation. 

## Decision

Abstract the details that go along with the act of observing a whale into
a single cohesive, simple data structure.

## Consequences

- Capturing the details of an observation is made extremely simple, as the Observation object itself almost
mimics the idea of filling out a form on paper, where the reporter of the observation fills out their 
details as well as the details of the observation that was made.

- The details behind the maintenance of this data structure is kept hidden from a client who wishes to use
this code.
