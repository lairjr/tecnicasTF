package repositories.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import entities.FlightTicket;
import repositories.IFlightTicketDao;

public class FlightTicketDao implements IFlightTicketDao {
	private IDatabase database;
	
	public FlightTicketDao(IDatabase database) {
		this.database = database;
	}
	
	@Override
	public FlightTicket insert(FlightTicket flightTicket) {
		try {
			Connection connection = database.getConnection();
			StringBuilder query = new StringBuilder();
			
			query.append("INSERT INTO FLIGHT_TICKETS (");
			query.append(" LOCALE_NUMBER ");
			query.append(") VALUES (");
			query.append(" ? ");
			query.append(")");
			
			PreparedStatement ps = connection.prepareStatement(query.toString());
			
			ps.setInt(0, flightTicket.getLocaleNumber());
			
			ps.executeUpdate();
			
			return flightTicket;
		} catch (Exception e) {
			
		}
		return flightTicket;
	}

	@Override
	public FlightTicket update(FlightTicket flightTicket) {
		// TODO Auto-generated method stub
		return null;
	}

}
