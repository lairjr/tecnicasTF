package view;

import domain.IDomainFacede;
import dtos.TicketDTO;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Matchers;

import java.util.ResourceBundle;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * Created by ljunior on 6/1/16.
 */
public class TicketsControllerTest {
    private TicketsController ticketsController;
    private IDomainFacede domainFacede;

    @Before
    public void setUp() {
        ticketsController = new TicketsController();
        domainFacede = mock(IDomainFacede.class);
        ticketsController.setDependecies(domainFacede);
    }

    @Test
    public void testSaveTicketCallFacede() {
        ticketsController.saveTicket();
        verify(domainFacede, times(1)).saveTicket(Matchers.any(TicketDTO.class));
    }


}