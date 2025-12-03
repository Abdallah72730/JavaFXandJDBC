package org.example.javafxandjdbc;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.application.Application;
import javafx.stage.Stage;

public class StudentApplication extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        try {
            // Load the FXML file with the correct path
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/javafxandjdbc/student.fxml"));
            Parent root = loader.load();

            // Create a scene
            Scene scene = new Scene(root);

            // Set up the stage
            primaryStage.setTitle("Student Management System");
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
