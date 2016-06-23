package repository;

import dtos.FlightDTO;
import repository.dao.FlightDao;

import java.util.Date;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by ljunior on 5/31/16.
 */
public interface IFlightDao {
    int insert(FlightDTO flight);
    FlightDTO getFlightByNumber(int flightNumber);
    List<FlightDTO> getFlightsByDateAndLocale(Date departureDate, Date arrivalDate, String departureLocale, String arrivalLocale);
}
