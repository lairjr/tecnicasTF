package domain.services;

import domain.ITicketService;
import dtos.TicketDTO;
import org.junit.Before;
import org.junit.Test;
import repository.ITicketDao;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by ljunior on 6/1/16.
 */
public class TicketServiceTest {
    private ITicketService ticketService;
    private ITicketDao ticketDao;

    @Before
    public void setUp() {
        ticketDao = mock(ITicketDao.class);
        ticketService = new TicketService(ticketDao);
    }

    @Test
    public void getByNumberShouldReturnRepositoryCall() {
        int number = 1234;
        TicketDTO ticket = new TicketDTO();

        when(ticketDao.getByNumber(number)).thenReturn(ticket);

        TicketDTO returnedTicket = ticketService.getByNumber(number);
        assertEquals(returnedTicket, ticket);
    }
}