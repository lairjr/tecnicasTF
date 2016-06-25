package dtos;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by ljunior on 5/31/16.
 */
public class FlightDTO {
    private int flightId;
    private String departureLocale;
    private String arrivalLocale;
    private LocalDateTime departureDate;
    private LocalDateTime arrivalDate;
    private List<SeatDTO> seats;
    private boolean international;

    public FlightDTO(int flightId, String departureLocale, String arrivalLocale, LocalDateTime departureDate, LocalDateTime arrivalDate, boolean international) {
        this.flightId = flightId;
        this.departureLocale = departureLocale;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
        this.arrivalLocale = arrivalLocale;
        this.international = international;
    }

    public int getNumber() {
        return flightId;
    }

    public void setNumber(int number) {
        this.flightId = number;
    }

    public String getDepartureLocale() {
        return departureLocale;
    }

    public void setDepartureLocale(String departureLocale) {
        this.departureLocale = departureLocale;
    }

    public String getArrivalLocale() {
        return arrivalLocale;
    }

    public void setArrivalLocale(String arrivalLocale) {
        this.arrivalLocale = arrivalLocale;
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
}
