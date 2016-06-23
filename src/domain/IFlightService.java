package domain;

import dtos.FlightDTO;

import java.util.Date;
import java.util.List;

/**
 * Created by ljunior on 5/31/16.
 */
public interface IFlightService {
    FlightDTO getFlightByNumber(int flightNumber);
    List<FlightDTO> getFlightsByDateAndLocale(Date departureDate, Date arrivalDate, String departureLocale, String arrivalLocale);
}
