package main.java.business;

public class Settings {

    private static int amount = 5;
    private static int interval = 20;

    public static int getAmount() {
        return amount;
    }

    public static void setAmount(int amount) {
        amount = amount;
    }

    public static int getInterval() {
        return interval;
    }

    public static void setInterval(int interval) {
        interval = interval;
    }
}
