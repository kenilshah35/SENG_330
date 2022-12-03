# Decision 1: Redesign the layout

## Status

Accepted

## 

## Context

The original design only allows users to report an observation below 10 whales. 
The interface is also not user-friendly. The layout had no instructions, or the ability
to remove observations.

## 

## Decision

We decided to move the components around to make it more visible and understandable to the users. 
One of the changes was to move all the output to the left half column and put all the input
in a form style in the right half pane. A text box has been added to accommodate observations of more than 10 whales.
A help box was added to explain to users how to interact with the interface.
Some less obvious changes include having axis labels that are limited to integers only to prevent reporting partial whales
which is outside the input space.

The functionality to remove observations was added using a "Reset Graph" button.

## 

## Consequences

The users are able to input an observation of more than 10 whales. However, if there are fewer than 10 whales spotted,
they can still choose to use the slider bar. The interface becomes more user-friendly after the redesign. 
The app is now able to remove data to accommodate more user interactions. 

# 

# Decision 2: Injecting Action Handlers to the Buttons


## Status

Accepted

## 

## Context

We decide to keep the "Submit" button and add the "Reset Graph" and "Help" buttons. 
Using multiple handlers can generate different events which increase the complexity of the system.
As the number of JavaFX panels increases it becomes untenable to maintain references to all of the relevant nodes.
With many panels, there is quickly a significant amount of coupling.

## 

## Decision

To extract the coupling the decision was to inject event handlers to the trigger objects. In this case,
event handlers are injected to the two buttons. The handler lambda contains the object references and the Button classes
do not need any external references.

## 

## Consequences

We managed to reduce coupling in the button classes, and all the buttons work smoothly.

# 

# Decision 3: Use ObservableMap within ObservationData

## Status

Accepted

## 

## Context

All the `Observer`s need to be informed if there's any change in the data stored inside the model.

## 

## Decision

We decided to use `ObservableMap` inside of `ObservationData` this system collection allows the data to be exposed
without risking a change occuring without the `Observer`s being notified.
We considered making `getObservationData()` return an immutable copy of the map to ensure that no change could be made 
to the internal data without notification, but it was decided that this could be very restrictive.
Using the `ObservableMap` meant that this issue never occurs because `ObservationData` will be notified of external
changes and pass that along to all `Observer`s

## 

## Consequences

Any map change, whether caused by calls to `setObservationData` `addObservation` or through `getObservationData`.anyAction()
will always result in `Observer.onUpdatedMap()` being called. This behaviour is tested in `ObservationDataTest`.
