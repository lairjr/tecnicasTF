package domain.services;

import domain.IFlightService;
import dtos.FlightDTO;
import repository.IFlightDao;
import repository.dao.FlightDao;

import java.util.Date;
import java.util.List;

/**
 * Created by ljunior on 5/31/16.
 */
public class FlightService implements IFlightService {
    private static FlightService instance;
    private IFlightDao flightDao;

    private FlightService(IFlightDao flightDao) {
        this.flightDao = flightDao;
    }

    public static FlightService getInstance(IFlightDao flightDao) {
        if (instance == null)
            instance = new FlightService(flightDao);

        return instance;
    }

    @Override
    public FlightDTO getFlightByNumber(int flightNumber) {
        return flightDao.getFlightByNumber(flightNumber);
    }

    @Override
    public List<FlightDTO> getFlightsByDateAndLocale(Date departureDate, Date arrivalDate, String departureLocale, String arrivalLocale) {
        return flightDao.getFlightsByDateAndLocale(departureDate, arrivalDate, departureLocale, arrivalLocale);
    }
}
