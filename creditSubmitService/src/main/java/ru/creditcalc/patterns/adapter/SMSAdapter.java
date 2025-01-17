package ru.creditcalc.patterns.adapter;

public class SMSAdapter implements MessageSender {

    private SMSSender smsSender;

    @Override
    public void send(String to, String message) {
        smsSender.sendSMS(to, message);
    }

}
