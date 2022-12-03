# Reporter class within the observation class or visa versa 

## Status

Accepted.

## Context

Keeping track of the reporters is very important, and a decision needed to be made on how the 
software design should look. This would affect the use of the system when analyzing the observations 
and keeping a track of who observed what (for credibility purposes). 

## Decision

We decided that the reporter class should be a part of the observation class.

## Consequences

With our decision keeping track of "observation attributes" becomes easier. It is too early to say
how this program is going to be used, however, this design decision allows us to give precedence to
the observation rather than the reporter. 
