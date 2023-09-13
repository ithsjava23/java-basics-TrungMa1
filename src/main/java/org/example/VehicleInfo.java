package org.example;

public class VehicleInfo {
    private static final int MAX_PASSENGERS = 1000;

    private final int passengers;
    private final float fuelCap;
    private final float fuelUsage;

    public VehicleInfo(int passengers, float fuelCap, float fuelUsage) {
        this.passengers = passengers;
        this.fuelCap = fuelCap;
        this.fuelUsage = fuelUsage;
    }
    public int getPassengers() {
        return passengers;
    }
    public float getFuelCap() {
        return fuelCap;
    }
    public float getFuelUsage() {
        return fuelUsage;
    }
    public float getMaxRange() {
        return fuelCap / fuelUsage;
    }
}
