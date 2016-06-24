package view.controllers;

import domain.IDomainFacede;
import dtos.TicketDTO;
import infrastructure.ioc.IoCContainer;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by ljunior on 6/23/16.
 */
public class CheckinController implements Initializable {
    private IDomainFacede domainFacede;

    @FXML
    private Label _passengerName;
    @FXML
    private TextField _ticketNumber;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        solveDependencies();
    }

    private void solveDependencies() {
        domainFacede = IoCContainer.getDomainFacede();
    }

    public void searchTicket() {
        int ticketNumber = Integer.parseInt(_ticketNumber.getText());

        TicketDTO ticket = domainFacede.getTicket(ticketNumber);

        displayTicket(ticket);
    }

    private void displayTicket(TicketDTO ticket) {
        _passengerName.setText(ticket.getPassenger());
    }
}
