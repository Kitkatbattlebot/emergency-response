# Emergency Response

A Java program that simulatesan emergency response system. The program recieves a
certain number of requests per simulated day and generates dispatch messages for 
the requests, in priority order.

The objectives of this assignment are to become more familiar with Java
interfaces, enumerated types, and data structures.

Your program will simulate receiving requests by reading strings from a data
file (see tiny.txt, small.txt, medium.txt for examples). Each request has an
id number followed by one more more natural language sentences in English. For
example:

971: I'm currently staying at Bon Jovi and my vehicle is stuck.

In order to dispatch the appropriate emergency response unit the program needs
to determine the location of the request and the type of emergency. There are
four types: vehicle problems, facilities problems (e.g., leaking pipes in your
house), medical problems, and environmental problems (e.g., a huge whole in
the dome over the station).

Your program needs to determine the type of emergency based on the English
text. This will require analysis of the data in the sample data files to see
what type of things people are asking for.

In addition to understanding the type of emergency, your program needs to
prioritize the emergencies and respond in priority order. Each request is
either high, medium, or low priority. The priority of the requests is defined
by the following set of rules:

- vehicle problems: accidents are high priority, everything else is low
- facility problems: everything is low
- medical problems: breathing problems and seizures are high, everything
  else is medium
- environment problems: all are high

All high priority requests are dispatched on the same day that they arrive.

In order to balance resources between all of the stations, each station is
only allowed a certain number of emergency dispatches per day. After
dispatching all of the high requests, if any station is under the daily limit,
your program should dispatch medium and low priority requests to that
station. These should be done in priority order, that is, medium before low.
Note that ALL high requests are handled, even if this puts a station over the
limit. In this situation, none of the medium or low requests would be
processed for that station (since they are over the daily limit).

Two requests with the same priority are to be handled in a first come first
served order. This is tracked with the request id.

To summarize, each day your program reads in REQUESTS_PER_DAY new
requests. For each request it determines the target station, the request type,
and the request priority. Then, for that day, it processing requests as follows:

1) Dispatch all HIGH requests, in first come first served order
2) Continuing dispatching medium and low requests until all requests are
processed or all stations are at the STATION_MAX limit. 

It is likely that there will be unanswered requests at the end of some
days. Those requests should carry over to the next day.

Your simluation should print the day number (starting at day 1) and the number
of requests that are being carried over from the previous day. For example:

======= Processing requests for day 23
======= 32 requests carried over from previous day

The simulation should continue to run until there are no more requests to process.

For this program the REQUESTS_PER_DAY should be set to 20 and the STATION_MAX
should be set to 3.
