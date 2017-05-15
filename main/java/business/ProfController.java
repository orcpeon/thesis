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
import java.io.FileWriter;
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


    public void saveSettings(ActionEvent e) {
        int newAmount = Settings.getAmount();
        int newInterval = Settings.getInterval();

        try {
            newAmount = Integer.parseInt(amountField.getText());
            newInterval = Integer.parseInt(interval.getText());
        } catch (NumberFormatException nfe) {
            System.out.println("Field is empty");
        }

        System.out.println(Settings.getAmount() + " " + Settings.getInterval());  //del
        if (newAmount>=1 && newAmount<=5) {
            Settings.setAmount(newAmount);
        }
        if (newInterval>=1 && newInterval<=40) {
            Settings.setInterval(newInterval);
        }
        System.out.println(Settings.getAmount() + " " + Settings.getInterval());  //del

        try {
            FileWriter fw = new FileWriter(new File("/C:/Issledovanie/sets.xml"));
            String toWrite = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                    "<settings>\n" +
                    "    <amount>" +Settings.getAmount()+ "</amount>\n" +
                    "    <interval>" + Settings.getInterval() + "</interval>\n" +
                    "</settings>";
            fw.write(toWrite);
            fw.close();
        } catch (Exception e1) {
            System.out.println("Error saving settings");
        }
        changeScene("/main/java/profviews/profmain.fxml");
    }

    public void openSettings(ActionEvent e) {
        changeScene("/main/java/profviews/profsettings.fxml");
        amountField = new TextField();
        amountField.setText(String.valueOf(Settings.getAmount()));
        interval.setText(String.valueOf(Settings.getInterval()));
    }

    public void back(ActionEvent event) {
        changeScene("/main/java/profviews/profmain.fxml");
    }

    public void openUserbase(ActionEvent e) {
//        FileChooser fc = new FileChooser();
//        fc.setInitialDirectory(new File("src/main/java/data"));
//        fc.showOpenDialog(stage);
        try {
            Runtime.getRuntime().exec("explorer.exe /select," + "C:\\Issledovanie\\results\\");
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        //changeScene("/main/java/profviews/profuserbase.fxml");
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
