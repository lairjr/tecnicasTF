package domain;

import dtos.FlightDTO;
import dtos.SeatDTO;
import dtos.TicketDTO;

import java.sql.Date;
import java.util.List;

/**
 * Created by ljunior on 5/31/16.
 */
public interface IDomainFacede {
    FlightDTO getFlightByNumber(int flightNumber);
    List<FlightDTO> getFlightsByDateAndLocale(Date departure, Date arrival, String from, String destination);
    TicketDTO saveTicket(int number, String passengerName, String document, int outboundFlight, int outboundSeat, int inboundFlight, int inboundSeat, int status);
    TicketDTO getTicket(int ticketNumber);
    SeatDTO saveSeat(int flightNumber, int seatNumber);
}
