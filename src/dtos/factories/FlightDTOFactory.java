package dtos.factories;

import dtos.FlightDTO;
import infrastructure.Constants;

import java.sql.ResultSet;
import java.time.LocalDateTime;

/**
 * Created by ljunior on 6/25/16.
 */
public class FlightDTOFactory implements IFlightDTOFactory {
    private static FlightDTOFactory instance;

    private FlightDTOFactory() { }

    public static FlightDTOFactory getInstance() {
        if (instance == null)
            instance = new FlightDTOFactory();

        return instance;
    }

    @Override
    public FlightDTO create(ResultSet rs) {
        try {
            int flightId = rs.getInt(Constants.Flights.FlightId);
            String departureLocal = rs.getString(Constants.Flights.DepartureLocal);
            String arrivalLocal = rs.getString(Constants.Flights.ArrivalLocal);
            LocalDateTime flightDepartureDate = rs.getTimestamp(Constants.Flights.DepartureDate).toLocalDateTime();
            LocalDateTime flightArrivalDate = rs.getTimestamp(Constants.Flights.ArrivalDate).toLocalDateTime();
            boolean international = rs.getInt(Constants.Flights.International) == 1;
            int price = rs.getInt(Constants.Flights.Price);

            FlightDTO flightDTO = new FlightDTO(
                    flightId,
                    departureLocal,
                    arrivalLocal,
                    flightDepartureDate,
                    flightArrivalDate,
                    international,
                    price);

            return flightDTO;
        }
        catch (Exception e) {
            return null;
        }
    }
}
