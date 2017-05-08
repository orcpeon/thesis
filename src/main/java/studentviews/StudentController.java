package main.java.studentviews;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import main.java.StageSingleton;

import java.io.IOException;

public class StudentController {

    @FXML
    private TextField nameField = new TextField();
    @FXML
    private TextField groupField = new TextField();
    @FXML
    private AnchorPane rootPane = new AnchorPane();
    @FXML
    private Button nextButton = new Button();
    @FXML
    private Button backButton = new Button();
    @FXML
    private TextArea infoArea = new TextArea(); //ADD TEXT
    @FXML
    private Button testButton = new Button();

    private Stage stage = StageSingleton.getStage();

    public void loginStudent(ActionEvent e) throws IOException {
        // System.out.println(nameField.getText() + " " + groupField.getText());
        AnchorPane pane = FXMLLoader.load(getClass().getResource("info.fxml"));
        rootPane.getChildren().setAll(pane);

    }

    public void buttonPressed(Button button) {
        button.setOnMouseClicked(event -> {
            if (event.isPrimaryButtonDown()) {
                button.setText("4");
            } else if (event.isSecondaryButtonDown()) {
                button.setText("5");
            }
        });
    }

    public void nextToMenu(ActionEvent e) throws IOException {
        System.out.println("Button works");
        changeScene("studentMenu.fxml");
    }

    public void goToTest(ActionEvent e) {
        changeScene("test.fxml");
    }

    public void backToInfo(ActionEvent e) throws IOException {
        System.out.println("Button works");
        changeScene("info.fxml");
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
