package view.controllers;

import domain.DomainFacede;
import domain.IDomainFacede;
import domain.IFlightService;
import domain.ITicketService;
import domain.services.FlightService;
import domain.services.TicketService;
import dtos.FlightDTO;
import dtos.TicketDTO;
import infrastructure.Database;
import infrastructure.IDatabase;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import org.apache.derby.jdbc.EmbeddedDataSource;
import repository.IFlightDao;
import repository.ITicketDao;
import repository.dao.FlightDao;
import repository.dao.TicketDao;
import view.factories.FlightVMFactory;
import view.factories.IFlightVMFactory;
import view.models.FlightVM;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by ljunior on 6/23/16.
 */
public class TicketsController implements Initializable {
    private IDomainFacede domainFacede;
    private IFlightVMFactory flightVMFactory;

    @FXML
    private TextField _passengerName;
    @FXML
    private TextField _outboundFlightNumber;
    @FXML
    private Label _outboundFlightDate;
    @FXML
    private Label _outboundDeparture;
    @FXML
    private Label _outboundArrival;
    @FXML
    private TextField _arrivalFlightNumber;
    @FXML
    private TextField _inboundFlightNumber;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        flightVMFactory = new FlightVMFactory();

        EmbeddedDataSource dataSource = new EmbeddedDataSource();
        IDatabase database = Database.getInstance(dataSource);
        IFlightDao flightDao = new FlightDao(database);
        IFlightService flightService = new FlightService(flightDao);
        ITicketDao ticketDao = new TicketDao();
        ITicketService ticketService = new TicketService(ticketDao);
        domainFacede = new DomainFacede(flightService, ticketService);
    }

    public void searchDeparture() {
        int flightNumber = Integer.parseInt(_outboundFlightNumber.getText());

        FlightDTO flight = domainFacede.getFlightByNumber(flightNumber);
        FlightVM flightVM = flightVMFactory.create(flight);

        _outboundDeparture.setText(flight.getDepartureLocale());
        _outboundArrival.setText(flight.getArrivalLocale());
        _outboundFlightDate.setText(flight.getDepartureDate().toString());
    }

    public void searchArrival() {
        String flightNumber = _arrivalFlightNumber.getText();
    }

    public void saveTicket() {
        String passengerName =_passengerName.getText();
        int outboundFlight = Integer.parseInt(_outboundFlightNumber.getText());
        int inboundFlight = Integer.parseInt(_inboundFlightNumber.getText());

        TicketDTO ticket = domainFacede.saveTicket(passengerName, outboundFlight, inboundFlight);
    };
}
