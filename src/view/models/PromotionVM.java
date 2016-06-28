package view.models;

import dtos.PromotionDTO;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by ljunior on 6/28/16.
 */
public class PromotionVM {
    private StringProperty text;
    private StringProperty numberOfPurchases;
    private StringProperty percentage;

    public PromotionVM(PromotionDTO promotionDTO) {
        this.text = new SimpleStringProperty(promotionDTO.getText());
        this.numberOfPurchases = new SimpleStringProperty(String.valueOf(promotionDTO.getNumberOfPurchases()));
        this.percentage = new SimpleStringProperty(String.valueOf(promotionDTO.getPercentage()));
    }

    public StringProperty getText() {
        return text;
    }

    public StringProperty getNumberOfPurchases() {
        return numberOfPurchases;
    }

    public StringProperty getPercentage() {
        return percentage;
    }
}
