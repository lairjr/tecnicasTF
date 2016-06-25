package dtos.factories;

import dtos.SeatDTO;
import infrastructure.Constants;

import java.sql.ResultSet;

/**
 * Created by ljunior on 6/25/16.
 */
public class SeatDTOFactory implements ISeatDTOFactory {
    private static SeatDTOFactory instance;

    private SeatDTOFactory() { }

    public static SeatDTOFactory getInstance() {
        if (instance == null)
            instance = new SeatDTOFactory();

        return instance;
    }

    @Override
    public SeatDTO create(ResultSet rs) {
        try {
            int seatId = rs.getInt(Constants.Seats.SeatId);
            int flightId = rs.getInt(Constants.Seats.FlightId);
            int number = rs.getInt(Constants.Seats.Number);
            boolean occupied = rs.getInt(Constants.Seats.Occupied) == 1;

            return new SeatDTO(seatId, flightId, number, occupied);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public SeatDTO create(int flightId, int number, boolean occupied) {
        return new SeatDTO(0, flightId, number, occupied);
    }
}
