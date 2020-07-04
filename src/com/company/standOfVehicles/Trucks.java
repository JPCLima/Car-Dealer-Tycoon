package com.company.standOfVehicles;

public class Trucks extends Vehicle {

    // Extra parameter for Trucks
    public Double loadCapacity;

    // Constructor
    public Trucks(Double value, String brand, Double mileage, String colour, String segment, String brakesCondition, String dampersCondition, String engineCondition, String carBodyCondition, String gearBoxCondition, Double loadCapacity) {
        super(value, brand, mileage, colour, segment, brakesCondition, dampersCondition, engineCondition, carBodyCondition, gearBoxCondition);
        this.loadCapacity = loadCapacity;
    }
}
