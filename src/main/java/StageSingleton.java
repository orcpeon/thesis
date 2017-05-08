package main.java;

import javafx.stage.Stage;

public class StageSingleton {

    private static Stage primaryStage;

    private StageSingleton() {
        }

    public static Stage getStage() {
        if (primaryStage==null) {
            primaryStage = new Stage();
        }
        return primaryStage;
    }
}
