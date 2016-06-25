package domain.services;

import domain.IFlightService;
import domain.ITicketService;
import dtos.FlightDTO;
import dtos.TicketDTO;
import org.junit.Before;
import org.junit.Test;
import repository.IFlightDao;
import repository.ITicketDao;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by ljunior on 6/2/16.
 */
public class FlightServiceTest {
    private IFlightService flightService;
    private IFlightDao flightDao;

    @Before
    public void setUp() {
        flightDao = mock(IFlightDao.class);
        flightService = FlightService.getInstance(flightDao, null, null);
    }

    @Test
    public void getFlightsByDateAndLocaleShouldReturnRepositoryCall() {
        Date fromDate = Date.valueOf("2016-10-20");
        Date toDate = Date.valueOf("2016-10-30");
        String from = "Partida";
        String to = "Chegada";

        List<FlightDTO> mockFlights = new ArrayList();

        when(flightDao.getFlightsByDateAndLocale(fromDate, toDate, from, to)).
                thenReturn(mockFlights);

        List<FlightDTO> returnedFlights = flightService.getFlightsByDateAndLocale(fromDate, toDate, from, to);

        assertEquals(mockFlights, returnedFlights);
    }
}