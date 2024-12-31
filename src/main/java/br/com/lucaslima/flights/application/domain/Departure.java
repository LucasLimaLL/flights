package br.com.lucaslima.flights.application.domain;

import java.time.Instant;

public class Departure {

    private final String iataCode;
    private final Instant date;

    public Departure(String iataCode, Instant date) {
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