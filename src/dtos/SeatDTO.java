package dtos;

/**
 * Created by ljunior on 6/25/16.
 */
public class SeatDTO {
    private final int seatId;
    private final int flightId;
    private final int number;
    private final boolean occupied;

    public SeatDTO(int seatId, int flightId, int number, boolean occupied) {
        this.seatId = seatId;
        this.flightId = flightId;
        this.number = number;
        this.occupied = occupied;
    }

    public int getNumber() {
        return number;
    }

    public boolean getOccupied() {
        return occupied;
    }

    public int getFlightId() {
        return flightId;
    }

    public int getSeatId() { return seatId; }
}
