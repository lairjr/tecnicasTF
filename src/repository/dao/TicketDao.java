package repository.dao;

import dtos.TicketDTO;
import repository.ITicketDao;

/**
 * Created by ljunior on 6/2/16.
 */
public class TicketDao implements ITicketDao {
    @Override
    public TicketDTO getByNumber(int number) {
        return null;
    }

    @Override
    public TicketDTO insert(TicketDTO ticket) {
        return new TicketDTO(1);
    }

    @Override
    public TicketDTO update(TicketDTO ticket) {
        return new TicketDTO(2);
    }
}
