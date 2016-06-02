package domain;

import dtos.FlightDTO;
import dtos.TicketDTO;

import java.sql.Date;
import java.util.List;

/**
 * Created by ljunior on 5/31/16.
 */
public interface IDomainFacede {
    List<FlightDTO> getFlights(Date departure, Date arrival, String from, String destination);
    TicketDTO saveTicket(TicketDTO ticketDTO);
    TicketDTO getTicket(int ticketNumber);
}
