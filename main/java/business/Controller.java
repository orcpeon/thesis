package main.java.business;

public class Controller {

    private Calculator calc;
    private Login login;
    private Student student;

    public Controller() {
        login = new Login();
        //student = login.createStudent();
    }
}
