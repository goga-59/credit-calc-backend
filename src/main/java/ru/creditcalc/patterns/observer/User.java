package ru.creditcalc.patterns.observer;

import lombok.Getter;

@Getter
public class User implements Observer {

    private String name;

    @Override
    public void update(String name) {
        System.out.format("%s change name!", name);
    }

}
