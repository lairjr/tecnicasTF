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
    TicketDTO saveTicket(int ticketId, String passenger, String document, int outboundFlightId, int outboundSeat, int inboundFlightId, int inboundSeat, int status, int price);
    TicketDTO getTicket(int ticketNumber);
    TicketDTO saveInbountSeat(int ticketId, int flightId, int seatNumber);
    TicketDTO saveOutboundSeat(int ticketId, int flightId, int seatNumber);
}
