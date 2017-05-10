package main.java.studentviews;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import main.java.StageSingleton;

import java.io.IOException;

public class TestController {

    private Stage stage = StageSingleton.getStage();

    public void onClickMethod(ActionEvent event) {
        Button button = (Button) event.getSource();
        if (button.getText().equals("К")) {
            System.out.println("good");
        }
        button.setDisable(true);
    }

    public void goToSecond(ActionEvent e) {
        changeScene("testsecond.fxml");
    }

    public void goToThird(ActionEvent e) {
        changeScene("testthird.fxml");
    }

    public void goToFourth(ActionEvent e) {
        changeScene("testfourth.fxml");
    }

    public void goToFifth(ActionEvent e) {
        changeScene("testfifth.fxml");
    }


    public void finishTest(ActionEvent e) {
        changeScene("studentResult.fxml");
    }

    //TODO SAVE TO XML
    public void saveAndExit(ActionEvent e) {
        System.out.println("Done");
        Platform.exit();
    }

    private void changeScene(String location) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource(location));
            stage.setScene(new Scene(root));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
