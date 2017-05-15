package main.java.business;

public class Settings {

    private static int amount = 5;
    private static int interval = 20;
    public static String info;

    public static int getAmount() {
        return amount;
    }

    public static void setAmount(int newAmount) {
        amount = newAmount;
    }

    public static int getInterval() {
        return interval;
    }

    public static void setInterval(int newInterval) {
        interval = newInterval;
    }

    public static void setInfo(String newInfo) {
        info = newInfo;
    }

    public static String getInfo() {
        return info;
    }

}
