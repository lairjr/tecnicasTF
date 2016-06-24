package infrastructure.ioc;

import domain.DomainFacede;
import domain.IDomainFacede;
import domain.IFlightService;
import domain.ITicketService;
import domain.services.FlightService;
import domain.services.TicketService;
import infrastructure.Database;
import infrastructure.IDatabase;
import org.apache.derby.jdbc.EmbeddedDataSource;
import repository.IFlightDao;
import repository.ITicketDao;
import repository.dao.FlightDao;
import repository.dao.TicketDao;
import view.factories.FlightVMFactory;
import view.factories.IFlightVMFactory;

/**
 * Created by ljunior on 6/23/16.
 */
public class IoCContainer {
    private IoCContainer() { }

    public static IDomainFacede getDomainFacede() {
        EmbeddedDataSource dataSource = new EmbeddedDataSource();
        IDatabase database = Database.getInstance(dataSource);
        IFlightDao flightDao = FlightDao.getInstance(database);
        ITicketDao ticketDao = TicketDao.getInstance(database);
        IFlightService flightService = FlightService.getInstance(flightDao);
        ITicketService ticketService = TicketService.getInstance(ticketDao);

        return DomainFacede.getInstance(flightService, ticketService);
    }

    public static IFlightVMFactory getFlightVMFactory() {
        return FlightVMFactory.getInstance();
    }
}
