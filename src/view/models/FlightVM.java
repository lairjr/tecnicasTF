package view.models;

import dtos.FlightDTO;
import javafx.beans.property.*;

import java.time.format.DateTimeFormatter;

/**
 * Created by ljunior on 6/1/16.
 */
public class FlightVM {
    private IntegerProperty number;
    private StringProperty arrivalLocale;
    private StringProperty arrivalDate;
    private StringProperty departureLocale;
    private StringProperty departureDate;
    private IntegerProperty price;

    public FlightVM(FlightDTO flightDTO) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        this.number = new SimpleIntegerProperty(flightDTO.getFlightId());
        this.arrivalLocale = new SimpleStringProperty(flightDTO.getArrivalLocale());
        this.arrivalDate = new SimpleStringProperty(flightDTO.getArrivalDate().format(formatter));
        this.departureLocale = new SimpleStringProperty(flightDTO.getDepartureLocale());
        this.departureDate = new SimpleStringProperty(flightDTO.getDepartureDate().format(formatter));
        this.price = new SimpleIntegerProperty(flightDTO.getPrice());
    }

    public int getNumber() {
        return number.get();
    }

    public IntegerProperty numberProperty() {
        return number;
    }

    public StringProperty getArrivalLocale() {
        return arrivalLocale;
    }

    public StringProperty getDepartureLocale() {
        return departureLocale;
    }

    public StringProperty getArrivalDate() {
        return arrivalDate;
    }

    public StringProperty getDepartureDate() {
        return departureDate;
    }

    public IntegerProperty getPriceProperty() { return price; }
}
