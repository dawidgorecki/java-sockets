package pl.dawidgorecki.utils;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleInput {
    private ConsoleInput() {
    }

    public static long getLong() {
        long input = 0;
        boolean isValid = false;

        while (!isValid) {
            try {
                Scanner scanner = new Scanner(System.in);
                input = scanner.nextLong();
                isValid = true;
            } catch (InputMismatchException e) {
                System.out.println("[!] Niepoprawna wartość");
            }
        }

        return input;
    }
}
