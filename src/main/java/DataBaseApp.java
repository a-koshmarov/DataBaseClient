import dao.HibernateSessionFactory;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class DataBaseApp extends Application {

    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("LabView.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Data Base Client");
        stage.show();
    }

    public static void main(String[] args) {
        System.out.println("Starting...");
        launch(args);
        HibernateSessionFactory.shutdown();
    }
}
