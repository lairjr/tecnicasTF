package repository.dao;

import dtos.FlightDTO;
import infrastructure.IDatabase;
import repository.IFlightDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
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
        int rowsAffected = 0;

        try (Connection conn = db.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql.toString());
            ps.setString(0, flight.getDepartureLocale());
            ps.setTimestamp(1, Timestamp.valueOf(flight.getDepartureDate()));
            ps.setString(2, flight.getArrivalLocale());
            ps.setTimestamp(3, Timestamp.valueOf(flight.getArrivalDate()));
            ps.setInt(4, flight.getInternational());

            rowsAffected = ps.executeUpdate();
        } catch (SQLException e) {

        }

        return rowsAffected;
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
