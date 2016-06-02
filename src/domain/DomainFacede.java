package domain;

import dtos.FlightDTO;
import dtos.TicketDTO;

import java.sql.Date;
import java.util.List;

/**
 * Created by ljunior on 6/1/16.
 */
public class DomainFacede implements IDomainFacede {
    private IFlightService flightService;
    private ITicketService ticketService;

    public DomainFacede(IFlightService flightService, ITicketService ticketService) {
        this.flightService = flightService;
        this.ticketService = ticketService;
    }

    @Override
    public List<FlightDTO> getFlights(Date departure, Date arrival, String from, String destination) {
        return flightService.getFlightsByDateAndLocale(departure, arrival, from, destination);
    }

    @Override
    public TicketDTO saveTicket(TicketDTO ticketDTO) {
        return ticketService.save(ticketDTO);
    }
}
