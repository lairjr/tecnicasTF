package domain.services;

import domain.ITicketService;
import dtos.TicketDTO;
import org.junit.Before;
import org.junit.Test;
import repository.ITicketDao;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * Created by ljunior on 6/1/16.
 */
public class TicketServiceTest {
    private ITicketService ticketService;
    private ITicketDao ticketDao;

    @Before
    public void setUp() {
        ticketDao = mock(ITicketDao.class);
        ticketService = TicketService.getInstance(ticketDao, null);
    }

    @Test
    public void getByNumberShouldReturnRepositoryCall() {
        int number = 1234;
        TicketDTO ticket = new TicketDTO();

        when(ticketDao.getByNumber(number)).thenReturn(ticket);

        TicketDTO returnedTicket = ticketService.getByNumber(number);
        assertEquals(returnedTicket, ticket);
    }

    @Test
    public void saveShouldReturnInsertRepositoryCall() {
        TicketDTO ticket = new TicketDTO();

        when(ticketDao.insert(ticket)).thenReturn(ticket);

        TicketDTO returnedTicket = ticketService.save(ticket);
        verify(ticketDao, times(1)).insert(ticket);
        assertEquals(returnedTicket, ticket);
    }

    @Test
    public void saveShouldReturnUpdateRepositoryCall() {
        TicketDTO ticket = new TicketDTO(1234, null, null, 0, 0, 0, 0, 0);

        when(ticketDao.update(ticket)).thenReturn(ticket);

        TicketDTO returnedTicket = ticketService.save(ticket);
        verify(ticketDao, times(1)).update(ticket);
        assertEquals(returnedTicket, ticket);
    }
}