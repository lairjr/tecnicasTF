package view;

import domain.DomainFacede;
import domain.IDomainFacede;
import domain.IFlightService;
import domain.ITicketService;
import domain.services.FlightService;
import domain.services.TicketService;
import dtos.FlightDTO;
import dtos.TicketDTO;
import infrastructure.Database;
import infrastructure.IDatabase;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import org.apache.derby.jdbc.EmbeddedDataSource;
import repository.IFlightDao;
import repository.ITicketDao;
import repository.dao.FlightDao;
import repository.dao.TicketDao;
import view.factories.FlightVMFactory;
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
    @FXML
    private TableColumn<FlightVM, String> flightArrivalLocaleColumn;
    @FXML
    private TableColumn<FlightVM, String> flightDepartureLocaleColumn;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.solveDependencies();
        flightNumberColumn.setCellValueFactory(f -> f.getValue().numberProperty());
        flightArrivalLocaleColumn.setCellValueFactory(f -> f.getValue().getArrivalLocale());
        flightDepartureLocaleColumn.setCellValueFactory(f -> f.getValue().getDepartureLocale());
    }

    private void solveDependencies() {
        flightVMFactory = new FlightVMFactory();

        EmbeddedDataSource dataSource = new EmbeddedDataSource();
        IDatabase database = Database.getInstance(dataSource);
        IFlightDao flightDao = new FlightDao(database);
        IFlightService flightService = new FlightService(flightDao);
        ITicketDao ticketDao = new TicketDao();
        ITicketService ticketService = new TicketService(ticketDao);
        this.domainFacede = new DomainFacede(flightService, ticketService);
    }

    public void searchFligths(ActionEvent actionEvent) {
        List<FlightDTO> filteredFligths = domainFacede.getFlightsByDateAndLocale(null, null, null, null);
        ObservableList<FlightVM> flightVMs = FXCollections.observableArrayList();

        for (FlightDTO flight: filteredFligths) flightVMs.add(flightVMFactory.create(flight));

        flightsTable.setItems(flightVMs);
    }

    public void saveTicket() {
        domainFacede.saveTicket(new TicketDTO());
    }

    public void setDependecies(IDomainFacede domainFacede) {
        this.domainFacede = domainFacede;
    }
}
