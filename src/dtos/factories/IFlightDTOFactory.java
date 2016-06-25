package dtos.factories;

import dtos.FlightDTO;

import java.sql.ResultSet;

/**
 * Created by ljunior on 6/25/16.
 */
public interface IFlightDTOFactory {
    FlightDTO create(ResultSet rs);
}
