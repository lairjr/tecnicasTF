package dtos.factories;

import dtos.FlightDTO;

import java.sql.ResultSet;

public interface IFlightDTOFactory {
    FlightDTO create(ResultSet rs);
}
