package view;
import infrastructure.IDatabase;
import infrastructure.ioc.IoCContainer;
import infrastructure.mocks.FlightGenerator;
import infrastructure.mocks.PromotionGenerator;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.SQLException;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        //generateMock();
        Parent root = FXMLLoader.load(getClass().getResource("main.fxml"));
        primaryStage.setTitle("Trabalho Técnicas");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    private void generateMock() throws SQLException {
        IDatabase database = IoCContainer.getDatabase();
        database.createOrCheckDatabase();

        FlightGenerator flightGenerator = IoCContainer.getFlightGenerator();
        flightGenerator.generateFlightsMocks();

        PromotionGenerator promotionGenerator = IoCContainer.getPromotionGenerator();
        promotionGenerator.generatePromotionMocks();
    }
}
