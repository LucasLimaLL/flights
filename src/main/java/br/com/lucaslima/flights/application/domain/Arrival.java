package br.com.lucaslima.flights.application.domain;

import java.time.Instant;

public class Arrival {

    private final String iataCode;
    private final Instant date;

    public Arrival(String iataCode, Instant date) {
        this.iataCode = iataCode;
        this.date = date;
    }

    public String getIataCode() {
        return iataCode;
    }

    public Instant getDate() {
        return date;
    }
}
