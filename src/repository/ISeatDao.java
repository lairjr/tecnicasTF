package repository;

import dtos.FlightDTO;
import dtos.SeatDTO;

import java.util.Date;
import java.util.List;

/**
 * Created by ljunior on 6/25/16.
 */
public interface ISeatDao {
    List<SeatDTO> getSeatsByFlightId(int flightId);
    int insert(SeatDTO seat);
}
