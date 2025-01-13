package br.com.lucaslima.flights.application.domain;

import java.time.Duration;
import java.util.List;

public class FlightOffer {

    private final List<Itinerary> itineraries;
    private final Price price;
    private final Duration duration;
    private final Departure firstDeparture;
    private final Arrival lastArrival;

    public FlightOffer(List<Itinerary> itineraries, Price price, Departure firstDeparture, Arrival lastArrival) {
        this.itineraries = itineraries;
        this.price = price;
        this.firstDeparture = firstDeparture;
        this.lastArrival = lastArrival;
        this.duration = firstDeparture == null || lastArrival == null ? Duration.ZERO : Duration.between(firstDeparture.getDate(), lastArrival.getDate());
    }

    public List<Itinerary> getItineraries() {
        return itineraries;
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
