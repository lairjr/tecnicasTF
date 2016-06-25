package domain;

import dtos.FlightDTO;
import dtos.SeatDTO;
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
    public TicketDTO saveTicket(int number, String passengerName, String document, int outboundFlight, int outboundSeat, int inboundFlight, int inboundSeat, int status) {
        TicketDTO ticket = new TicketDTO(
                number,
                passengerName,
                document,
                outboundFlight,
                outboundSeat,
                inboundFlight,
                inboundSeat,
                status
        );

        return ticketService.save(ticket);
    }

    @Override
    public TicketDTO getTicket(int ticketNumber) {
        return ticketService.getByNumber(ticketNumber);
    }

    @Override
    public SeatDTO saveSeat(int flightNumber, int seatNumber) {
        return null;
    }
}
