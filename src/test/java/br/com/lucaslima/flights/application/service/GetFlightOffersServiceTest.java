package br.com.lucaslima.flights.application.service;

import br.com.lucaslima.flights.application.domain.FlightOffer;
import br.com.lucaslima.flights.application.ports.out.GetFlightOffersPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class GetFlightOffersServiceTest {

    private GetFlightOffersPort getFlightOffersPort;
    private GetFlightOffersService getFlightOffersService;

    @BeforeEach
    void setUp() {
        getFlightOffersPort = Mockito.mock(GetFlightOffersPort.class);
        getFlightOffersService = new GetFlightOffersService(getFlightOffersPort);
    }

    @Test
    @DisplayName("Should return flight offers for given parameters")
    void shouldReturnFlightOffersForGivenParameters() {
        List<FlightOffer> expectedOffers = new ArrayList<>();
        when(getFlightOffersPort.search(anyString(), anyString(), any(), any(), anyInt(), anyBoolean(), anyString()))
                .thenReturn(expectedOffers);

        List<FlightOffer> actualOffers = getFlightOffersService.search("JFK", "LAX", true, ZonedDateTime.now(), ZonedDateTime.now().plusDays(1));

        assertEquals(expectedOffers, actualOffers);
        verify(getFlightOffersPort, times(1)).search(anyString(), anyString(), any(), any(), anyInt(), anyBoolean(), anyString());
    }

    @Test
    @DisplayName("Should return empty list when no offers found")
    void shouldReturnEmptyListWhenNoOffersFound() {
        when(getFlightOffersPort.search(anyString(), anyString(), any(), any(), anyInt(), anyBoolean(), anyString()))
                .thenReturn(new ArrayList<>());

        List<FlightOffer> actualOffers = getFlightOffersService.search("JFK", "LAX", true, ZonedDateTime.now(), ZonedDateTime.now().plusDays(1));

        assertEquals(0, actualOffers.size());
        verify(getFlightOffersPort, times(1)).search(anyString(), anyString(), any(), any(), anyInt(), anyBoolean(), anyString());
    }

    @Test
    @DisplayName("Should search for surrounding days")
    void shouldSearchForSurroundingDays() {
        List<FlightOffer> expectedOffers = new ArrayList<>();
        when(getFlightOffersPort.search(anyString(), anyString(), any(), any(), anyInt(), anyBoolean(), anyString()))
                .thenReturn(expectedOffers);

        List<FlightOffer> actualOffers = getFlightOffersService.search("JFK", "LAX", true, 2, ZonedDateTime.now(), 1);

        assertEquals(expectedOffers, actualOffers);
        verify(getFlightOffersPort, atLeastOnce()).search(anyString(), anyString(), any(), any(), anyInt(), anyBoolean(), anyString());
    }

    @Test
    @DisplayName("Should handle null offers")
    void shouldHandleNullOffers() {
        when(getFlightOffersPort.search(anyString(), anyString(), any(), any(), anyInt(), anyBoolean(), anyString()))
                .thenReturn(null);

        List<FlightOffer> actualOffers = getFlightOffersService.search("JFK", "LAX", true, ZonedDateTime.now(), ZonedDateTime.now().plusDays(1));

        assertEquals(0, actualOffers.size());
        verify(getFlightOffersPort, times(1)).search(anyString(), anyString(), any(), any(), anyInt(), anyBoolean(), anyString());
    }
}