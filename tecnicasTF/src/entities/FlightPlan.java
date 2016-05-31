package entities;

import java.sql.Date;
import java.util.List;

public class FlightPlan {
	private int number;
	private String from;
	private String to;
	private Date departureDate;
	private Date arrivalDate;
	private List<FlightSeat> seats;
	
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
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
	public List<FlightSeat> getSeats() {
		return seats;
	}
	public void setSeats(List<FlightSeat> seats) {
		this.seats = seats;
	}
}
