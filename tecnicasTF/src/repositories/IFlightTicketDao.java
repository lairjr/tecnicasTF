package repositories;

import entities.FlightTicket;

public interface IFlightTicketDao {
	public FlightTicket insert(FlightTicket flightTicket);
	public FlightTicket update(FlightTicket flightTicket);
}
