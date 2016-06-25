package infrastructure;

/**
 * Created by ljunior on 6/25/16.
 */
public class Constants {
    public class Seats {
        public static final String TABLE_NAME = "SEATS";
        public static final String SeatId = "SEAT_ID";
        public static final String FlightId = "FLIGHT_ID";
        public static final String Occupied = "OCCUPIED";
    }

    public class Flights {
        public static final String TABLE_NAME = "FLIGHTS";
        public static final String FlightId = "FLIGHT_ID";
        public static final String DepartureLocal = "DEPARTURE_LOCAL";
        public static final String DepartureDate = "DEPARTURE_DATE";
        public static final String ArrivalLocal = "ARRIVAL_LOCAL";
        public static final String ArrivalDate = "ARRIVAL_DATE";
        public static final String International = "INTERNATIONAL";
    }

    public class Tickets {
        public static final String TABLE_NAME = "TICKETS";
        public static final String TicketId = "TICKET_ID";
        public static final String Passenger = "PASSENGER";
        public static final String Document = "DOCUMENT";
        public static final String OutboundFlightId = "OUTBOUND_FLIGHT_ID";
        public static final String OutboundSeatId = "OUTBOUND_SEAT_ID";
        public static final String InboundFlightId = "INBOUND_FLIGT_ID";
        public static final String InboundSeatId = "INBOUND_SEAT_ID";
    }
}
