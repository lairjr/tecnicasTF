package domain;

import dtos.TicketDTO;

/**
 * Created by ljunior on 5/31/16.
 */
public interface ITicketService {
    TicketDTO save(int ticketId, String passenger, String document, int outboundFlightId, int outboundSeat, int inboundFlightId, int inboundSeat, int status);
    TicketDTO getByNumber(int ticketNumber);
    TicketDTO saveOutbountSeat(int ticketId, int flightId, int seatNumber);
    TicketDTO saveInbountSeat(int ticketId, int flightId, int seatNumber);
}
