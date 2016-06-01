package view;

import dtos.FlightDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import view.models.FlightVM;

import java.net.URL;
import java.util.ResourceBundle;

public class TicketsController implements Initializable {
    @FXML
    private TableView<FlightVM> flightsTable;
    @FXML
    private TableColumn<FlightVM, Number> flightNumberColumn;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        flightNumberColumn.setCellValueFactory(f -> f.getValue().numberProperty());
    }

    public void searchFligths(ActionEvent actionEvent) {
        ObservableList<FlightVM> flights = FXCollections.observableArrayList();

        flights.add(new FlightVM(1));
        flights.add(new FlightVM(2));
        flights.add(new FlightVM(3));
        flights.add(new FlightVM(4));

        flightsTable.setItems(flights);
    }
}
