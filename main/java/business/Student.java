package main.java.business;

public class Student {

    private String username;
    private String group;
    private double accCoefFirst; //A1
    private double concCoefFirst; //K1
    private int symbolsFound = 0; //N
    private int wrongSymbols = 0; //r
    private int missedSymbols = 0; //p
    private int symbolsChecked = 0; //S, prosmotrennie simvoli; prosmotrennie strochki = symbolsChecked/10
    private double time; //t
    private double sustainability;

    private static Student instance;

    private Student() {
    }

    public static Student getInstance() {
        if (instance==null) {
            instance = new Student();
        }
        return instance;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public double getSustainability() {
        return sustainability;
    }

    public void setSustainability(double sustainability) {
        this.sustainability = sustainability;
    }

    public double getAccCoefFirst() {
        return accCoefFirst;
    }

    public void setAccCoefFirst(double accCoefFirst) {
        this.accCoefFirst = accCoefFirst;
    }

    public double getConcCoefFirst() {
        return concCoefFirst;
    }

    public void setConcCoefFirst(double concCoefFirst) {
        this.concCoefFirst = concCoefFirst;
    }

    public int getSymbolsFound() {
        return symbolsFound;
    }

    public void setSymbolsFound(int symbolsFound) {
        this.symbolsFound = symbolsFound;
    }

    public int getWrongSymbols() {
        return wrongSymbols;
    }

    public void setWrongSymbols(int wrongSymbols) {
        this.wrongSymbols = wrongSymbols;
    }

    public int getMissedSymbols() {
        return missedSymbols;
    }

    public void setMissedSymbols(int missedSymbols) {
        this.missedSymbols = missedSymbols;
    }

    public int getSymbolsChecked() {
        return symbolsChecked;
    }

    public void setSymbolsChecked(int symbolsChecked) {
        this.symbolsChecked = symbolsChecked;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }



}
