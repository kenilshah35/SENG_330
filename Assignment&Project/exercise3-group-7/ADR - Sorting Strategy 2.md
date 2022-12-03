## Sorting Strategy 2 - Sort by Latitude

## Status

Accepted

## Context

A method to sort our list of Observations is needed. Sorting the observations by Latitude would be useful to clients to track how far north various species of whales have been observed. This also makes sense from an implementation point of view because there is a clearly defined order to latitude measurements.

## Decision

Add functionality to sort a list of Observations by their Latitude (stored in a location object). This functionality will be added by providing a comparator which compares Observations based on their latitudes. This comparator will be accessed through a static factory method which anonymously constructs a new Comparator<Observation>. 

## Consequences

The latitude sorting strategy reflects how the system realistically might be used by its clients
; they are now able to easily find, for example, the northernmost whale sighting that has been recorded in the system. Providing access to the latitude comparator through a factory method helps us maintain strong encapsulation. This will keep the system as flexible as possible for future maintainers.
