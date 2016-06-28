package repository.dao;

import dtos.FlightDTO;
import dtos.SeatDTO;
import dtos.TicketDTO;
import dtos.factories.ISeatDTOFactory;
import infrastructure.Constants;
import infrastructure.IDatabase;
import repository.ISeatDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SeatDao implements ISeatDao {
    private static SeatDao instance;
    private IDatabase db;
    private ISeatDTOFactory seatDTOFactory;

    private SeatDao(IDatabase database, ISeatDTOFactory seatDTOFactory) {
        db = database;
        this.seatDTOFactory = seatDTOFactory;
    }

    public static SeatDao getInstance(IDatabase database, ISeatDTOFactory seatDTOFactory) {
        if (instance == null);
            instance = new SeatDao(database, seatDTOFactory);

        return instance;
    }

    @Override
    public List<SeatDTO> getSeatsByFlightId(int flightId) {
        StringBuilder sql = new StringBuilder();
        List<SeatDTO> seatDTOs = new ArrayList<>();

        sql.append(" SELECT * FROM ");
        sql.append(Constants.Seats.TABLE_NAME);
        sql.append(" WHERE ");
        sql.append(Constants.Seats.FlightId + " = ? ");

        try (Connection conn = db.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql.toString());

            ps.setInt(1, flightId);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                seatDTOs.add(seatDTOFactory.create(rs));
            }

            conn.close();

        } catch (SQLException e) {
            System.out.println(e);
        }

        return seatDTOs;
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

    @Override
    public int update(SeatDTO seat) {
        StringBuilder sql = new StringBuilder();

        sql.append(" UPDATE " + Constants.Seats.TABLE_NAME + " SET ");

        sql.append(Constants.Seats.Occupied + " = ? ");

        sql.append(" WHERE ");

        sql.append(Constants.Seats.FlightId + " = ? AND ");
        sql.append(Constants.Seats.Number + " = ? ");

        int rowsAffected = 0;

        try (Connection conn = db.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql.toString());
            ps.setInt(1, seat.getOccupied() ? 1 : 0);
            ps.setInt(2, seat.getFlightId());
            ps.setInt(3, seat.getNumber());

            rowsAffected = ps.executeUpdate();

            conn.close();
        } catch (SQLException e) {
            System.out.println(e);
        }

        return rowsAffected;
    }
}
