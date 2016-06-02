package view.models;

import dtos.FlightDTO;
import javafx.beans.InvalidationListener;
import javafx.beans.property.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

import java.util.Date;
import java.util.Observable;

/**
 * Created by ljunior on 6/1/16.
 */
public class FlightVM {
    private IntegerProperty number;
    private StringProperty arrivalLocale;
    private StringProperty departureLocale;

    public FlightVM(FlightDTO flightDTO) {
        this.number = new SimpleIntegerProperty(flightDTO.getNumber());
        this.arrivalLocale = new SimpleStringProperty(flightDTO.getArrivalLocale());
        this.departureLocale = new SimpleStringProperty(flightDTO.getDepartureLocale());
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
}
