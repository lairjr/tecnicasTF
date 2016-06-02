package domain.services;

import domain.ITicketService;
import dtos.TicketDTO;
import repository.ITicketDao;

/**
 * Created by ljunior on 6/1/16.
 */
public class TicketService implements ITicketService {
    private ITicketDao ticketDao;

    public TicketService(ITicketDao ticketDao) {
        this.ticketDao = ticketDao;
    }

    @Override
    public TicketDTO save(TicketDTO ticketDTO) {
        return null;
    }

    @Override
    public TicketDTO getByNumber(int ticketNumber) {
        return ticketDao.getByNumber(ticketNumber);
    }
}
