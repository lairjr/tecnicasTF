package view.controllers;

import domain.IDomainFacede;
import dtos.PromotionDTO;
import infrastructure.ioc.IoCContainer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import view.factories.IPromotionVMFactory;
import view.models.FlightVM;
import view.models.PromotionVM;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Created by ljunior on 6/28/16.
 */
public class PromotionController implements Initializable {
    private IDomainFacede domainFacede;
    private IPromotionVMFactory promotionVMFactory;

    @FXML
    private TableView<PromotionVM> promotionTable;
    @FXML
    private TableColumn<PromotionVM, String> promotionTextColumn;
    @FXML
    private TableColumn<PromotionVM, String> promotionNumberOfPurchasesColumn;
    @FXML
    private TableColumn<PromotionVM, String> promotionPercentageColumn;
    @FXML
    private TextField _text;
    @FXML
    private TextField _numberOfPurchases;
    @FXML
    private TextField _percentage;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        solveDependencies();
        bindTableCollumns();
        loadPromotions();
    }

    private void solveDependencies() {
        domainFacede = IoCContainer.getDomainFacede();
        promotionVMFactory = IoCContainer.getPromotionVMFactory();
    }

    private void bindTableCollumns() {
        promotionTextColumn.setCellValueFactory(f -> f.getValue().getText());
        promotionNumberOfPurchasesColumn.setCellValueFactory(f -> f.getValue().getNumberOfPurchases());
        promotionPercentageColumn.setCellValueFactory(f -> f.getValue().getPercentage());
    }

    private void loadPromotions() {
        List<PromotionDTO> promotions = domainFacede.getPromotions();
        ObservableList<PromotionVM> promotionVMs = FXCollections.observableArrayList();

        for (PromotionDTO promotion: promotions) promotionVMs.add(promotionVMFactory.create(promotion));

        promotionTable.setItems(promotionVMs);
    }

    public void savePromotion() {
        String text = _text.getText();
        int numberOfPurchases = Integer.parseInt(_numberOfPurchases.getText());
        double percentage = Double.parseDouble(_percentage.getText());

        domainFacede.savePromotion(text, numberOfPurchases, percentage);

        loadPromotions();
    }
}
