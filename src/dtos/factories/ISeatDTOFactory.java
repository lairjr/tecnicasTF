package dtos.factories;

import dtos.SeatDTO;

import java.sql.ResultSet;

/**
 * Created by ljunior on 6/25/16.
 */
public interface ISeatDTOFactory {
    SeatDTO create(ResultSet rs);
    SeatDTO create(int flightId, int number, boolean occupied);
}
