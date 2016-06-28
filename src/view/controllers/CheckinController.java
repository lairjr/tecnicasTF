package view.controllers;

import domain.IDomainFacede;
import dtos.FlightDTO;
import dtos.SeatDTO;
import dtos.TicketDTO;
import infrastructure.Constants;
import infrastructure.exceptions.RecordNotFoundException;
import infrastructure.ioc.IoCContainer;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class CheckinController implements Initializable {
    private IDomainFacede domainFacede;

    @FXML
    private Label _passengerName;
    @FXML
    private TextField _ticketNumber;
    @FXML
    private Button btnCheckInInbound;
    @FXML
    private Button btnCheckInOutbound;

    private List<CheckBox> _outboundCheckboxes;
    private List<CheckBox> _inboundCheckboxes;
    private TicketDTO ticketDTO;
    private final String SELECT_SEAT_MSG = "Seleciona um voo malandrinho!";
    private final String TICKET_NOT_FOUND_MSG = "Passagem não encontrada!";

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        solveDependencies();
        setInboundCheckboxes();
        setOutboundCheckboxes();
    }

    private void solveDependencies() {
        domainFacede = IoCContainer.getDomainFacede();
    }

    public void searchTicket() {
        int ticketNumber = Integer.parseInt(_ticketNumber.getText());

        try {
            ticketDTO = domainFacede.getTicket(ticketNumber);
            displayTicket();
        } catch (RecordNotFoundException e) {
            displayAlert(TICKET_NOT_FOUND_MSG);
        }

    }

    public void checkInInbound() {
        int selectedSeat = getSelectedCheckbox(_inboundCheckboxes);

        if (selectedSeat == 0) {
            displayAlert(SELECT_SEAT_MSG);
        } else {
            ticketDTO = domainFacede.saveInbountSeat(ticketDTO.getTicketId(), ticketDTO.getInboundFlightNumber(), selectedSeat);
            displayTicket();
        }
    }

    public void checkInOutbound() {
        int selectedSeat = getSelectedCheckbox(_outboundCheckboxes);

        if (selectedSeat == 0) {
            displayAlert(SELECT_SEAT_MSG);
        } else {
            ticketDTO = domainFacede.saveOutboundSeat(ticketDTO.getTicketId(), ticketDTO.getOutboundFlightNumber(), selectedSeat);
            displayTicket();
        }
    }

    private int getSelectedCheckbox(List<CheckBox> checkboxes) {
        for (CheckBox checkbox: checkboxes) {
            if (checkbox.isSelected() && !checkbox.isDisable())
                return checkboxes.indexOf(checkbox) + 1;
        }
        return -1;
    }

    private void displayTicket() {
        _passengerName.setText(ticketDTO.getPassenger());
        displayFlight(ticketDTO.getOutboundFlight(), _outboundCheckboxes, btnCheckInOutbound, ticketDTO.getOutboundStatus());
        displayFlight(ticketDTO.getInboundFlight(), _inboundCheckboxes, btnCheckInInbound, ticketDTO.getInboundStatus());
    }

    private void displayAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Malandrinho");
        alert.setHeaderText(message);

        alert.showAndWait();
    }

    private void displayFlight(FlightDTO flight, List<CheckBox> checkboxes, Button checkinButton, Constants.TicketStatus flightStatus) {
        checkinButton.setDisable(flightStatus != Constants.TicketStatus.OpenCheckin);
        if (flight != null) {
            for (SeatDTO seat: flight.getSeats()) {
                CheckBox checkbox = checkboxes.get(seat.getNumber() - 1);
                checkbox.setDisable(seat.getOccupied());
                checkbox.setSelected(seat.getOccupied());
            }
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

    @FXML
    private CheckBox _inboundSeat1;
    @FXML
    private CheckBox _inboundSeat2;
    @FXML
    private CheckBox _inboundSeat3;
    @FXML
    private CheckBox _inboundSeat4;
    @FXML
    private CheckBox _inboundSeat5;
    @FXML
    private CheckBox _inboundSeat6;
    @FXML
    private CheckBox _inboundSeat7;
    @FXML
    private CheckBox _inboundSeat8;
    @FXML
    private CheckBox _inboundSeat9;
    @FXML
    private CheckBox _inboundSeat10;
    @FXML
    private CheckBox _inboundSeat11;
    @FXML
    private CheckBox _inboundSeat12;
    @FXML
    private CheckBox _inboundSeat13;
    @FXML
    private CheckBox _inboundSeat14;
    @FXML
    private CheckBox _inboundSeat15;
    @FXML
    private CheckBox _inboundSeat16;
    @FXML
    private CheckBox _inboundSeat17;
    @FXML
    private CheckBox _inboundSeat18;
    @FXML
    private CheckBox _inboundSeat19;
    @FXML
    private CheckBox _inboundSeat20;
    @FXML
    private CheckBox _inboundSeat21;
    @FXML
    private CheckBox _inboundSeat22;
    @FXML
    private CheckBox _inboundSeat23;
    @FXML
    private CheckBox _inboundSeat24;
    @FXML
    private CheckBox _inboundSeat25;
    @FXML
    private CheckBox _inboundSeat26;
    @FXML
    private CheckBox _inboundSeat27;
    @FXML
    private CheckBox _inboundSeat28;
    @FXML
    private CheckBox _inboundSeat29;
    @FXML
    private CheckBox _inboundSeat30;
    @FXML
    private CheckBox _inboundSeat31;
    @FXML
    private CheckBox _inboundSeat32;
    @FXML
    private CheckBox _inboundSeat33;
    @FXML
    private CheckBox _inboundSeat34;
    @FXML
    private CheckBox _inboundSeat35;
    @FXML
    private CheckBox _inboundSeat36;
    @FXML
    private CheckBox _inboundSeat37;
    @FXML
    private CheckBox _inboundSeat38;
    @FXML
    private CheckBox _inboundSeat39;
    @FXML
    private CheckBox _inboundSeat40;

    private void setInboundCheckboxes() {
        _inboundCheckboxes = new ArrayList<>();

        _inboundCheckboxes.add(_inboundSeat1);
        _inboundCheckboxes.add(_inboundSeat2);
        _inboundCheckboxes.add(_inboundSeat3);
        _inboundCheckboxes.add(_inboundSeat4);
        _inboundCheckboxes.add(_inboundSeat5);
        _inboundCheckboxes.add(_inboundSeat6);
        _inboundCheckboxes.add(_inboundSeat7);
        _inboundCheckboxes.add(_inboundSeat8);
        _inboundCheckboxes.add(_inboundSeat9);
        _inboundCheckboxes.add(_inboundSeat10);
        _inboundCheckboxes.add(_inboundSeat11);
        _inboundCheckboxes.add(_inboundSeat12);
        _inboundCheckboxes.add(_inboundSeat13);
        _inboundCheckboxes.add(_inboundSeat14);
        _inboundCheckboxes.add(_inboundSeat15);
        _inboundCheckboxes.add(_inboundSeat16);
        _inboundCheckboxes.add(_inboundSeat17);
        _inboundCheckboxes.add(_inboundSeat18);
        _inboundCheckboxes.add(_inboundSeat19);
        _inboundCheckboxes.add(_inboundSeat20);
        _inboundCheckboxes.add(_inboundSeat21);
        _inboundCheckboxes.add(_inboundSeat22);
        _inboundCheckboxes.add(_inboundSeat23);
        _inboundCheckboxes.add(_inboundSeat24);
        _inboundCheckboxes.add(_inboundSeat25);
        _inboundCheckboxes.add(_inboundSeat26);
        _inboundCheckboxes.add(_inboundSeat27);
        _inboundCheckboxes.add(_inboundSeat28);
        _inboundCheckboxes.add(_inboundSeat29);
        _inboundCheckboxes.add(_inboundSeat30);
        _inboundCheckboxes.add(_inboundSeat31);
        _inboundCheckboxes.add(_inboundSeat32);
        _inboundCheckboxes.add(_inboundSeat33);
        _inboundCheckboxes.add(_inboundSeat34);
        _inboundCheckboxes.add(_inboundSeat35);
        _inboundCheckboxes.add(_inboundSeat36);
        _inboundCheckboxes.add(_inboundSeat37);
        _inboundCheckboxes.add(_inboundSeat38);
        _inboundCheckboxes.add(_inboundSeat39);
        _inboundCheckboxes.add(_inboundSeat40);
    }
}
