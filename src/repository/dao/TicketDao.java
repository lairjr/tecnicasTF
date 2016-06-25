package repository.dao;

import dtos.FlightDTO;
import dtos.TicketDTO;
import infrastructure.IDatabase;
import repository.ITicketDao;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ljunior on 6/2/16.
 */
public class TicketDao implements ITicketDao {
    private static TicketDao instance;
    private IDatabase db;
    private List<TicketDTO> mockTickets;

    private TicketDao(IDatabase database) {
        db = database;

        mockTickets = new ArrayList<>();

        mockTickets.add(new TicketDTO(1, "Fulano", "1234", 1, 2, 3, 4, 1));
        mockTickets.add(new TicketDTO(2, "Ciclano", "1235", 2, 3, 2, 1, 1));
        mockTickets.add(new TicketDTO(3, "Beltrano", "5421", 3, 5, 1, 2, 1));
    }

    public static TicketDao getInstance(IDatabase database) {
        if (instance == null)
            instance = new TicketDao(database);

        return instance;
    }

    @Override
    public TicketDTO getByNumber(int number) {
        return mockTickets.get(number);
    }

    @Override
    public TicketDTO insert(TicketDTO ticket) {
        return mockTickets.get(1);
    }

    @Override
    public TicketDTO update(TicketDTO ticket) { return mockTickets.get(2); }
}
