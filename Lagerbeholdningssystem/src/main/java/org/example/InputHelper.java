package org.example;

import java.util.Scanner;

public class InputHelper {
    private final Scanner scanner;

    public InputHelper() {
        scanner = new Scanner(System.in);
    }

    public String getString(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    public int getInt(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter an integer.");
            scanner.next();
            System.out.print(prompt);
        }
        return scanner.nextInt();
    }

    public void close() {
        scanner.close();
    }
}