package dtos.factories;

import dtos.TicketDTO;

import java.sql.ResultSet;

public interface ITicketDTOFactory {
    TicketDTO create(ResultSet rs);
    TicketDTO create(int ticketId, String passenger, String document, int outboundFlightId, int outboundSeat, int inboundFlightId, int inboundSeat, int status, int price);
}
