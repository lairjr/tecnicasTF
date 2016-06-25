package dtos;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by ljunior on 5/31/16.
 */
public class FlightDTO {
    private int number;
    private String departureLocale;
    private String arrivalLocale;
    private LocalDateTime departureDate;
    private LocalDateTime arrivalDate;
    private List<SeatDTO> seats;
    private int international;

    public FlightDTO(int number, String departureLocale, String arrivalLocale, Date departureDate, Date arrivalDate, int international) {
        this.setNumber(number);
        this.setDepartureLocale(departureLocale);
        this.setArrivalLocale(arrivalLocale);
        this.international = international;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
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

    public int getInternational() {
        return international;
    }
}
