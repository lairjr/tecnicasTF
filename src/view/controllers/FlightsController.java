package view.controllers;

import domain.IDomainFacede;
import dtos.FlightDTO;
import infrastructure.ioc.IoCContainer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import view.factories.IFlightVMFactory;
import view.models.FlightVM;

import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

public class FlightsController implements Initializable {
    private IDomainFacede domainFacede;
    private IFlightVMFactory flightVMFactory;

    @FXML
    private TableView<FlightVM> flightsTable;
    @FXML
    private TableColumn<FlightVM, Number> flightNumberColumn;
    @FXML
    private TableColumn<FlightVM, String> flightArrivalLocaleColumn;
    @FXML
    private TableColumn<FlightVM, String> flightDepartureLocaleColumn;
    @FXML
    private TableColumn<FlightVM, String> flightDepartureDateColumn;
    @FXML
    private TableColumn<FlightVM, String> flightArrivalDateColumn;
    @FXML
    private TableColumn<FlightVM, Number> flightPriceColumn;
    @FXML
    private TextField _arrivalLocal;
    @FXML
    private DatePicker _arrivalDate;
    @FXML
    private TextField _departureLocal;
    @FXML
    private DatePicker _departureDate;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        solveDependencies();
        bindTableCollumns();
        setDefaultDate();
    }

    private void setDefaultDate() {
        _departureDate.setValue(LocalDate.now().minusDays(15));
        _arrivalDate.setValue(LocalDate.now().plusDays(15));
    }

    private void bindTableCollumns() {
        flightNumberColumn.setCellValueFactory(f -> f.getValue().numberProperty());
        flightArrivalLocaleColumn.setCellValueFactory(f -> f.getValue().getArrivalLocale());
        flightArrivalDateColumn.setCellValueFactory(f -> f.getValue().getArrivalDate());
        flightDepartureLocaleColumn.setCellValueFactory(f -> f.getValue().getDepartureLocale());
        flightDepartureDateColumn.setCellValueFactory(f -> f.getValue().getDepartureDate());
        flightPriceColumn.setCellValueFactory(f -> f.getValue().getPriceProperty());
    }

    private void solveDependencies() {
        flightVMFactory = IoCContainer.getFlightVMFactory();
        domainFacede = IoCContainer.getDomainFacede();
    }

    public void searchFligths() {
        String arrivalLocal = _arrivalLocal.getText();
        Date arrivalDate = _arrivalDate.getValue() != null ? Date.valueOf(_arrivalDate.getValue()) : null;
        String departureLocal = _departureLocal.getText();
        Date departureDate = _departureDate.getValue() != null ? Date.valueOf(_departureDate.getValue()) : null;

        List<FlightDTO> filteredFligths = domainFacede.getFlightsByDateAndLocale(departureDate, arrivalDate, departureLocal, arrivalLocal);
        ObservableList<FlightVM> flightVMs = FXCollections.observableArrayList();

        for (FlightDTO flight: filteredFligths) flightVMs.add(flightVMFactory.create(flight));

        flightsTable.setItems(flightVMs);
    }
}
