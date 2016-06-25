package view.controllers;

import domain.IDomainFacede;
import dtos.FlightDTO;
import dtos.SeatDTO;
import dtos.TicketDTO;
import infrastructure.ioc.IoCContainer;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.CheckBox;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.function.Function;

/**
 * Created by ljunior on 6/23/16.
 */
public class CheckinController implements Initializable {
    private IDomainFacede domainFacede;

    @FXML
    private Label _passengerName;
    @FXML
    private TextField _ticketNumber;
    @FXML
    private CheckBox _outboundSeat1;
    @FXML
    private CheckBox _outboundSeat2;
    @FXML
    private CheckBox _outboundSeat3;
    @FXML
    private CheckBox _outboundSeat4;
    @FXML
    private CheckBox _outboundSeat5;
    @FXML
    private CheckBox _outboundSeat6;
    @FXML
    private CheckBox _outboundSeat7;
    @FXML
    private CheckBox _outboundSeat8;
    @FXML
    private CheckBox _outboundSeat9;
    @FXML
    private CheckBox _outboundSeat10;
    @FXML
    private CheckBox _outboundSeat11;
    @FXML
    private CheckBox _outboundSeat12;
    @FXML
    private CheckBox _outboundSeat13;
    @FXML
    private CheckBox _outboundSeat14;
    @FXML
    private CheckBox _outboundSeat15;
    @FXML
    private CheckBox _outboundSeat16;
    @FXML
    private CheckBox _outboundSeat17;
    @FXML
    private CheckBox _outboundSeat18;
    @FXML
    private CheckBox _outboundSeat19;
    @FXML
    private CheckBox _outboundSeat20;

    private List<CheckBox> _outboundCheckboxes;
    private List<CheckBox> _inboundCheckboxes;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        solveDependencies();
        setInboundCheckboxes();
        setOutboundCheckboxes();
    }

    private void solveDependencies() {
        domainFacede = IoCContainer.getDomainFacede();
    }

    private void setOutboundCheckboxes() {
        _outboundCheckboxes = new ArrayList<>();

        _outboundCheckboxes.add(_outboundSeat1);
        _outboundCheckboxes.add(_outboundSeat2);
        _outboundCheckboxes.add(_outboundSeat3);
        _outboundCheckboxes.add(_outboundSeat4);
        _outboundCheckboxes.add(_outboundSeat5);
        _outboundCheckboxes.add(_outboundSeat6);
        _outboundCheckboxes.add(_outboundSeat7);
        _outboundCheckboxes.add(_outboundSeat8);
        _outboundCheckboxes.add(_outboundSeat9);
        _outboundCheckboxes.add(_outboundSeat10);
        _outboundCheckboxes.add(_outboundSeat11);
        _outboundCheckboxes.add(_outboundSeat12);
        _outboundCheckboxes.add(_outboundSeat13);
        _outboundCheckboxes.add(_outboundSeat14);
        _outboundCheckboxes.add(_outboundSeat15);
        _outboundCheckboxes.add(_outboundSeat16);
        _outboundCheckboxes.add(_outboundSeat17);
        _outboundCheckboxes.add(_outboundSeat18);
        _outboundCheckboxes.add(_outboundSeat19);
        _outboundCheckboxes.add(_outboundSeat20);
    }

    private void setInboundCheckboxes() {

    }

    public void searchTicket() {
        int ticketNumber = Integer.parseInt(_ticketNumber.getText());

        TicketDTO ticket = domainFacede.getTicket(ticketNumber);

        displayTicket(ticket);
    }

    public void checkInInbound() {

    }

    public void checkInOutbound() {

    }

    private void displayTicket(TicketDTO ticket) {
        _passengerName.setText(ticket.getPassenger());
        displayFlight(ticket.getOutboundFlight(), _outboundCheckboxes);
        displayFlight(ticket.getInboundFlight(), _inboundCheckboxes);
    }

    private void displayFlight(FlightDTO flight, List<CheckBox> checkboxes) {
        for (SeatDTO seat: flight.getSeats()) {
            CheckBox checkbox = checkboxes.get(seat.getNumber() - 1);
            checkbox.setDisable(seat.getStatus());
            checkbox.setSelected(seat.getStatus());
        }
    }


    private javafx.scene.control.CheckBox getInboundSeatCheckbox(SeatDTO seat) {
        return _outboundSeat2;
    }
}
