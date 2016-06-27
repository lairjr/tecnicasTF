package repository.dao;

import dtos.FlightDTO;
import dtos.factories.IFlightDTOFactory;
import infrastructure.Constants;
import infrastructure.IDatabase;
import repository.IFlightDao;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by ljunior on 5/31/16.
 */
public class FlightDao implements IFlightDao {
    private static FlightDao instance;
    private IDatabase db;
    private IFlightDTOFactory flightDTOFactory;

    private FlightDao(IDatabase database, IFlightDTOFactory flightDTOFactory) {
        db = database;
        this.flightDTOFactory = flightDTOFactory;
    }

    public static FlightDao getInstance(IDatabase database, IFlightDTOFactory flightDTOFactory) {
        if (instance == null)
            instance = new FlightDao(database, flightDTOFactory);

        return instance;
    }

    @Override
    public int insert(FlightDTO flight) {
        StringBuilder sql = new StringBuilder();

        sql.append(" INSERT INTO " + Constants.Flights.TABLE_NAME);
        sql.append(" ( ");

        sql.append(Constants.Flights.DepartureLocal + ", ");
        sql.append(Constants.Flights.DepartureDate + ", ");
        sql.append(Constants.Flights.ArrivalLocal + ", ");
        sql.append(Constants.Flights.ArrivalDate + ", ");
        sql.append(Constants.Flights.International + ", ");
        sql.append(Constants.Flights.Price);

        sql.append(" ) VALUES (?, ?, ?, ?, ?, ? ) ");

        int flightId = 0;

        try (Connection conn = db.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, flight.getDepartureLocale());
            ps.setTimestamp(2, Timestamp.valueOf(flight.getDepartureDate()));
            ps.setString(3, flight.getArrivalLocale());
            ps.setTimestamp(4, Timestamp.valueOf(flight.getArrivalDate()));
            ps.setInt(5, flight.getInternational() ? 1 : 0);
            ps.setInt(6, flight.getPrice());

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();

            rs.next();

            flightId = rs.getInt(1);

            conn.close();
        } catch (SQLException e) {
            System.out.println(e);
        }

        return flightId;
    }

    @Override
    public FlightDTO getFlightById(int flightId) {
        StringBuilder sql = new StringBuilder();
        FlightDTO flightDTO = null;

        sql.append(" SELECT * FROM ");
        sql.append(Constants.Flights.TABLE_NAME);
        sql.append(" WHERE ");
        sql.append(Constants.Flights.FlightId + " = ? ");

        try (Connection conn = db.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql.toString());

            ps.setInt(1, flightId);

            ResultSet rs = ps.executeQuery();

            rs.next();

            flightDTO = flightDTOFactory.create(rs);
        } catch (Exception e) {

        }

        return flightDTO;
    }

    @Override
    public List<FlightDTO> getFlightsByDateAndLocale(Date departureDate, Date arrivalDate, String departureLocale, String arrivalLocale) {
        StringBuilder sql = new StringBuilder();
        List<FlightDTO> flightDTOs = new ArrayList<>();

        sql.append(" SELECT * FROM ");
        sql.append(Constants.Flights.TABLE_NAME);

        try (Connection conn = db.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql.toString());
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                flightDTOs.add(flightDTOFactory.create(rs));
            }

            conn.close();

        } catch (SQLException e) {

        }

        return flightDTOs;
    }
}
