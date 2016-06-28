package repository;

import dtos.FlightDTO;

import java.util.Date;
import java.util.List;

public interface IFlightDao {
    int insert(FlightDTO flight);
    FlightDTO getFlightById(int flightId);
    List<FlightDTO> getFlightsByDateAndLocale(Date departureDate, Date arrivalDate, String departureLocale, String arrivalLocale);
}
