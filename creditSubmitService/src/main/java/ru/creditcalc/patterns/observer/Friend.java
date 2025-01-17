package ru.creditcalc.patterns.observer;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Friend implements Subject {

    List<Observer> observers = new ArrayList<Observer>();
    private String name;

    public void setName(String name) {
        this.name = name;
        notifyObservers();
    }

    @Override
    public void addObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer o : observers) {
            o.update(name);
        }
    }

}
