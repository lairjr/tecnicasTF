package repository.dao;

import dtos.FlightDTO;
import infrastructure.IDatabase;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Matchers;
import repository.IFlightDao;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

/**
 * Created by ljunior on 6/2/16.
 */
public class FlightDaoTest {
    private IFlightDao flightDao;
    private IDatabase database;

    @Before
    public void setUp() {
        database = mock(IDatabase.class);
        flightDao = new FlightDao(database);
    }

    @Test
    public void getFlightsShouldReturnMockData() {
        List<FlightDTO> flights = flightDao.getFlightsByDateAndLocale(Matchers.any(), Matchers.any(), Matchers.any(), Matchers.any());
        assertNotNull(flights);
        assertEquals(flights.size(), 3);
    }
}