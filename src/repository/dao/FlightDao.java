package repository.dao;

import dtos.FlightDTO;
import infrastructure.IDatabase;
import repository.IFlightDao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by ljunior on 5/31/16.
 */
public class FlightDao implements IFlightDao {
    private IDatabase db;
    private List<FlightDTO> mockFlights;

    public FlightDao(IDatabase database) {
        db = database;

        mockFlights = new ArrayList<>();

        mockFlights.add(new FlightDTO(1, "Porto Alegre", "Orlando", new java.sql.Date(2016, 10, 20), new java.sql.Date(2016, 10, 30)));
        mockFlights.add(new FlightDTO(1, "Porto Alegre", "New York", new java.sql.Date(2016, 10, 21), new java.sql.Date(2016, 10, 29)));
        mockFlights.add(new FlightDTO(1, "Orlando", "Porto Alegre", new java.sql.Date(2016, 10, 22), new java.sql.Date(2016, 10, 28)));
    }

    @Override
    public int insert(FlightDTO flight) {
        return 0;
    }

    @Override
    public List<FlightDTO> getFlightsByDateAndLocale(Date departureDate, Date arrivalDate, String departureLocale, String arrivalLocale) {
        return this.mockGetFlights();
    }

    private List<FlightDTO> mockGetFlights() {
        return mockFlights;
    }
}
