package dtos;

/**
 * Created by ljunior on 6/1/16.
 */
public class TicketDTO {
    private int ticketId;
    private String passenger;
    private String document;
    private int outboundFlightNumber;
    private FlightDTO outboundFlight;
    private int outboundSeat;
    private int inboundFlightNumber;
    private FlightDTO inboundFlight;
    private int inboundSeat;
    private int status;
    private int price;

    public TicketDTO() { }

    public TicketDTO(int ticketId,
                     String passenger,
                     String document,
                     int outboundFlightNumber,
                     int outboundSeat,
                     int inboundFlightNumber,
                     int inboundSeat,
                     int status,
                     int price) {
        this.ticketId = ticketId;
        this.passenger = passenger;
        this.document = document;
        this.outboundFlightNumber = outboundFlightNumber;
        this.price = price;
        this.setOutboundSeat(outboundSeat);
        this.inboundFlightNumber = inboundFlightNumber;
        this.setInboundSeat(inboundSeat);
        this.status = status;
    }

    public int getTicketId() {
        return ticketId;
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

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public void setOutboundSeat(int outboundSeat) {
        this.outboundSeat = outboundSeat;
    }

    public void setInboundSeat(int inboundSeat) {
        this.inboundSeat = inboundSeat;
    }

    public int getPrice() { return price; }
}
