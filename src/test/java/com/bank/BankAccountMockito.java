package com.bank;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class BankAccountMockitoTest {

    @Test
    void deposit_logsTransactionAndUpdatesBalance() {
        // Arrange
        TransactionLogger mockLogger = mock(TransactionLogger.class);
        BankAccount acc = new BankAccount("Samir", mockLogger);

        // Act
        acc.deposit(200);

        // Assert – state
        assertEquals(200, acc.getBalance());

        // Assert – interaction
        verify(mockLogger).log("Deposited 200.0");
    }
}
