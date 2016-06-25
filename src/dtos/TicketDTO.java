package dtos;

/**
 * Created by ljunior on 6/1/16.
 */
public class TicketDTO {
    private int number;
    private String passenger;
    private String document;
    private int outboundFlightNumber;
    private FlightDTO outboundFlight;
    private int outboundSeat;
    private int inboundFlightNumber;
    private FlightDTO inboundFlight;
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
        this.number = number;
        this.passenger = passenger;
        this.document = document;
        this.outboundFlightNumber = outboundFlightNumber;
        this.outboundSeat = outboundSeat;
        this.inboundFlightNumber = inboundFlightNumber;
        this.inboundSeat = inboundSeat;
        this.status = status;
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

    public FlightDTO getOutboundFlight() {
        return outboundFlight;
    }

    public void setOutboundFlight(FlightDTO outboundFlight) {
        this.outboundFlight = outboundFlight;
    }

    public FlightDTO getInboundFlight() {
        return inboundFlight;
    }

    public void setInboundFlight(FlightDTO inboundFlight) {
        this.inboundFlight = inboundFlight;
    }
}
