package org.example;

import java.util.Locale;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Locale swedishLocale = new Locale("sv", "SE");
        Locale.setDefault(swedishLocale);
        int[] prices = new int[24];

        do {
            System.out.println("\nElpriser");
            System.out.println("========");
            System.out.println("1. Inmatning");
            System.out.println("2. Min, Max och Medel");
            System.out.println("3. Sortera");
            System.out.println("4. Bästa Laddningstid (4h)");
            System.out.println("e. Avsluta");
            System.out.println("Välj ett av alternativen: ");

            String choice = scanner.nextLine();
            choice = choice.toLowerCase();

            switch (choice) {
                case "1":
                    inputPrice(prices, scanner);
                    break;
                case "2":
                    MinMaxAverage(prices);
                    break;
                case "3":
                    System.out.println(" ");
                    break;
                case "4":
                    System.out.println(" ");
                    break;
                case "e":
                    System.out.println("Programmet avslutas");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Alternativet " + choice + " finns inte i menyn");
                    break;
            }
        }
        while (true);
    }
    public static void inputPrice( int[] prices, Scanner scanner ) {
        System.out.println("Ange elpriser för dygnet (öre per kW/h): ");

        for (int hour = 0; hour < prices.length; hour++) {
            System.out.print((hour) + "-" + (hour + 1) + ": ");
            prices[hour] = scanner.nextInt();
        }
        System.out.println("Tack för de inmatade elpriserna");
    }
    public static void MinMaxAverage(int[] prices) {
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;


    }
}
