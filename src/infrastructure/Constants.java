package infrastructure;

import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ljunior on 6/25/16.
 */
public class Constants {
    public class Seats {
        public static final String TABLE_NAME = "SEATS";
        public static final String SeatId = "SEAT_ID";
        public static final String FlightId = "FLIGHT_ID";
        public static final String Occupied = "OCCUPIED";
        public static final String Number = "NUMBER";
    }

    public class Flights {
        public static final String TABLE_NAME = "FLIGHTS";
        public static final String FlightId = "FLIGHT_ID";
        public static final String DepartureLocal = "DEPARTURE_LOCAL";
        public static final String DepartureDate = "DEPARTURE_DATE";
        public static final String ArrivalLocal = "ARRIVAL_LOCAL";
        public static final String ArrivalDate = "ARRIVAL_DATE";
        public static final String International = "INTERNATIONAL";
        public static final String Price = "PRICE";

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
        public static final String Price = "PRICE";
    }

    public class Promotions {
        public static final String TABLE_NAME = "PROMOTIONS";
        public static final String PromotionId = "PROMOTION_ID";
        public static final String Text = "NAME";
        public static final String NumberOfPurchases = "NUMBER_OF_PURCHASES";
        public static final String Percentage = "PERCENTAGE";
    }

    public static Map<TicketStatus, String> TicketStatusDecription;
    static {
        TicketStatusDecription = new HashMap<>();

        TicketStatusDecription.put(TicketStatus.Pending, "Pendente");
        TicketStatusDecription.put(TicketStatus.OpenCheckin, "Check-in aberto");
        TicketStatusDecription.put(TicketStatus.OkCheckin, "Check-in fechado");
        TicketStatusDecription.put(TicketStatus.Used, "Passagem utilizada");
        TicketStatusDecription.put(TicketStatus.NotUsed, "Passagem não utilizada");
    }

    public enum TicketStatus {
        Pending,
        OpenCheckin,
        OkCheckin,
        Used,
        NotUsed
    }
}
