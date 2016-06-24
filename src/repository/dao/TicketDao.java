package repository.dao;

import dtos.TicketDTO;
import infrastructure.IDatabase;
import repository.ITicketDao;

/**
 * Created by ljunior on 6/2/16.
 */
public class TicketDao implements ITicketDao {
    private static TicketDao instance;
    private IDatabase db;

    private TicketDao(IDatabase database) {
        db = database;
    }

    public static TicketDao getInstance(IDatabase database) {
        if (instance == null)
            instance = new TicketDao(database);

        return instance;
    }

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
