package domain;

import dtos.FlightDTO;

import java.util.Date;
import java.util.List;

/**
 * Created by ljunior on 5/31/16.
 */
public interface IFlightService {
    List<FlightDTO> getFlightsByDate(Date from, Date to);
}
