package main.java.business;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.Duration;
import main.java.StageSingleton;
import main.java.business.Student;

import javax.xml.soap.Text;
import java.io.IOException;

public class TestController {

    private Student student = Student.getInstance();
    private Stage stage = StageSingleton.getStage();
    //private Calculator calc;
    private int correctSymbols = 0;
    private int incorrectSymbols = 0;
    private int total = student.getSymbolsFound();
    private int missed = student.getMissedSymbols();
    private int wrong = student.getWrongSymbols();
    private double cAcc = 0;
    private int multAcc = 1;
    private double cConc = 0;

    @FXML
    private TextField coef = new TextField();
    @FXML
    private TextField conc = new TextField();
    @FXML
    private TextField found = new TextField();
    @FXML
    private TextField inc = new TextField();
    @FXML
    private TextField msd = new TextField();
    @FXML
    private TextField checked = new TextField();
    @FXML
    private TextField timing = new TextField();
    @FXML
    private TextField sustcoef = new TextField();
    @FXML
    private Label pom1 = new Label();

    public void onClickMethod(ActionEvent event) {
        Button button = (Button) event.getSource();
        if (button.getText().equals("К") || button.getText().equals("Р")) {
            System.out.println("good");
            total++;
            correctSymbols++;
        } else {
            total++;
            incorrectSymbols++;
            wrong++;
        }

        button.setDisable(true);
    }

    public void updateStudent(int symbolsTotal) {
        missed += symbolsTotal - correctSymbols;
        student.setSymbolsFound(total);
        student.setMissedSymbols(missed);
        student.setWrongSymbols(wrong);
        try {
            cAcc = calcAcc();
            cConc = calcConc();
        } catch (Exception e) {
            cAcc = 0;
        }
        student.setAccCoefFirst(cAcc);
        student.setConcCoefFirst(cConc);
        System.out.println(student.getAccCoefFirst());
        System.out.println(student.getConcCoefFirst());

        System.out.println("Total: " + total);
        System.out.println("Missed: " + missed);
        System.out.println("Wrong: " + wrong);
        System.out.println(cAcc);
    }

    //TODO SAVE TO XML
    public void saveAndExit(ActionEvent e) {

        System.out.println("Done");
        student.setSymbolsFound(total);
        student.setMissedSymbols(missed);
        student.setWrongSymbols(wrong);

        //calc = new Calculator(student);
        student.setTime(2);
        calculateAcc(student);
        calculateConcCoef(student);
        calculatSustain(student);
        System.out.println(student.getAccCoefFirst());
        System.out.println(student.getConcCoefFirst());
        System.out.println(student.getSustainability());

        System.out.println("Total: " + student.getSymbolsFound());
        System.out.println("Missed: " + student.getMissedSymbols());
        System.out.println("Wrong: " + student.getWrongSymbols());
        Platform.exit();
    }

    private double calcAcc() {
        return (250) / (wrong + missed);
    }

    private double calcConc() {
        return (Math.random() + 0.5) * (100) / (40);
    }

    public void goToSecond(ActionEvent e) {
        updateStudent(15);
        changeScene("/main/java/studentviews/testsecond.fxml");
        Timeline pomeha = new Timeline(new KeyFrame(Duration.seconds(5), event -> {
            System.out.println("this is called every 5 seconds on UI thread");
            pom1.setText("LMAO");
            System.out.println(pom1.getText());
        }));
        pomeha.setCycleCount(Timeline.INDEFINITE);
        pomeha.play();
    }

    public void goToThird(ActionEvent e) {
        updateStudent(19);
        changeScene("/main/java/studentviews/testthird.fxml");
    }

    public void goToFourth(ActionEvent e) {
        updateStudent(19);
        changeScene("/main/java/studentviews/testfourth.fxml");
    }

    public void goToFifth(ActionEvent e) {
        updateStudent(19);
        changeScene("/main/java/studentviews/testfifth.fxml");
    }


    public void finishTest(ActionEvent e) {
        updateStudent(20);

        changeScene("/main/java/studentviews/studentResult.fxml");
    }

    public void showResult(ActionEvent e) {
        System.out.println(cAcc);
        coef.setText(String.valueOf(student.getAccCoefFirst()));
        conc.setText(String.valueOf(student.getConcCoefFirst()));
        found.setText(String.valueOf(total));
        inc.setText(String.valueOf(wrong));
        msd.setText(String.valueOf(missed));
        checked.setText("some");
        timing.setText("lol");
        sustcoef.setText("shit");
    }


    private void changeScene(String location) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource(location));
            stage.setScene(new Scene(root));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void endTraining(ActionEvent e) {
        changeScene("/main/java/studentviews/studentmain.fxml");
    }


    public void calculateAcc(Student student) {
        double result = ((student.getSymbolsFound() / 10) * (student.getSymbolsFound() / 10)) /
                (student.getWrongSymbols() + student.getMissedSymbols());
        System.out.println(result);
        student.setAccCoefFirst(result);
    }

    public void calculateConcCoef(Student student) {
        double result = (student.getSymbolsFound() - student.getWrongSymbols()) /
                (student.getSymbolsFound() + student.getMissedSymbols());
        System.out.println(result);
        student.setConcCoefFirst(result);
    }

    public void calculatSustain(Student student) {
        double result = (student.getSymbolsChecked() / student.getTime());
        student.setSustainability(result);
        System.out.println(result);
    }


}
