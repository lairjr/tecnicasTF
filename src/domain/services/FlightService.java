package domain.services;

import domain.IFlightService;
import dtos.FlightDTO;
import dtos.SeatDTO;
import dtos.factories.ISeatDTOFactory;
import repository.IFlightDao;
import repository.ISeatDao;

import java.util.Date;
import java.util.List;

/**
 * Created by ljunior on 5/31/16.
 */
public class FlightService implements IFlightService {
    private static FlightService instance;
    private final IFlightDao flightDao;
    private final ISeatDTOFactory seatDTOFactory;
    private final ISeatDao seatDao;

    private FlightService(IFlightDao flightDao, ISeatDao seatDao, ISeatDTOFactory seatDTOFactory) {
        this.flightDao = flightDao;
        this.seatDao = seatDao;
        this.seatDTOFactory = seatDTOFactory;
    }

    public static FlightService getInstance(IFlightDao flightDao, ISeatDao seatDao, ISeatDTOFactory seatDTOFactory) {
        if (instance == null)
            instance = new FlightService(flightDao, seatDao, seatDTOFactory);

        return instance;
    }

    @Override
    public FlightDTO getFlightByNumber(int flightNumber) {
        FlightDTO flightDTO = flightDao.getFlightById(flightNumber);

        List<SeatDTO> seats = seatDao.getSeatsByFlightId(flightDTO.getFlightId());
        flightDTO.setSeats(seats);

        return flightDTO;
    }

    @Override
    public List<FlightDTO> getFlightsByDateAndLocale(Date departureDate, Date arrivalDate, String departureLocale, String arrivalLocale) {
        return flightDao.getFlightsByDateAndLocale(departureDate, arrivalDate, departureLocale, arrivalLocale);
    }

    @Override
    public int insert(FlightDTO flight) {
        int flightId = flightDao.insert(flight);

        for (int x = 1; x <= 40; x++) {
            SeatDTO seat = seatDTOFactory.create(flightId, x, false);
            seatDao.insert(seat);
        }

        return flightId;
    }
}
