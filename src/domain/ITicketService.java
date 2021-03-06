package domain;

import dtos.TicketDTO;
import infrastructure.exceptions.RecordNotFoundException;

public interface ITicketService {
    TicketDTO save(int ticketId, String passenger, String document, int outboundFlightId, int outboundSeat, int inboundFlightId, int inboundSeat, int status, int price);
    TicketDTO getByNumber(int ticketNumber) throws RecordNotFoundException;
    TicketDTO saveOutbountSeat(int ticketId, int flightId, int seatNumber);
    TicketDTO saveInbountSeat(int ticketId, int flightId, int seatNumber);
}
