package view.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * Created by ljunior on 6/23/16.
 */
public class CheckinController {
    @FXML
    private Label _passengerName;
    @FXML
    private TextField _ticketNumber;

    public void searchTicket() {
        int ticketNumber = Integer.parseInt(_ticketNumber.getText());
    }
}
