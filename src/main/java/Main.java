package main.java;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import main.java.studentviews.StudentController;

public class Main extends Application {

    private StudentController cont;
    private Stage primaryStage = StageSingleton.getStage();

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("profviews/mainlogin.fxml"));
        this.primaryStage.setTitle("App");
        this.primaryStage.setScene(new Scene(root, 640, 480));
        this.primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
