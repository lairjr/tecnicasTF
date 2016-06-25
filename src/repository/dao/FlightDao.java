package repository.dao;

import dtos.FlightDTO;
import infrastructure.Constants;
import infrastructure.IDatabase;
import repository.IFlightDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by ljunior on 5/31/16.
 */
public class FlightDao implements IFlightDao {
    private static FlightDao instance;
    private IDatabase db;
    private List<FlightDTO> mockFlights;

    private FlightDao(IDatabase database) {
        db = database;

        mockFlights = new ArrayList<>();
//
//        mockFlights.add(new FlightDTO(1, "Porto Alegre", "Orlando", new java.sql.Date(2016, 10, 20), new java.sql.Date(2016, 10, 30)));
//        mockFlights.add(new FlightDTO(2, "Porto Alegre", "New York", new java.sql.Date(2016, 10, 21), new java.sql.Date(2016, 10, 29)));
//        mockFlights.add(new FlightDTO(3, "Orlando", "Porto Alegre", new java.sql.Date(2016, 10, 22), new java.sql.Date(2016, 10, 28)));
    }

    public static FlightDao getInstance(IDatabase database) {
        if (instance == null)
            instance = new FlightDao(database);

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
        sql.append(Constants.Flights.International);

        sql.append(" ) VALUES (?, ?, ?, ?, ? ) ");

        int flightId = 0;

        try (Connection conn = db.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql.toString(), new String[] { Constants.Flights.FlightId });
            ps.setString(1, flight.getDepartureLocale());
            ps.setTimestamp(2, Timestamp.valueOf(flight.getDepartureDate()));
            ps.setString(3, flight.getArrivalLocale());
            ps.setTimestamp(4, Timestamp.valueOf(flight.getArrivalDate()));
            ps.setInt(5, flight.getInternational() ? 1 : 0);

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();

            rs.next();

            flightId = rs.getInt(Constants.Flights.FlightId);

            conn.close();
        } catch (SQLException e) {

        }

        return flightId;
    }

    @Override
    public FlightDTO getFlightByNumber(int flightNumber) {
        return mockFlights.get(flightNumber);
    }

    @Override
    public List<FlightDTO> getFlightsByDateAndLocale(Date departureDate, Date arrivalDate, String departureLocale, String arrivalLocale) {
        return mockFlights;
    }
}
