package br.com.lucaslima.flights.application.domain;

import java.time.Duration;

public class Itinerary {

    private final Departure departure;
    private final Arrival arrival;
    private final Duration duration;

    public Itinerary(Departure departure, Arrival arrival) {
        this.departure = departure;
        this.arrival = arrival;
        this.duration = departure == null || arrival == null ? Duration.ZERO : Duration.between(arrival.getDate(), departure.getDate());
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
