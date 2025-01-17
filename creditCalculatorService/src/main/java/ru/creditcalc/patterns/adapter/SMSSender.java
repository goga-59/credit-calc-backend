package ru.creditcalc.patterns.adapter;

public class SMSSender {

    private String from;

    public void sendSMS(String to, String message) {
        System.out.format("Sending %s to %s%n", message, to);
    }

}
