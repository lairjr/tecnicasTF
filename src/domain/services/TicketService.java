package domain.services;

import domain.IFlightService;
import domain.ITicketService;
import dtos.FlightDTO;
import dtos.SeatDTO;
import dtos.TicketDTO;
import dtos.factories.ISeatDTOFactory;
import dtos.factories.ITicketDTOFactory;
import infrastructure.Constants;
import infrastructure.exceptions.RecordNotFoundException;
import repository.ISeatDao;
import repository.ITicketDao;

import java.time.LocalDateTime;

/**
 * Created by ljunior on 6/1/16.
 */
public class TicketService implements ITicketService {
    private static TicketService instance;
    private ITicketDao ticketDao;
    private ISeatDao seatDao;
    private IFlightService flightService;
    private ISeatDTOFactory seatDTOFactory;
    private ITicketDTOFactory ticketDTOFactory;

    private TicketService(ITicketDao ticketDao, IFlightService flightService, ISeatDao seatDao, ISeatDTOFactory seatDTOFactory, ITicketDTOFactory ticketDTOFactory) {
        this.ticketDao = ticketDao;
        this.flightService = flightService;
        this.seatDao = seatDao;
        this.seatDTOFactory = seatDTOFactory;
        this.ticketDTOFactory = ticketDTOFactory;
    }

    public static TicketService getInstance(ITicketDao ticketDao, IFlightService flightService, ISeatDao seatDao, ISeatDTOFactory seatDTOFactory, ITicketDTOFactory ticketDTOFactory) {
        if (instance == null)
            instance = new TicketService(ticketDao, flightService, seatDao, seatDTOFactory, ticketDTOFactory);

        return instance;
    }

    @Override
    public TicketDTO save(int ticketId, String passenger, String document, int outboundFlightId, int outboundSeat, int inboundFlightId, int inboundSeat, int status, int price) {
        TicketDTO ticketDTO = ticketDTOFactory.create(ticketId, passenger, document, outboundFlightId, outboundSeat, inboundFlightId, inboundSeat, status, price);

        if (ticketDTO.getTicketId() == 0)
            return ticketDao.insert(ticketDTO);

        return ticketDao.update(ticketDTO);
    }

    @Override
    public TicketDTO getByNumber(int ticketNumber) throws RecordNotFoundException {
        TicketDTO ticketDTO = ticketDao.getByTicketId(ticketNumber);

        if (ticketDTO == null)
            throw new RecordNotFoundException();

        FlightDTO inboundFlight = flightService.getFlightByNumber(ticketDTO.getInboundFlightNumber());
        FlightDTO outboundFlight = flightService.getFlightByNumber(ticketDTO.getOutboundFlightNumber());

        ticketDTO.setInboundFlight(inboundFlight);
        ticketDTO.setInboundStatus(getFlightStatus(inboundFlight, ticketDTO.getInboundSeat()));

        ticketDTO.setOutboundFlight(outboundFlight);
        ticketDTO.setOutboundStatus(getFlightStatus(outboundFlight, ticketDTO.getOutboundSeat()));

        return ticketDTO;
    }

    @Override
    public TicketDTO saveInbountSeat(int ticketId, int flightId, int seatNumber) {
        TicketDTO ticketDTO = ticketDao.getByTicketId(ticketId);

        int rowsAffected = updateSeat(flightId, seatNumber, true);
        ticketDTO.setInboundSeat(seatNumber);

        return updateTicketInboundSeat(ticketDTO);
    }

    @Override
    public TicketDTO saveOutbountSeat(int ticketId, int flightId, int seatNumber) {
        TicketDTO ticketDTO = ticketDao.getByTicketId(ticketId);

        int rowsAffected = updateSeat(flightId, seatNumber, true);
        ticketDTO.setOutboundSeat(seatNumber);

        return updateTicketOutboundSeat(ticketDTO);
    }

    private TicketDTO updateTicketOutboundSeat(TicketDTO ticketDTO) {
        ticketDTO = ticketDao.update(ticketDTO);

        try {
            ticketDTO.setOutboundFlight(flightService.getFlightByNumber(ticketDTO.getOutboundFlightNumber()));
        } catch (Exception e) {
            System.out.println(e);
        }

        return ticketDTO;
    }

    private TicketDTO updateTicketInboundSeat(TicketDTO ticketDTO) {
        ticketDTO = ticketDao.update(ticketDTO);

        try {
            ticketDTO.setInboundFlight(flightService.getFlightByNumber(ticketDTO.getInboundFlightNumber()));
        } catch (Exception e) {
            System.out.println(e);
        }

        return ticketDTO;
    }

    private int updateSeat(int flightId, int number, boolean occupied) {
        SeatDTO seatDTO = seatDTOFactory.create(flightId, number, occupied);

        return seatDao.update(seatDTO);
    }

    private Constants.TicketStatus getFlightStatus(FlightDTO flight, int seatNumber) {
        boolean didCheckIn = seatNumber > 0;
        boolean isBeforeDeparture = flight.getDepartureDate().isBefore(LocalDateTime.now());
        boolean inTimeForCheckIn = flight.getDepartureDate().minusDays(3).isBefore(LocalDateTime.now());

        if (isBeforeDeparture) {
            return didCheckIn ? Constants.TicketStatus.Used : Constants.TicketStatus.NotUsed;
        } else if (inTimeForCheckIn) {
            return didCheckIn ? Constants.TicketStatus.OkCheckin : Constants.TicketStatus.OpenCheckin;
        }

        return Constants.TicketStatus.Pending;
    }
}
