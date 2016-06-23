package dtos;

/**
 * Created by ljunior on 6/1/16.
 */
public class TicketDTO {
    private int number;
    private String passenger;
    private String document;
    private FlightDTO flight;
    private int status;
    private int seat;

    public TicketDTO() { }

    public TicketDTO(int number) {
        this.number = number;
    }

    public TicketDTO(int inboundFlight, int outboundFlight, String passengerName) {
        passenger = passengerName;
    }

    public int getNumber() {
        return number;
    }

    public String getPassenger() {
        return passenger;
    }

    public String getDocument() {
        return document;
    }

    public FlightDTO getFlight() {
        return flight;
    }

    public int getStatus() {
        return status;
    }

    public int getSeat() {
        return seat;
    }
}
