package dtos;

/**
 * Created by ljunior on 6/1/16.
 */
public class TicketDTO {
    private int number;
    private String passenger;
    private String document;
    private int outboundFlightNumber;
    private int outboundSeat;
    private int inboundFlightNumber;
    private int inboundSeat;
    private int status;

    public TicketDTO() { }

    public TicketDTO(int number,
                     String passenger,
                     String document,
                     int outboundFlightNumber,
                     int outboundSeat,
                     int inboundFlightNumber,
                     int inboundSeat,
                     int status) {
        number = number;
        passenger = passenger;
        document = document;
        outboundFlightNumber = outboundFlightNumber;
        outboundSeat = outboundSeat;
        inboundFlightNumber = inboundFlightNumber;
        inboundSeat = inboundSeat;
        status = status;
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

    public int getOutboundFlightNumber() { return outboundFlightNumber; }

    public int getInboundFlightNumber() { return inboundFlightNumber; }

    public int getOutboundSeat() { return outboundSeat; }

    public int getInboundSeat() { return inboundSeat; }

    public int getStatus() {
        return status;
    }
}
