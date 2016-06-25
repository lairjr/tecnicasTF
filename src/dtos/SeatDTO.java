package dtos;

/**
 * Created by ljunior on 6/25/16.
 */
public class SeatDTO {
    private int number;
    private boolean status;

    public SeatDTO(int number, boolean status) {
        this.number = number;
        this.status = status;
    }

    public int getNumber() {
        return number;
    }

    public boolean getStatus() {
        return status;
    }
}
