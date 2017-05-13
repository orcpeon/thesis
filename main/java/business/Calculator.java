package main.java.business;

public class Calculator {

    private Student student;

    public Calculator(Student student) {
        this.student = student;
    }

    public void calculateAcc() {
        double result = ((student.getSymbolsFound()/10) * (student.getSymbolsFound()/10))/
                (student.getWrongSymbols() + student.getMissedSymbols());
        System.out.println(result);
        student.setAccCoefFirst(result);
    }

    public void calculateConcCoef() {
        double result = (student.getSymbolsFound()-student.getWrongSymbols())/
                (student.getSymbolsFound()+student.getMissedSymbols());
        System.out.println(result);
        student.setConcCoefFirst(result);
    }

    public void calculatSustain() {
        double result = (student.getSymbolsChecked()/student.getTime());
        student.setSustainability(result);
        System.out.println(result);
    }



}
