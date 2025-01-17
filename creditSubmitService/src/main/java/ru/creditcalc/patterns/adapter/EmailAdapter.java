package ru.creditcalc.patterns.adapter;

import lombok.Getter;

@Getter
public class EmailAdapter implements MessageSender {

    private EmailSender emailSender;

    @Override
    public void send(String to, String message) {
        emailSender.sendEmail(to, message);
    }

}
