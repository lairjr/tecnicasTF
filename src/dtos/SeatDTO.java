package dtos;

/**
 * Created by ljunior on 6/25/16.
 */
public class SeatDTO {
    private int flightId;
    private int number;
    private boolean occupied;

    public SeatDTO(int flightId, int number, boolean occupied) {
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
}
