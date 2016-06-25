package repository.dao;

import dtos.SeatDTO;
import dtos.TicketDTO;
import infrastructure.Constants;
import infrastructure.IDatabase;
import repository.ISeatDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
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

        mockSeats.add(new SeatDTO(1, 1, false));
        mockSeats.add(new SeatDTO(1, 2, false));
        mockSeats.add(new SeatDTO(1, 3, true));
        mockSeats.add(new SeatDTO(1, 4, false));
        mockSeats.add(new SeatDTO(1, 5, true));
        mockSeats.add(new SeatDTO(1, 6, false));
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

    @Override
    public int insert(SeatDTO seat) {
        StringBuilder sql = new StringBuilder();

        sql.append(" INSERT INTO " + Constants.Seats.TABLE_NAME);
        sql.append(" ( ");

        sql.append(Constants.Seats.FlightId + ", ");
        sql.append(Constants.Seats.Number + ", ");
        sql.append(Constants.Seats.Occupied);

        sql.append(" ) VALUES (?, ?, ? ) ");

        int rowsAffected = 0;

        try (Connection conn = db.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql.toString());
            ps.setInt(1, seat.getFlightId());
            ps.setInt(2, seat.getNumber());
            ps.setInt(3, seat.getOccupied() ? 1 : 0);

            rowsAffected = ps.executeUpdate();

            conn.close();
        } catch (SQLException e) {
            System.out.println(e);
        }

        return rowsAffected;
    }
}
