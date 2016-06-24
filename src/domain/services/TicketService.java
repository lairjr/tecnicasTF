package domain.services;

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

    private TicketService(ITicketDao ticketDao) {
        this.ticketDao = ticketDao;
    }

    public static TicketService getInstance(ITicketDao ticketDao) {
        if (instance == null)
            instance = new TicketService(ticketDao);

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
        return ticketDao.getByNumber(ticketNumber);
    }
}
