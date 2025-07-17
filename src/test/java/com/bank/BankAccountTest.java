package com.bank;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class BankAccountTest {

    @Test
    void depositShouldIncreaseBalance() {
        TransactionLogger mockLogger = mock(TransactionLogger.class);
        BankAccount acc = new BankAccount("Samir", mockLogger);
        acc.deposit(200.0);
        assertEquals(200.0, acc.getBalance());
    }

    @Test
    void withdrawShouldDecreaseBalance() {
        TransactionLogger mockLogger = mock(TransactionLogger.class);
        BankAccount acc = new BankAccount("Samir", mockLogger);
        acc.deposit(300.0);
        acc.withdraw(100.0);
        assertEquals(200.0, acc.getBalance());
    }

    @Test
    void cannotWithdrawMoreThanBalance() {
        TransactionLogger mockLogger = mock(TransactionLogger.class);
        BankAccount acc = new BankAccount("Samir", mockLogger);
        acc.deposit(100.0);
        assertThrows(IllegalArgumentException.class, () -> acc.withdraw(200.0));
    }
}