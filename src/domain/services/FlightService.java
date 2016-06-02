package domain.services;

import domain.IFlightService;
import dtos.FlightDTO;
import repository.IFlightDao;

import java.util.Date;
import java.util.List;

/**
 * Created by ljunior on 5/31/16.
 */
public class FlightService implements IFlightService {
    private IFlightDao flightDao;

    public FlightService(IFlightDao flightDao) {
        this.flightDao = flightDao;
    }

    @Override
    public List<FlightDTO> getFlightsByDateAndLocale(Date departureDate, Date arrivalDate, String departureLocale, String arrivalLocale) {
        return flightDao.getFlightsByDateAndLocale(departureDate, arrivalDate, departureLocale, arrivalLocale);
    }
}
