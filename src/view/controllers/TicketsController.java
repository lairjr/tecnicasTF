package view.controllers;

import domain.IDomainFacede;
import dtos.FlightDTO;
import dtos.PromotionDTO;
import dtos.TicketDTO;
import infrastructure.Constants;
import infrastructure.exceptions.RecordNotFoundException;
import infrastructure.ioc.IoCContainer;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import view.factories.IFlightVMFactory;
import view.models.FlightVM;

import java.net.URL;
import java.util.ResourceBundle;

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
    private Label _inboundStatus;
    @FXML
    private Label _outboundFlightDate;
    @FXML
    private Label _outboundDeparture;
    @FXML
    private Label _outboundArrival;
    @FXML
    private Label _outboundStatus;
    @FXML
    private Label _tripPrice;
    @FXML
    private Label _promotionText;
    @FXML
    private TextField _inboundFlightNumber;
    @FXML
    private TextField _searchTicketId;

    private FlightDTO outboundFlight;
    private FlightDTO inboundFlight;
    private PromotionDTO promotionDTO;
    private final String FLIGHT_NOT_FOUND = "Voo não encontrado!";
    private final String TICKET_NOT_FOUND_MSG = "Passagem não encontrada!";
    private final String NO_PROMOTION = "Ainda não pode ter promoção!";

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        solveDependencies();
    }

    private void solveDependencies() {
        flightVMFactory = IoCContainer.getFlightVMFactory();
        domainFacede = IoCContainer.getDomainFacede();
    }

    public void checkPromotion() {
        try {
            String passenger = _document.getText();
            promotionDTO = domainFacede.getPromotionByPassenger(passenger);

            updatePrice();
        } catch (RecordNotFoundException e) {
            displayAlert(NO_PROMOTION);
        }
    }

    public void searchDeparture() {
        int flightId = Integer.parseInt(_outboundFlightNumber.getText());

        try {
            outboundFlight = domainFacede.getFlightByNumber(flightId);
            FlightVM flightVM = flightVMFactory.create(outboundFlight);

            _outboundDeparture.setText(flightVM.getDepartureLocale().getValue());
            _outboundArrival.setText(flightVM.getArrivalLocale().getValue());
            _outboundFlightDate.setText(flightVM.getDepartureDate().getValue());

            updatePrice();
        } catch (RecordNotFoundException e) {
            displayAlert(FLIGHT_NOT_FOUND);
        }
    }

    public void searchArrival() {
        int flightId = Integer.parseInt(_inboundFlightNumber.getText());

        try {
            inboundFlight = domainFacede.getFlightByNumber(flightId);
            FlightVM flightVM = flightVMFactory.create(inboundFlight);

            _inboundDeparture.setText(flightVM.getDepartureLocale().getValue());
            _inboundArrival.setText(flightVM.getArrivalLocale().getValue());
            _inboundFlightDate.setText(flightVM.getDepartureDate().getValue());

            updatePrice();
        } catch (RecordNotFoundException e) {
            displayAlert(FLIGHT_NOT_FOUND);
        }
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

    public void searchTicketId() {
        int ticketId = Integer.parseInt(_searchTicketId.getText());

        try {
            TicketDTO ticket = domainFacede.getTicket(ticketId);

            _passengerName.setText(ticket.getPassenger());
            _document.setText(ticket.getDocument());

            FlightVM flightVM = flightVMFactory.create(ticket.getInboundFlight());

            _inboundFlightNumber.setText(String.valueOf(ticket.getInboundFlightNumber()));
            _inboundDeparture.setText(flightVM.getDepartureLocale().getValue());
            _inboundArrival.setText(flightVM.getArrivalLocale().getValue());
            _inboundFlightDate.setText(flightVM.getDepartureDate().getValue());
            _inboundStatus.setText(Constants.TicketStatusDecription.get(ticket.getInboundStatus()));

            flightVM = flightVMFactory.create(ticket.getOutboundFlight());

            _outboundFlightNumber.setText(String.valueOf(ticket.getOutboundFlightNumber()));
            _outboundDeparture.setText(flightVM.getDepartureLocale().getValue());
            _outboundArrival.setText(flightVM.getArrivalLocale().getValue());
            _outboundFlightDate.setText(flightVM.getDepartureDate().getValue());
            _outboundStatus.setText(Constants.TicketStatusDecription.get(ticket.getOutboundStatus()));

            _tripPrice.setText(String.valueOf(ticket.getPrice()));
        } catch (RecordNotFoundException e) {
            displayAlert(TICKET_NOT_FOUND_MSG);
        }
    }

    private void updatePrice() {
        Integer price = outboundFlight != null ? outboundFlight.getPrice() : 0;
        price += inboundFlight != null ? inboundFlight.getPrice() : 0;

        if (promotionDTO != null) {
            Double discount = price * (promotionDTO.getPercentage() / 100);
            price -= discount.intValue();

            _promotionText.setText(promotionDTO.getText());
        }

        _tripPrice.setText(price.toString());
    }

    private void displayAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Malandrinho");
        alert.setHeaderText(message);

        alert.showAndWait();
    }
}
