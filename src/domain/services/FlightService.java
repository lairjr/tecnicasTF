package domain.services;

import domain.IFlightService;
import dtos.FlightDTO;
import repository.IFlightDao;
import repository.ISeatDao;
import repository.dao.FlightDao;

import java.util.Date;
import java.util.List;

/**
 * Created by ljunior on 5/31/16.
 */
public class FlightService implements IFlightService {
    private static FlightService instance;
    private IFlightDao flightDao;
    private ISeatDao seatDao;

    private FlightService(IFlightDao flightDao, ISeatDao seatDao) {
        this.flightDao = flightDao;
        this.seatDao = seatDao;
    }

    public static FlightService getInstance(IFlightDao flightDao, ISeatDao seatDao) {
        if (instance == null)
            instance = new FlightService(flightDao, seatDao);

        return instance;
    }

    @Override
    public FlightDTO getFlightByNumber(int flightNumber) {
        FlightDTO flightDTO = flightDao.getFlightByNumber(flightNumber);
        flightDTO.setSeats(seatDao.getSeatsByFlightNumber(flightDTO.getNumber()));
        return flightDTO;
    }

    @Override
    public List<FlightDTO> getFlightsByDateAndLocale(Date departureDate, Date arrivalDate, String departureLocale, String arrivalLocale) {
        return flightDao.getFlightsByDateAndLocale(departureDate, arrivalDate, departureLocale, arrivalLocale);
    }
}
