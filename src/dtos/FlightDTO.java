package dtos;

import java.sql.Date;
import java.util.List;

/**
 * Created by ljunior on 5/31/16.
 */
public class FlightDTO {
    private int number;
    private String departureLocale;
    private String arrivalLocale;
    private Date departureDate;
    private Date arrivalDate;
    private List<SeatDTO> seats;

    public FlightDTO(int number, String departureLocale, String arrivalLocale, Date departureDate, Date arrivalDate) {
        this.setNumber(number);
        this.setDepartureDate(departureDate);
        this.setDepartureLocale(departureLocale);
        this.setArrivalLocale(arrivalLocale);
        this.setArrivalDate(arrivalDate);
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

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public List<SeatDTO> getSeats() {
        return seats;
    }

    public void setSeats(List<SeatDTO> seats) {
        this.seats = seats;
    }
}
