package org.example;
import java.text.DecimalFormat;
import java.util.Locale;
import java.util.Scanner;

public class Test {
    private static final DecimalFormat df = new DecimalFormat("##");
    public static void main(String[] args) {
        Locale swedishLocale = Locale.of("sv", "SE");
        Locale.setDefault(swedishLocale);
        Scanner input = new Scanner(System.in);
        boolean running = true;
        int[] prices = new int[24];

        while (running) {
            System.out.println("Elpriser");
            System.out.println("========");
            System.out.println("1. Inmatning");
            System.out.println("2. Min, Max och Medel");
            System.out.println("3. Sortera");
            System.out.println("4. Bästa Laddningstid (4h)");
            System.out.println("e. Avsluta");
            System.out.print("Välj ett alternativ: ");

            String choice = input.next();

            switch (choice.toLowerCase()) {
                case "1" -> inputPrices(prices, input);
                case "2" -> printMinAndMaxPrices(prices);
                case "3" -> sorting(prices);
                case "4" -> findBestChargingTime(prices);
                case "e" -> {
                    System.out.println("Programmet avslutas.");
                    running = false;
                }
                default -> System.out.println("Ogiltigt val. Försök igen.");
            }
        }

        //input.close();
    }

    public static void inputPrices(int[] prices, Scanner input) {
        System.out.println("Ange elpriser för dygnet (i öre per kW/h):");

        for (int hour = 0; hour < prices.length; hour++) {
            System.out.print(tim(hour) + "-" + tim(hour + 1) + ": ");
            prices[hour] = input.nextInt();
        }

        System.out.println("Elpriser har matats in för dygnet.");
    }

    public static void printMinAndMaxPrices(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxPrice = Integer.MIN_VALUE;
        int minHour = -1;
        int maxHour = -1;
        int sum = 0;

        for (int hour = 0; hour < prices.length; hour++) {
            int price = prices[hour];
            sum += price;

            if (price < minPrice) {
                minPrice = price;
                minHour = hour;
            }

            if (price > maxPrice) {
                maxPrice = price;
                maxHour = hour;
            }
        }

        double averagePrice = (double) sum / prices.length;

        System.out.println("Lägsta pris: " + tim(minHour) + "-" + tim(minHour + 1) + ", " + minPrice + " öre/kWh");
        System.out.println("Högsta pris: " + tim(maxHour) + "-" + tim(maxHour + 1) + ", " + maxPrice + " öre/kWh");
        System.out.println("Medelpris: " + String.format("%.2f", averagePrice) + " öre/kWh");
    }

    public static void sorting(int[] prices) {
        float[] pricePerHour = new float[24];
        int[] time = new int[24];

        for (int i = 0; i < 24; i++) {
            pricePerHour[i]=prices[i];
            time[i] = i;
        }

        boolean sorted = false;
        while (!sorted) {

            sorted = true;
            for (int i = 0; i < 23; i++) {
                float t1 = pricePerHour[i];
                float t2 = pricePerHour[i + 1];

                int k1 = time[i];
                int k2 = time[i + 1];

                if (t1 < t2) {
                    pricePerHour[i] = t2;
                    pricePerHour[i + 1] = t1;

                    time[i] = k2;
                    time[i + 1] = k1;

                    sorted = false;

                }

            }

        }

        System.out.println();
        for (int i = 0; i < 24; i++) {
            int hour = time[i];
            int nextHour = time[i] + 1;
            String formattedPrice = df.format(pricePerHour[i]);
            System.out.println(tim(hour) + "-" + tim(nextHour) + " " + formattedPrice + " öre");



        }
    }
    public static void findBestChargingTime(int[] prices) {
        int lowestTotalPrice = Integer.MAX_VALUE;
        int bestStartTime = -1;

        for (int startTime = 0; startTime < 21; startTime++) {
            int totalPrice = 0;
            for (int i = startTime; i < startTime + 4; i++) {
                totalPrice += prices[i];
            }
            if (totalPrice < lowestTotalPrice) {
                lowestTotalPrice = totalPrice;
                bestStartTime = startTime;
            }
        }

        double averageValue = (double) lowestTotalPrice / 4;

        System.out.printf(String.format("Påbörja laddning klockan %02d\n", bestStartTime, + 3));
        System.out.printf(String.format("Medelpris 4h: %.1f öre/kWh\n",averageValue));
    }

    static String tim(int timme) {
        String tid;
        if (timme < 10) {
            tid = "0" + timme;
        } else {
            tid = "" + timme;
        }
        return tid;
    }
}