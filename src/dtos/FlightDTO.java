package dtos;

import java.time.LocalDateTime;
import java.util.List;

public class FlightDTO {
    private int flightId;
    private String departureLocale;
    private String arrivalLocale;
    private LocalDateTime departureDate;
    private LocalDateTime arrivalDate;
    private List<SeatDTO> seats;
    private boolean international;
    private int price;

    public FlightDTO(int flightId, String departureLocale, String arrivalLocale, LocalDateTime departureDate, LocalDateTime arrivalDate, boolean international, int price) {
        this.flightId = flightId;
        this.departureLocale = departureLocale;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
        this.arrivalLocale = arrivalLocale;
        this.international = international;
        this.price = price;
    }

    public int getFlightId() {
        return flightId;
    }

    public String getDepartureLocale() {
        return departureLocale;
    }

    public String getArrivalLocale() {
        return arrivalLocale;
    }

    public LocalDateTime getDepartureDate() {
        return departureDate;
    }

    public LocalDateTime getArrivalDate() {
        return arrivalDate;
    }

    public List<SeatDTO> getSeats() {
        return seats;
    }

    public void setSeats(List<SeatDTO> seats) {
        this.seats = seats;
    }

    public boolean getInternational() {
        return international;
    }

    public int getPrice() {
        return price;
    }
}
