package main.java.business;

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
import main.java.business.Student;

import java.io.IOException;

public class StudentController {

    private Student student = Student.getInstance();

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
    @FXML
    private Button btnd = new Button();

    private Stage stage = StageSingleton.getStage();

    //TODO ADD STUDENT CREATION
    public void loginStudent(ActionEvent e) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/main/java/studentviews/info.fxml"));
        rootPane.getChildren().setAll(pane);

        student.setUsername(nameField.getText());
        student.setGroup(groupField.getText());
    }

    public void onClickMethod(ActionEvent event) {
        Button button = (Button) event.getSource();
        if (button.getText().equals("А")) {
            System.out.println("good");
        }
        button.setDisable(true);
    }

    public void goToStudentLogin(ActionEvent e) {
        changeScene("/main/java/studentviews/sample.fxml");
    }

    public void goToProfLogin(ActionEvent e) {
        changeScene("/main/java/profviews/proflogin.fxml");
    }

    public void nextToMenu(ActionEvent e) throws IOException {
        changeScene("/main/java/studentviews/studentMenu.fxml");
    }

    public void goToTest(ActionEvent e) {
        changeScene("/main/java/studentviews/test.fxml");
    }

    public void backToInfo(ActionEvent e) throws IOException {
        changeScene("/main/java/studentviews/info.fxml");
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
