package ru.creditcalc.patterns.observer;

public interface Subject {

    void addObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers();

}
