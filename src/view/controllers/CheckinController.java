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

    private List<CheckBox> _outboundCheckboxes;
    private List<CheckBox> _inboundCheckboxes;
    private TicketDTO ticketDTO;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        solveDependencies();
        setInboundCheckboxes();
        setOutboundCheckboxes();
    }

    private void solveDependencies() {
        domainFacede = IoCContainer.getDomainFacede();
    }

    private int getSelectedCheckbox(List<CheckBox> checkboxes) {
        for (CheckBox checkbox: checkboxes) {
            if (checkbox.isSelected() && !checkbox.isDisable())
                return checkboxes.indexOf(checkbox) + 1;
        }
        return -1;
    }

    public void searchTicket() {
        int ticketNumber = Integer.parseInt(_ticketNumber.getText());

        ticketDTO = domainFacede.getTicket(ticketNumber);

        displayTicket();
    }

    public void checkInInbound() {
        flightCheckIn(_inboundCheckboxes, ticketDTO.getInboundFlightNumber());
    }

    public void checkInOutbound() {
        flightCheckIn(_outboundCheckboxes, ticketDTO.getOutboundFlightNumber());
    }

    private void flightCheckIn(List<CheckBox> checkboxes, int flightNumber) {
        int selectedSeat = getSelectedCheckbox(checkboxes);
        domainFacede.saveSeat(flightNumber, selectedSeat);
    }

    private void displayTicket() {
        _passengerName.setText(ticketDTO.getPassenger());
        displayFlight(ticketDTO.getOutboundFlight(), _outboundCheckboxes);
        displayFlight(ticketDTO.getInboundFlight(), _inboundCheckboxes);
    }

    private void displayFlight(FlightDTO flight, List<CheckBox> checkboxes) {
        for (SeatDTO seat: flight.getSeats()) {
            CheckBox checkbox = checkboxes.get(seat.getNumber() - 1);
            checkbox.setDisable(seat.getStatus());
            checkbox.setSelected(seat.getStatus());
        }
    }

    /* Checkboxes declaration */

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
    @FXML
    private CheckBox _outboundSeat21;
    @FXML
    private CheckBox _outboundSeat22;
    @FXML
    private CheckBox _outboundSeat23;
    @FXML
    private CheckBox _outboundSeat24;
    @FXML
    private CheckBox _outboundSeat25;
    @FXML
    private CheckBox _outboundSeat26;
    @FXML
    private CheckBox _outboundSeat27;
    @FXML
    private CheckBox _outboundSeat28;
    @FXML
    private CheckBox _outboundSeat29;
    @FXML
    private CheckBox _outboundSeat30;
    @FXML
    private CheckBox _outboundSeat31;
    @FXML
    private CheckBox _outboundSeat32;
    @FXML
    private CheckBox _outboundSeat33;
    @FXML
    private CheckBox _outboundSeat34;
    @FXML
    private CheckBox _outboundSeat35;
    @FXML
    private CheckBox _outboundSeat36;
    @FXML
    private CheckBox _outboundSeat37;
    @FXML
    private CheckBox _outboundSeat38;
    @FXML
    private CheckBox _outboundSeat39;
    @FXML
    private CheckBox _outboundSeat40;

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
        _outboundCheckboxes.add(_outboundSeat21);
        _outboundCheckboxes.add(_outboundSeat22);
        _outboundCheckboxes.add(_outboundSeat23);
        _outboundCheckboxes.add(_outboundSeat24);
        _outboundCheckboxes.add(_outboundSeat25);
        _outboundCheckboxes.add(_outboundSeat26);
        _outboundCheckboxes.add(_outboundSeat27);
        _outboundCheckboxes.add(_outboundSeat28);
        _outboundCheckboxes.add(_outboundSeat29);
        _outboundCheckboxes.add(_outboundSeat30);
        _outboundCheckboxes.add(_outboundSeat31);
        _outboundCheckboxes.add(_outboundSeat32);
        _outboundCheckboxes.add(_outboundSeat33);
        _outboundCheckboxes.add(_outboundSeat34);
        _outboundCheckboxes.add(_outboundSeat35);
        _outboundCheckboxes.add(_outboundSeat36);
        _outboundCheckboxes.add(_outboundSeat37);
        _outboundCheckboxes.add(_outboundSeat38);
        _outboundCheckboxes.add(_outboundSeat39);
        _outboundCheckboxes.add(_outboundSeat40);
    }

    private void setInboundCheckboxes() {
        _inboundCheckboxes = new ArrayList<>();
    }
}
