package domain;

import dtos.FlightDTO;
import dtos.TicketDTO;

import java.sql.Date;
import java.util.List;

/**
 * Created by ljunior on 6/1/16.
 */
public class DomainFacede implements IDomainFacede {
    private static DomainFacede instance;
    private IFlightService flightService;
    private ITicketService ticketService;

    private DomainFacede(IFlightService flightService, ITicketService ticketService) {
        this.flightService = flightService;
        this.ticketService = ticketService;
    }

    public static DomainFacede getInstance(IFlightService flightService, ITicketService ticketService) {
        if (instance == null)
            instance = new DomainFacede(flightService, ticketService);

        return instance;
    }

    @Override
    public FlightDTO getFlightByNumber(int flightNumber) {
        return flightService.getFlightByNumber(flightNumber);
    }

    @Override
    public List<FlightDTO> getFlightsByDateAndLocale(Date departure, Date arrival, String from, String destination) {
        return flightService.getFlightsByDateAndLocale(departure, arrival, from, destination);
    }

    @Override
    public TicketDTO saveTicket(int ticketId, String passenger, String document, int outboundFlightId, int outboundSeat, int inboundFlightId, int inboundSeat, int status, int price) {
        return ticketService.save(ticketId, passenger, document, outboundFlightId, outboundSeat, inboundFlightId, inboundSeat, status, price);
    }

    @Override
    public TicketDTO getTicket(int ticketNumber) {
        return ticketService.getByNumber(ticketNumber);
    }

    @Override
    public TicketDTO saveInbountSeat(int ticketId, int flightId, int seatNumber) {
        return ticketService.saveInbountSeat(ticketId, flightId, seatNumber);
    }

    @Override
    public TicketDTO saveOutboundSeat(int ticketId, int flightId, int seatNumber) {
        return ticketService.saveOutbountSeat(ticketId, flightId, seatNumber);
    }
}
