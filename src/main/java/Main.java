package main.java;

import dao.HibernateSessionFactory;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    public void start(Stage stage) throws IOException {
        Parent root=(Parent) FXMLLoader.load(getClass().getClassLoader().getResource("LabView.fxml"));
        Scene scene=new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Result Analysis System");
        stage.show();
    }

    public static void main(String[] args) {
        System.out.println("Starting...");
        launch(args);
        HibernateSessionFactory.shutdown();
    }
}
