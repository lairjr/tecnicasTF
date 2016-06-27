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
import infrastructure.ioc.IoCContainer;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
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
    private TextField _document;
    @FXML
    private Label _inboundFlightDate;
    @FXML
    private Label _inboundDeparture;
    @FXML
    private Label _inboundArrival;
    @FXML
    private Label _outboundFlightDate;
    @FXML
    private Label _outboundDeparture;
    @FXML
    private Label _outboundArrival;
    @FXML
    private Label _tripPrice;
    @FXML
    private TextField _inboundFlightNumber;

    private FlightDTO outboundFlight;
    private FlightDTO inboundFlight;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        flightVMFactory = IoCContainer.getFlightVMFactory();
        domainFacede = IoCContainer.getDomainFacede();
    }

    public void searchDeparture() {
        int flightId = Integer.parseInt(_outboundFlightNumber.getText());

        outboundFlight = domainFacede.getFlightByNumber(flightId);
        FlightVM flightVM = flightVMFactory.create(outboundFlight);

        _outboundDeparture.setText(flightVM.getDepartureLocale().getValue());
        _outboundArrival.setText(flightVM.getArrivalLocale().getValue());
        _outboundFlightDate.setText(flightVM.getDepartureDate().getValue());

        updatePrice();
    }

    public void searchArrival() {
        int flightId = Integer.parseInt(_inboundFlightNumber.getText());

        inboundFlight = domainFacede.getFlightByNumber(flightId);
        FlightVM flightVM = flightVMFactory.create(inboundFlight);

        _inboundDeparture.setText(flightVM.getDepartureLocale().getValue());
        _inboundArrival.setText(flightVM.getArrivalLocale().getValue());
        _inboundFlightDate.setText(flightVM.getDepartureDate().getValue());

        updatePrice();
    }

    public void saveTicket() {
        int ticketNumber = 0;
        String passengerName = _passengerName.getText();
        String document = _document.getText();
        int outboundFlight = Integer.parseInt(_outboundFlightNumber.getText());
        int outboundSeat = 0;
        int inboundFlight = Integer.parseInt(_inboundFlightNumber.getText());
        int inboundSeat = 0;
        int status = 0;
        int price = Integer.parseInt(_tripPrice.getText());

        TicketDTO ticket = domainFacede.saveTicket(ticketNumber, passengerName, document, outboundFlight, outboundSeat, inboundFlight, inboundSeat, status, price);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Salvar Ticket");

        if (ticket.getTicketId() == 0) {
            alert.setHeaderText("Erro ao salvar!");
        } else {
            alert.setHeaderText("Sucesso! \n Número do localizador: " + ticket.getTicketId());
        }
        alert.showAndWait();
    }

    private void updatePrice() {
        Integer price = outboundFlight != null ? outboundFlight.getPrice() : 0;
        price += inboundFlight != null ? inboundFlight.getPrice() : 0;

        _tripPrice.setText(price.toString());
    }
}
