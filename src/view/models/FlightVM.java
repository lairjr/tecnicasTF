package view.models;

import dtos.FlightDTO;
import javafx.beans.property.*;

import java.text.SimpleDateFormat;

/**
 * Created by ljunior on 6/1/16.
 */
public class FlightVM {
    private IntegerProperty number;
    private StringProperty arrivalLocale;
    private StringProperty arrivalDate;
    private StringProperty departureLocale;
    private StringProperty departureDate;

    public FlightVM(FlightDTO flightDTO) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        this.number = new SimpleIntegerProperty(flightDTO.getNumber());
        this.arrivalLocale = new SimpleStringProperty(flightDTO.getArrivalLocale());
        this.arrivalDate = new SimpleStringProperty(dateFormat.format(flightDTO.getArrivalDate()));
        this.departureLocale = new SimpleStringProperty(flightDTO.getDepartureLocale());
        this.departureDate = new SimpleStringProperty(dateFormat.format(flightDTO.getDepartureDate()));
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
}
