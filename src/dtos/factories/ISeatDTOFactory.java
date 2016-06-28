package dtos.factories;

import dtos.SeatDTO;

import java.sql.ResultSet;

public interface ISeatDTOFactory {
    SeatDTO create(ResultSet rs);
    SeatDTO create(int flightId, int number, boolean occupied);
}
