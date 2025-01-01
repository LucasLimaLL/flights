package br.com.lucaslima.flights.application.domain;

import java.time.ZonedDateTime;

public class Arrival {

    private final String iataCode;
    private final ZonedDateTime date;

    public Arrival(String iataCode, ZonedDateTime date) {
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
