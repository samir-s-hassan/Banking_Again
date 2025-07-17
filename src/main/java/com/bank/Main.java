package com.bank;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TransactionLogger logger = message -> System.out.println("[LOG] " + message);
        BankAccount account = new BankAccount("Samir", logger);

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nBalance: $" + account.getBalance());
            System.out.print("Enter command (deposit X, withdraw X, exit): ");
            String cmd = scanner.nextLine();
            if (cmd.equalsIgnoreCase("exit"))
                break;

            String[] parts = cmd.split(" ");
            try {
                double amt = Double.parseDouble(parts[1]);
                if (parts[0].equalsIgnoreCase("deposit")) {
                    account.deposit(amt);
                } else if (parts[0].equalsIgnoreCase("withdraw")) {
                    account.withdraw(amt);
                } else {
                    System.out.println("Unknown command");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        scanner.close();
        System.out.println("Goodbye!");

    }

}