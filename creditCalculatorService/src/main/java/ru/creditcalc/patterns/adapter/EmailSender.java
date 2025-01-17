package ru.creditcalc.patterns.adapter;

public class EmailSender {

    private String from;

    public void sendEmail(String to, String message) {
        System.out.format("Sending %s to: %s%n", message, to);
    }

}
