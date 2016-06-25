package domain.services;

import domain.IFlightService;
import domain.ITicketService;
import dtos.TicketDTO;
import groovy.lang.Singleton;
import repository.ITicketDao;

/**
 * Created by ljunior on 6/1/16.
 */
public class TicketService implements ITicketService {
    private static TicketService instance;
    private ITicketDao ticketDao;
    private IFlightService flightService;

    private TicketService(ITicketDao ticketDao, IFlightService flightService) {
        this.ticketDao = ticketDao;
        this.flightService = flightService;
    }

    public static TicketService getInstance(ITicketDao ticketDao, IFlightService flightService) {
        if (instance == null)
            instance = new TicketService(ticketDao, flightService);

        return instance;
    }

    @Override
    public TicketDTO save(TicketDTO ticketDTO) {
        if (ticketDTO.getNumber() == 0)
            return ticketDao.insert(ticketDTO);
        return ticketDao.update(ticketDTO);
    }

    @Override
    public TicketDTO getByNumber(int ticketNumber) {
        TicketDTO ticketDTO = ticketDao.getByNumber(ticketNumber);
        ticketDTO.setInboundFlight(flightService.getFlightByNumber(ticketDTO.getInboundFlightNumber()));
        ticketDTO.setOutboundFlight(flightService.getFlightByNumber(ticketDTO.getOutboundFlightNumber()));

        return ticketDTO;
    }
}
