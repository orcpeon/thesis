package main.java.business;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import main.java.StageSingleton;
import main.java.business.Settings;

import java.io.File;
import java.io.IOException;

//TODO ADD USERBASE
public class ProfController {

    private Stage stage = StageSingleton.getStage();
    private final String ADMINPASS = "adminipe";
    @FXML
    TextField profPassField = new TextField();
    @FXML
    TextField amountField = new TextField(String.valueOf(Settings.getAmount()));
    @FXML
    TextField interval = new TextField(String.valueOf(Settings.getInterval()));


    public  void loginAsProf(ActionEvent e) {
        if (profPassField.getText().equals(ADMINPASS)) {
            changeScene("/main/java/profviews/profmain.fxml");
        }
    }

    //TODO ADD ACTUAL SAVING
    //TODO FIX FORMAT EXCEPTION
    public void saveSettings(ActionEvent e) {
        int newAmount = Integer.parseInt(amountField.getText());
        int newInterval = Integer.parseInt(interval.getText());

        System.out.println(Settings.getAmount() + " " + Settings.getInterval());  //del
        if (newAmount>=1 && newAmount<=5) {
            Settings.setAmount(newAmount);
        }
        if (newInterval>=1 && newInterval<=40) {
            Settings.setInterval(newInterval);
        }
        System.out.println(Settings.getAmount() + " " + Settings.getInterval());  //del
        changeScene("/main/java/profviews/profmain.fxml");
    }

    public void openSettings(ActionEvent e) {
        changeScene("/main/java/profviews/profsettings.fxml");
        amountField.setText(String.valueOf(Settings.getAmount()));
        interval.setText(String.valueOf(Settings.getInterval()));
    }

    public void back(ActionEvent event) {
        changeScene("/main/java/profviews/profmain.fxml");
    }

    public void openUserbase(ActionEvent e) {
        FileChooser fc = new FileChooser();
        fc.setInitialDirectory(new File(System.getProperty("user.home")));
        fc.showOpenDialog(stage);
        changeScene("/main/java/profviews/profuserbase.fxml");
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
