package view.models;

import javafx.beans.InvalidationListener;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

import java.util.Observable;

/**
 * Created by ljunior on 6/1/16.
 */
public class FlightVM {
    private IntegerProperty number;

    public FlightVM(int num) {
        this.number = new SimpleIntegerProperty(num);
    }

    public int getNumber() {
        return number.get();
    }

    public IntegerProperty numberProperty() {
        return number;
    }

    public void setNumber(int number) {
        this.number.set(number);
    }
}
