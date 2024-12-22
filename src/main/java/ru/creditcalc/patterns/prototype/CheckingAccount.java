package ru.creditcalc.patterns.prototype;

import lombok.Getter;

@Getter
public class CheckingAccount implements Account {

    private String accountName;
    private double balance;
    private double limit;

    @Override
    public Account clone() throws CloneNotSupportedException {
        return (CheckingAccount) super.clone();
    }

    @Override
    public void displayInfo() {
        System.out.println("Account Name: " + accountName);
        System.out.println("Balance: " + balance);
        System.out.println("Limit: " + limit);
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient Balance");
            return;
        }
        if (amount > limit) {
            System.out.println("Insufficient Limit");
            return;
        }
        balance -= amount;
    }

}
