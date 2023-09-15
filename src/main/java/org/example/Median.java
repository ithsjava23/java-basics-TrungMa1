package org.example;

import java.util.Scanner;

public class Median {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ange det första talet: ");
        int num1 = scanner.nextInt();

        System.out.print("Ange det andra talet: ");
        int num2 = scanner.nextInt();

        double average = (num1 + num2) / 2.0;

        System.out.println("Medelvärdet är: " + average);
    }
}
