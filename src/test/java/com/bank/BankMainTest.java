package com.bank;

import org.junit.jupiter.api.Test;
import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

class BankMainTest {

    @Test
    void cliWorkflow() throws Exception {
        // Prepare simulated user input
        String input = String.join(
            System.lineSeparator(),
            "deposit 100",
            "withdraw 30",
            "exit"
        ) + System.lineSeparator();

        // Backup and replace System.in/out
        InputStream sysIn = System.in;
        PrintStream sysOut = System.out;
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setIn(in);
        System.setOut(new PrintStream(out));

        // Run the CLI
        Main.main(new String[]{});

        // Restore
        System.setIn(sysIn);
        System.setOut(sysOut);

        String console = out.toString();
        assertTrue(console.contains("Balance: $100.0"));
        assertTrue(console.contains("[LOG] Deposited 100.0"));
        assertTrue(console.contains("[LOG] Withdrew 30.0"));
    }
}
