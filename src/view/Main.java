package view;/**
 * Created by ljunior on 5/31/16.
 */

import infrastructure.Database;
import infrastructure.IDatabase;
import infrastructure.ioc.IoCContainer;
import infrastructure.mocks.FlightGenerator;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.apache.derby.jdbc.EmbeddedDataSource;
import org.codehaus.groovy.tools.shell.IO;

import java.sql.Connection;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        IDatabase database = IoCContainer.getDatabase();
        database.createOrCheckDatabase();

        FlightGenerator flightGenerator = IoCContainer.getFlightGenerator();
        flightGenerator.generateFlightsMocks();

        Parent root = FXMLLoader.load(getClass().getResource("main.fxml"));
        primaryStage.setTitle("Trabalho Técnicas");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
}
