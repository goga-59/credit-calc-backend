package ru.creditcalc.patterns.prototype;

public interface Account extends Cloneable {

    Account clone() throws CloneNotSupportedException;
    void displayInfo();

}
