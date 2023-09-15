package org.example;

public class Vehicles {
    public static void main(String[] args) {
        VehicleInfo Car = new VehicleInfo(5,50,0.6f);
        VehicleInfo Bus = new VehicleInfo(50,150,2.4f);

        System.out.println("The car can take " + Car.getPassengers() + " passengers.");
        System.out.println("And go " + Car.getMaxRange() + " mil.");
        System.out.println("The bus can take " + Bus.getPassengers() + " passengers.");
        System.out.println("And go " + Bus.getMaxRange() + " mil.");

        System.out.printf("The car can take %d passengers. \n", Car.getPassengers());
        System.out.printf("And go %.2f mil. \n", Car.getMaxRange());
        System.out.printf("The bus can take %d passengers. \n", Bus.getPassengers());
        System.out.printf("And go %.2f mil. \n", Bus.getMaxRange());



    }
}
