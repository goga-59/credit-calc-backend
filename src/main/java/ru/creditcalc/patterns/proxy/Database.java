package ru.creditcalc.patterns.proxy;

public class Database implements Resource {

    @Override
    public void dropDatabase() {
        System.out.println("База данных больше нет!");
    }

}
