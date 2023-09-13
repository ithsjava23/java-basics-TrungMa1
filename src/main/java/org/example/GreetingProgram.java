package org.example;

import java.util.Scanner;

public class GreetingProgram {

    public static void main(String[] args) {

        // Fråga om användarens namn
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello, what is your name?");
        String name = scanner.nextLine();

        // Byt ut första bokstaven till versal
        String res = name.substring(0, 1).toUpperCase() + name.substring(1);
        System.out.println("Hello, " +res+ "!");

    }
}
