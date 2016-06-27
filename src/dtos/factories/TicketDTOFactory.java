package dtos.factories;

import dtos.TicketDTO;
import infrastructure.Constants;

import java.sql.ResultSet;

/**
 * Created by ljunior on 6/27/16.
 */
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
            int outboundFlightNumber = rs.getInt(Constants.Tickets.OutboundFlightId);
            int outboundSeat = rs.getInt(Constants.Tickets.OutboundSeatId);
            int inboundFlightNumber = rs.getInt(Constants.Tickets.InboundFlightId);
            int inboundSeat = rs.getInt(Constants.Tickets.InboundSeatId);
            int status = 0;

            return new TicketDTO(
                    ticketId,
                    passenger,
                    document,
                    outboundFlightNumber,
                    outboundSeat,
                    inboundFlightNumber,
                    inboundSeat,
                    status);
        } catch (Exception e) {
            return null;
        }
    }
}
