package domain.services;

import domain.IFlightService;
import domain.ITicketService;
import dtos.SeatDTO;
import dtos.TicketDTO;
import dtos.factories.ISeatDTOFactory;
import dtos.factories.ITicketDTOFactory;
import repository.ISeatDao;
import repository.ITicketDao;

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
    public TicketDTO save(int ticketId, String passenger, String document, int outboundFlightId, int outboundSeat, int inboundFlightId, int inboundSeat, int status) {
        TicketDTO ticketDTO = ticketDTOFactory.create(ticketId, passenger, document, outboundFlightId, outboundSeat, inboundFlightId, inboundSeat, status);

        if (ticketDTO.getTicketId() == 0)
            return ticketDao.insert(ticketDTO);

        return ticketDao.update(ticketDTO);
    }

    @Override
    public TicketDTO getByNumber(int ticketNumber) {
        TicketDTO ticketDTO = ticketDao.getByNumber(ticketNumber);
        ticketDTO.setInboundFlight(flightService.getFlightByNumber(ticketDTO.getInboundFlightNumber()));
        ticketDTO.setOutboundFlight(flightService.getFlightByNumber(ticketDTO.getOutboundFlightNumber()));

        return ticketDTO;
    }

    @Override
    public TicketDTO saveInbountSeat(int ticketId, int flightId, int seatNumber) {
        TicketDTO ticketDTO = ticketDao.getByNumber(ticketId);

        int rowsAffected = updateSeat(flightId, seatNumber, true);
        ticketDTO.setInboundSeat(seatNumber);

        return updateTicketInboundSeat(ticketDTO);
    }

    @Override
    public TicketDTO saveOutbountSeat(int ticketId, int flightId, int seatNumber) {
        TicketDTO ticketDTO = ticketDao.getByNumber(ticketId);

        int rowsAffected = updateSeat(flightId, seatNumber, true);
        ticketDTO.setOutboundSeat(seatNumber);

        return updateTicketOutboundSeat(ticketDTO);
    }

    private TicketDTO updateTicketOutboundSeat(TicketDTO ticketDTO) {
        ticketDTO = ticketDao.update(ticketDTO);
        ticketDTO.setOutboundFlight(flightService.getFlightByNumber(ticketDTO.getOutboundFlightNumber()));

        return ticketDTO;
    }

    private TicketDTO updateTicketInboundSeat(TicketDTO ticketDTO) {
        ticketDTO = ticketDao.update(ticketDTO);
        ticketDTO.setInboundFlight(flightService.getFlightByNumber(ticketDTO.getInboundFlightNumber()));

        return ticketDTO;
    }

    private int updateSeat(int flightId, int number, boolean occupied) {
        SeatDTO seatDTO = seatDTOFactory.create(flightId, number, occupied);

        return seatDao.update(seatDTO);
    }
}
