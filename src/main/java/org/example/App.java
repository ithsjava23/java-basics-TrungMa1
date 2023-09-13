package org.example;

import java.util.Locale;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Locale swedishLocale = new Locale("sv", "SE");
        Locale.setDefault(swedishLocale);
        int[] prices = new int[24];
        String choice ="";

        do {
            System.out.print("\nElpriser\n");
            System.out.print("========\n");
            System.out.print("1. Inmatning\n");
            System.out.print("2. Min, Max och Medel\n");
            System.out.print("3. Sortera\n");
            System.out.print("4. Bästa Laddningstid (4h)\n");
            System.out.print("e. Avsluta\n");

            choice = scanner.nextLine();
            choice = choice.toLowerCase();

            switch (choice) {
                case "1" -> inputPrice(prices, scanner);
                case "2" -> MinMaxAverage(prices);
                case "3" -> Sort(prices);
                case "4" -> BestChargingTime(prices);
                case "e" -> System.out.print("Programmet avslutas\n");
                default -> System.out.printf("Alternativet " + choice + " finns inte i menyn\n");
            }
        }
        while (!choice.equals("e"));
    }

    public static void inputPrice(int[] prices, Scanner scanner) {
        System.out.print("Ange elpriser för dygnet (öre per kW/h): \n");

        for (int hour = 0; hour < 24; hour++) {
            System.out.print((hour) + "-" + (hour + 1) + ": ");
            prices[hour] = scanner.nextInt();
            scanner.nextLine();
        }
        System.out.print("Tack för de inmatade elpriserna\n");
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

        System.out.printf("Påbörja laddning klockan %02d\n", bestStartTime, +3);
        System.out.printf("Medelpris 4h: %.1f öre/kWh\n", averageValue);
    }

    public static void Sort(int[] prices) {
        int[] hours = new int[24];
        for (int i = 0; i < 24; i++) {
            hours[i] = i;
        }
        boolean sorted = false;

        while (!sorted) {
            sorted = true;
            for (int i = 0; i < 23; i++) {
                if (prices[i] < prices[i + 1]) {

                    int tempPrice = prices[i];
                    prices[i] = prices[i + 1];
                    prices[i + 1] = tempPrice;

                    int tempHour = hours[i];
                    hours[i] = hours[i + 1];
                    hours[i + 1] = tempHour;

                    sorted = false;
                }
            }
        }
        for (int i = 0; i < 24; i++) {
            System.out.printf("%02d-%02d %d öre\n", hours[i], hours[i] + 1, prices[i]);
        }
    }
}