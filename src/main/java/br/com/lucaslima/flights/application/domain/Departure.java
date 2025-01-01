package br.com.lucaslima.flights.application.domain;

import java.time.ZonedDateTime;

public class Departure {

    private final String iataCode;
    private final ZonedDateTime date;

    public Departure(String iataCode, ZonedDateTime date) {
        this.iataCode = iataCode;
        this.date = date;
    }

    public String getIataCode() {
        return iataCode;
    }

    public ZonedDateTime getDate() {
        return date;
    }
}
