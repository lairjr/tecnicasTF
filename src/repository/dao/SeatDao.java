package repository.dao;

import dtos.SeatDTO;
import dtos.TicketDTO;
import infrastructure.IDatabase;
import repository.ISeatDao;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ljunior on 6/25/16.
 */
public class SeatDao implements ISeatDao {
    private IDatabase db;
    private static SeatDao instance;
    private List<SeatDTO> mockSeats;

    private SeatDao(IDatabase database) {
        db = database;

        mockSeats = new ArrayList<>();

        mockSeats.add(new SeatDTO(1, false));
        mockSeats.add(new SeatDTO(2, false));
        mockSeats.add(new SeatDTO(3, true));
        mockSeats.add(new SeatDTO(4, false));
        mockSeats.add(new SeatDTO(5, true));
        mockSeats.add(new SeatDTO(6, false));
    }

    public static SeatDao getInstance(IDatabase database) {
        if (instance == null);
            instance = new SeatDao(database);

        return instance;
    }

    @Override
    public List<SeatDTO> getSeatsByFlightNumber(int flightNumber) {
        return mockSeats;
    }
}
