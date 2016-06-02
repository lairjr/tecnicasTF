package domain;

import dtos.FlightDTO;
import dtos.TicketDTO;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Matchers;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by ljunior on 6/1/16.
 */
public class DomainFacedeTest {
    private IDomainFacede domainFacede;
    private ITicketService ticketService;
    private IFlightService flightService;

    @Before
    public void setUp() {
        flightService = mock(IFlightService.class);
        ticketService = mock(ITicketService.class);

        domainFacede = new DomainFacede(flightService, ticketService);
    }

    @Test
    public void getFlightShouldReturnServiceCall() {
        Date fromDate = Date.valueOf("2016-10-20");
        Date toDate = Date.valueOf("2016-10-30");
        String from = "Partida";
        String to = "Chegada";

        List<FlightDTO> mockFlights = new ArrayList();

        when(flightService.getFlightsByDateAndLocale(fromDate, toDate, from, to)).
                thenReturn(mockFlights);
        List<FlightDTO> returnedFlights = domainFacede.getFlights(fromDate, toDate, from, to);

        assertEquals(mockFlights, returnedFlights);
    }

    @Test
    public void saveTicketShouldReturnServiceCall() {
        TicketDTO ticket = new TicketDTO();
        when(ticketService.save(ticket)).thenReturn(ticket);

        TicketDTO returnedTicket = domainFacede.saveTicket(ticket);
        assertEquals(ticket, ticket);
    }

    @Test
    public void getTicketShouldReturnServiceCall() {
        TicketDTO ticket = new TicketDTO();
        int ticketNumber = 1234;
        when(ticketService.getByNumber(ticketNumber)).thenReturn(ticket);

        TicketDTO returnedTicket = domainFacede.getTicket(ticketNumber);
        assertEquals(ticket, returnedTicket);
    }
}