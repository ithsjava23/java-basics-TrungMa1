package org.example;

import java.util.Arrays;
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
                case "1" -> inputPrice(prices, scanner);
                case "2" -> MinMaxAverage(prices);
                case "3" -> Sort(prices);
                case "4" -> BestChargingTime(prices);
                case "e" -> { System.out.println("Programmet avslutas");
                    scanner.close();
                    System.exit(0); }
                default -> System.out.println("Alternativet " + choice + " finns inte i menyn");
            }
        }
        while (true);
    }
    public static void inputPrice( int[] prices, Scanner scanner ) {
        System.out.println("Ange elpriser för dygnet (öre per kW/h): ");

        for (int hour = 0; hour < 24; hour++) {
            System.out.print((hour) + "-" + (hour + 1) + ": ");
            prices[hour] = scanner.nextInt();
            scanner.nextLine();
        }
        System.out.println("Tack för de inmatade elpriserna");
    }
    public static void MinMaxAverage(int[] prices) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int minHour = -1;
        int maxHour = -1;
        int sum = 0;

        for (int hour = 0; hour < 24; hour++) {
            int price = prices[hour];
            if (price < min) {
                min = price;
                minHour = hour;
            }

            if (price > max) {
                max = price;
                maxHour = hour;
            }
            sum += price;
        }
        float average = (float) sum / prices.length;

        System.out.printf("Lägsta pris: %02d-%02d, %d öre/kWh\n", minHour, minHour + 1, min);
        System.out.printf("Högsta pris: %02d-%02d, %d öre/kWh\n", maxHour, maxHour + 1, max);
        System.out.printf("Medelpris: %.2f öre/kWh\n", average);
    }
    public static void Sort(int[] prices) {
        int[] sortedPrices = Arrays.copyOf(prices, 24);
        Arrays.sort(sortedPrices);

        int hour;
        for (hour = 0; hour < 24; hour++) {
            System.out.printf("%02d-%02d %d öre%n", hour, hour + 1, sortedPrices[hour]);
        }
    }
    public static void BestChargingTime(int[] prices) {
        int lowestPrice = Integer.MAX_VALUE;
        int bestStartTime = -1;

        for (int startTime = 0; startTime < 21; startTime++) {
            int totalPrice = 0;
            for (int i = startTime; i < startTime + 4; i++) {
                totalPrice += prices[i];
            }
            if (totalPrice < lowestPrice) {
                lowestPrice = totalPrice;
                bestStartTime = startTime;
            }
        }
        float averageValue = (float) lowestPrice / 4;

        System.out.printf("Påbörja laddningen klockan: %02d%n", bestStartTime, + 3);
        System.out.printf("Medelpris 4h: %.1f öre/kWh%n", averageValue);
    }
}
