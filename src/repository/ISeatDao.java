package repository;

import dtos.SeatDTO;

import java.util.List;

public interface ISeatDao {
    List<SeatDTO> getSeatsByFlightId(int flightId);
    int insert(SeatDTO seat);
    int update(SeatDTO seat);
}
