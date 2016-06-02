package dtos;

import java.sql.Date;

/**
 * Created by ljunior on 5/31/16.
 */
public class FlightDTO {
    private int number;
    private String from;
    private String to;
    private Date departure;
    private Date arrival;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
