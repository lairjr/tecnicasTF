package domain;

import dtos.FlightDTO;
import infrastructure.exceptions.RecordNotFoundException;

import java.util.Date;
import java.util.List;

public interface IFlightService {
    FlightDTO getFlightByNumber(int flightNumber) throws RecordNotFoundException;
    List<FlightDTO> getFlightsByDateAndLocale(Date departureDate, Date arrivalDate, String departureLocale, String arrivalLocale);
    int insert(FlightDTO flight);
}
