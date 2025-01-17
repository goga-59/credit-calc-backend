package ru.creditcalc.patterns.prototype;

import lombok.Getter;

@Getter
public class SavingAccount implements Account {

    private String accountName;
    private double balance;

    @Override
    public Account clone() throws CloneNotSupportedException {
        return (SavingAccount) super.clone();
    }

    @Override
    public void displayInfo() {
        System.out.println("accountName: " + accountName);
        System.out.println("balance: " + balance);
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient balance");
            return;
        }
        balance -= amount;
    }

}
