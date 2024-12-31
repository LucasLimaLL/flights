package br.com.lucaslima.flights.application.domain;

import java.time.Duration;
import java.util.List;

public class FlightOffer {

    private final List<Itinerary> itinararies;
    private final Price price;
    private final Duration duration;
    private final Departure firstDeparture;
    private final Arrival lastArrival;

    public FlightOffer(List<Itinerary> itinararies, Price price, Duration duration, Departure firstDeparture, Arrival lastArrival) {
        this.itinararies = itinararies;
        this.price = price;
        this.duration = duration;
        this.firstDeparture = firstDeparture;
        this.lastArrival = lastArrival;
    }

    public List<Itinerary> getItinararies() {
        return itinararies;
    }

    public Price getPrice() {
        return price;
    }

    public Duration getDuration() {
        return duration;
    }

    public Departure getFirstDeparture() {
        return firstDeparture;
    }

    public Arrival getLastArrival() {
        return lastArrival;
    }
}
