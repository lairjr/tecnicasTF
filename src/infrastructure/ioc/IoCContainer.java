package infrastructure.ioc;

import domain.*;
import domain.services.FlightService;
import domain.services.PromotionService;
import domain.services.TicketService;
import dtos.factories.*;
import infrastructure.Database;
import infrastructure.IDatabase;
import infrastructure.mocks.FlightGenerator;
import infrastructure.mocks.PromotionGenerator;
import org.apache.derby.jdbc.EmbeddedDataSource;
import repository.IFlightDao;
import repository.IPromotionDao;
import repository.ISeatDao;
import repository.ITicketDao;
import repository.dao.FlightDao;
import repository.dao.PromotionDao;
import repository.dao.SeatDao;
import repository.dao.TicketDao;
import view.factories.FlightVMFactory;
import view.factories.IFlightVMFactory;
import view.factories.IPromotionVMFactory;
import view.factories.PromotionVMFactory;

/**
 * Created by ljunior on 6/23/16.
 */
public class IoCContainer {
    private IoCContainer() { }

    public static IDomainFacede getDomainFacede() {
        EmbeddedDataSource dataSource = new EmbeddedDataSource();
        IDatabase database = Database.getInstance(dataSource);
        ISeatDTOFactory seatDTOFactory = SeatDTOFactory.getInstance();
        IFlightDTOFactory flightDTOFactory = FlightDTOFactory.getInstance();
        ITicketDTOFactory ticketDTOFactory = TicketDTOFactory.getInstance();
        IPromotionDTOFactory promotionDTOFactory = PromotionDTOFactory.getInstance();
        IFlightDao flightDao = FlightDao.getInstance(database, flightDTOFactory);
        ITicketDao ticketDao = TicketDao.getInstance(database, ticketDTOFactory);
        ISeatDao seatDao = SeatDao.getInstance(database, seatDTOFactory);
        IPromotionDao promotionDao = PromotionDao.getInstance(database, promotionDTOFactory);
        IPromotionService promotionService = PromotionService.getInstance(promotionDao, promotionDTOFactory, ticketDao);
        IFlightService flightService = FlightService.getInstance(flightDao, seatDao, seatDTOFactory);
        ITicketService ticketService = TicketService.getInstance(ticketDao, flightService, seatDao, seatDTOFactory, ticketDTOFactory);

        return DomainFacede.getInstance(flightService, ticketService, promotionService);
    }

    public static IFlightVMFactory getFlightVMFactory() {
        return FlightVMFactory.getInstance();
    }

    public static IDatabase getDatabase() {
        EmbeddedDataSource dataSource = new EmbeddedDataSource();
        return Database.getInstance(dataSource);
    }

    public static FlightGenerator getFlightGenerator() {
        EmbeddedDataSource dataSource = new EmbeddedDataSource();
        IDatabase database = Database.getInstance(dataSource);
        ISeatDTOFactory seatDTOFactory = SeatDTOFactory.getInstance();
        IFlightDTOFactory flightDTOFactory = FlightDTOFactory.getInstance();
        IFlightDao flightDao = FlightDao.getInstance(database, flightDTOFactory);
        ISeatDao seatDao = SeatDao.getInstance(database, seatDTOFactory);
        IFlightService flightService = FlightService.getInstance(flightDao, seatDao, seatDTOFactory);

        return FlightGenerator.getInstance(flightService);
    }

    public static PromotionGenerator getPromotionGenerator() {
        EmbeddedDataSource dataSource = new EmbeddedDataSource();
        IDatabase database = Database.getInstance(dataSource);
        IPromotionDTOFactory promotionDTOFactory = PromotionDTOFactory.getInstance();
        IPromotionDao promotionDao = PromotionDao.getInstance(database, promotionDTOFactory);

        return PromotionGenerator.getInstance(promotionDao, promotionDTOFactory);
    }

    public static IPromotionVMFactory getPromotionVMFactory() {
        return PromotionVMFactory.getInstance();
    }
}
