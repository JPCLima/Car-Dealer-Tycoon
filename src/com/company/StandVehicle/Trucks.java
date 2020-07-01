package com.company.StandVehicle;

public class Trucks extends Vehicle {

    // Extra parameter for Trucks
    public Double loadCapacity;

    // Constructor
    public Trucks(Double value, String brand, Double mileage, String colour, String segment, Boolean brakesPerCent, Boolean dampersPerCent, Boolean enginePerCent, Boolean carBodyPerCent, Boolean gearBoxPerCent, Double loadCapacity) {
        super(value, brand, mileage, colour, segment, brakesPerCent, dampersPerCent, enginePerCent, carBodyPerCent, gearBoxPerCent);
        this.loadCapacity = loadCapacity;
    }
}