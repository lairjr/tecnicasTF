package view;/**
 * Created by ljunior on 5/31/16.
 */

import infrastructure.Database;
import infrastructure.IDatabase;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.apache.derby.jdbc.EmbeddedDataSource;

import java.sql.Connection;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("main.fxml"));
        primaryStage.setTitle("Trabalho Técnicas");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
}