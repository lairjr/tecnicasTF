package domain;

import dtos.TicketDTO;

/**
 * Created by ljunior on 5/31/16.
 */
public interface ITicketService {
    TicketDTO save(TicketDTO ticketDTO);
    TicketDTO getByNumber(int ticketNumber);
    TicketDTO saveOutbountSeat(int ticketId, int flightId, int seatNumber);
    TicketDTO saveInbountSeat(int ticketId, int flightId, int seatNumber);
}
