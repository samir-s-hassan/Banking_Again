package com.bank;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BankAccountTest {

    @Test
    void depositShouldIncreaseBalance() {
        BankAccount acc = new BankAccount("Samir");
        acc.deposit(200.0);
        assertEquals(200.0, acc.getBalance());
    }

    @Test
    void withdrawShouldDecreaseBalance() {
        BankAccount acc = new BankAccount("Samir");
        acc.deposit(300.0);
        acc.withdraw(100.0);
        assertEquals(200.0, acc.getBalance());
    }

    @Test
    void cannotWithdrawMoreThanBalance() {
        BankAccount acc = new BankAccount("Samir");
        acc.deposit(100.0);
        assertThrows(IllegalArgumentException.class, () -> acc.withdraw(200.0));
    }
}