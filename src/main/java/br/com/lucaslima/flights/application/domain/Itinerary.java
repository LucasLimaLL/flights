package br.com.lucaslima.flights.application.domain;

import java.time.Duration;

public class Itinerary {

    private final String company;
    private final Departure departure;
    private final Arrival arrival;
    private final Duration duration;

    public Itinerary(String company, Departure departure, Arrival arrival) {
        this.company = company;
        this.departure = departure;
        this.arrival = arrival;
        this.duration = departure == null || arrival == null ? Duration.ZERO : Duration.between(departure.getDate(), arrival.getDate());
    }

    public String getCompany() {
        return company;
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
