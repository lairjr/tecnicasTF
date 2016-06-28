package dtos.factories;

import dtos.TicketDTO;
import infrastructure.Constants;

import java.sql.ResultSet;

public class TicketDTOFactory implements ITicketDTOFactory {
    private static TicketDTOFactory instance;

    private TicketDTOFactory() { }

    public static TicketDTOFactory getInstance() {
        if (instance == null)
            instance = new TicketDTOFactory();

        return instance;
    }

    @Override
    public TicketDTO create(ResultSet rs) {
        try {
            int ticketId = rs.getInt(Constants.Tickets.TicketId);
            String passenger = rs.getString(Constants.Tickets.Passenger);
            String document = String.valueOf(rs.getInt(Constants.Tickets.Document));
            int outboundFlightId = rs.getInt(Constants.Tickets.OutboundFlightId);
            int outboundSeat = rs.getInt(Constants.Tickets.OutboundSeatId);
            int inboundFlightId = rs.getInt(Constants.Tickets.InboundFlightId);
            int inboundSeat = rs.getInt(Constants.Tickets.InboundSeatId);
            int status = 0;
            int price = rs.getInt(Constants.Tickets.Price);

            return create(ticketId, passenger, document, outboundFlightId, outboundSeat, inboundFlightId, inboundSeat, status, price);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public TicketDTO create(int ticketId, String passenger, String document, int outboundFlightId, int outboundSeat, int inboundFlightId, int inboundSeat, int status, int price) {
        return new TicketDTO(
                ticketId,
                passenger,
                document,
                outboundFlightId,
                outboundSeat,
                inboundFlightId,
                inboundSeat,
                price);
    }
}
