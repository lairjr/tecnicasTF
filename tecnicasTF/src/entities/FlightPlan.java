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
}
