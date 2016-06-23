package domain;

import dtos.FlightDTO;
import dtos.TicketDTO;

import java.sql.Date;
import java.util.List;

/**
 * Created by ljunior on 5/31/16.
 */
public interface IDomainFacede {
    FlightDTO getFlightByNumber(int flightNumber);
    List<FlightDTO> getFlightsByDateAndLocale(Date departure, Date arrival, String from, String destination);
    TicketDTO saveTicket(String passengerName, int outboundFlight, int inboundFlight);
    TicketDTO getTicket(int ticketNumber);
}
