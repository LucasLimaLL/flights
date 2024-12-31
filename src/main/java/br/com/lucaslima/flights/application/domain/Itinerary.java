package br.com.lucaslima.flights.application.domain;

import java.time.Duration;

public class Itinerary {

    private final Departure departure;
    private final Arrival arrival;
    private final Duration duration;

    public Itinerary(Departure departure, Arrival arrival, Duration duration) {
        this.departure = departure;
        this.arrival = arrival;
        this.duration = duration;
    }

    public Departure getDeparture() {
        return departure;
    }

    public Arrival getArrival() {
        return arrival;
    }

    public Duration getDuration() {
        return duration;
    }
}
