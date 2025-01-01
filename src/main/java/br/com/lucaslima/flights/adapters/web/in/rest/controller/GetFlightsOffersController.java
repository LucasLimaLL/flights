package br.com.lucaslima.flights.adapters.web.in.rest.controller;

import br.com.lucaslima.flights.application.ports.in.GetFlightOffersUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.ZonedDateTime;

@RestController
public class GetFlightsOffersController {

    private final GetFlightOffersUseCase getFlightOffersUseCase;

    public GetFlightsOffersController(GetFlightOffersUseCase getFlightOffersUseCase) {
        this.getFlightOffersUseCase = getFlightOffersUseCase;
    }

    @GetMapping("/flights")
    public ResponseEntity<?> getFlightsOffers(
            @RequestParam(name = "iataCodeDeparture") String iataCodeDeparture,
            @RequestParam(name = "iataCodeArrival") String iataCodeArrival,
            @RequestParam(name = "nonStop") boolean nonStop,
            @RequestParam(name = "daysToDeparture") int daysToDeparture,
            @RequestParam(name = "desiredDate") String desiredDate,
            @RequestParam(name = "precision") int precision
    ) {

        var offers = getFlightOffersUseCase.search(iataCodeDeparture, iataCodeArrival, nonStop, daysToDeparture, ZonedDateTime.parse(desiredDate), precision);

        return ResponseEntity.ok(offers);
    }
}
