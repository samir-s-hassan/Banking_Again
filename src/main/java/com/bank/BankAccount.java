package com.bank;

public class BankAccount {
    private String accountHolder;
    private double balance;
    private final TransactionLogger logger;


    public BankAccount(String accountHolder, TransactionLogger logger) {
        this.accountHolder = accountHolder;
        this.balance = 0.0;
        this.logger = logger;
    }

    public void deposit(double amount) {
        if (amount <= 0) throw new IllegalArgumentException("Invalid deposit");
        balance += amount;
        logger.log("Deposited " + amount);
    }

    public void withdraw(double amount) {
        if (amount <= 0 || amount > balance) throw new IllegalArgumentException("Invalid withdrawal");
        balance -= amount;
        logger.log("Withdrew " + amount);
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountHolder() {
        return accountHolder;
    }
}
