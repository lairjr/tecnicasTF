package view;

import domain.IDomainFacede;
import dtos.FlightDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import view.factories.IFlightVMFactory;
import view.models.FlightVM;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class TicketsController implements Initializable {
    private IDomainFacede domainFacede;
    private IFlightVMFactory flightVMFactory;

    @FXML
    private TableView<FlightVM> flightsTable;
    @FXML
    private TableColumn<FlightVM, Number> flightNumberColumn;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        flightNumberColumn.setCellValueFactory(f -> f.getValue().numberProperty());
    }

    public void searchFligths(ActionEvent actionEvent) {
        List<FlightDTO> filteredFligths = domainFacede.getFlights(null, null, null);
        ObservableList<FlightVM> flightVMs = FXCollections.observableArrayList();

        for (FlightDTO flight: filteredFligths) flightVMs.add(flightVMFactory.create(flight));

        flightsTable.setItems(flightVMs);
    }
}
