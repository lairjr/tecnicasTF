package view.controllers;

import domain.DomainFacede;
import domain.IDomainFacede;
import domain.IFlightService;
import domain.ITicketService;
import domain.services.FlightService;
import domain.services.TicketService;
import dtos.FlightDTO;
import infrastructure.Database;
import infrastructure.IDatabase;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import org.apache.derby.jdbc.EmbeddedDataSource;
import repository.IFlightDao;
import repository.ITicketDao;
import repository.dao.FlightDao;
import repository.dao.TicketDao;
import view.factories.FlightVMFactory;
import view.factories.IFlightVMFactory;
import view.models.FlightVM;

import java.net.URL;
import java.sql.Date;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Created by ljunior on 6/23/16.
 */
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
    private TextField _arrivalLocal;
    @FXML
    private DatePicker _arrivalDate;
    @FXML
    private TextField _departureLocal;
    @FXML
    private DatePicker _departureDate;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.solveDependencies();
        flightNumberColumn.setCellValueFactory(f -> f.getValue().numberProperty());
        flightArrivalLocaleColumn.setCellValueFactory(f -> f.getValue().getArrivalLocale());
        flightArrivalDateColumn.setCellValueFactory(f -> f.getValue().getArrivalDate());
        flightDepartureLocaleColumn.setCellValueFactory(f -> f.getValue().getDepartureLocale());
        flightDepartureDateColumn.setCellValueFactory(f -> f.getValue().getDepartureDate());
    }

    private void solveDependencies() {
        flightVMFactory = new FlightVMFactory();

        EmbeddedDataSource dataSource = new EmbeddedDataSource();
        IDatabase database = Database.getInstance(dataSource);
        IFlightDao flightDao = new FlightDao(database);
        IFlightService flightService = new FlightService(flightDao);
        ITicketDao ticketDao = new TicketDao();
        ITicketService ticketService = new TicketService(ticketDao);
        domainFacede = new DomainFacede(flightService, ticketService);
    }

    public void searchFligths(ActionEvent actionEvent) {
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
