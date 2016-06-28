package domain;

import dtos.FlightDTO;
import dtos.PromotionDTO;
import dtos.TicketDTO;
import infrastructure.exceptions.RecordNotFoundException;

import java.sql.Date;
import java.util.List;

/**
 * Created by ljunior on 5/31/16.
 */
public interface IDomainFacede {
    FlightDTO getFlightByNumber(int flightNumber) throws RecordNotFoundException;
    List<FlightDTO> getFlightsByDateAndLocale(Date departure, Date arrival, String from, String destination);
    TicketDTO saveTicket(int ticketId, String passenger, String document, int outboundFlightId, int outboundSeat, int inboundFlightId, int inboundSeat, int status, int price);
    TicketDTO getTicket(int ticketNumber) throws RecordNotFoundException;
    TicketDTO saveInbountSeat(int ticketId, int flightId, int seatNumber);
    TicketDTO saveOutboundSeat(int ticketId, int flightId, int seatNumber);
    List<PromotionDTO> getPromotions();
    PromotionDTO savePromotion(String text, int numberOfPurchases, double percentage);
    PromotionDTO getPromotionByPassenger(String passenger) throws RecordNotFoundException;
}
