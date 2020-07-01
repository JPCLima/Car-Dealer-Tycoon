package com.company.StandVehicle;

public abstract class Vehicle {

    // Parameters
    public Double value;
    public String brand;
    public Double mileage;
    public String colour;
    public String segment;

    // Parts of car that can be repair
    public Double brakesPerCent;
    public Double dampersPerCent;
    public Double enginePerCent;
    public Double carBodyPerCent;
    public Double gearBoxPerCent;

    // Constructor of vehicle
    public Vehicle(Double value, String brand, Double mileage, String colour, String segment, Double brakesPerCent, Double dampersPerCent, Double enginePerCent, Double carBodyPerCent, Double gearBoxPerCent) {
        this.value = value;
        this.brand = brand;
        this.mileage = mileage;
        this.colour = colour;
        this.segment = segment;
        this.brakesPerCent = brakesPerCent;
        this.dampersPerCent = dampersPerCent;
        this.enginePerCent = enginePerCent;
        this.carBodyPerCent = carBodyPerCent;
        this.gearBoxPerCent = gearBoxPerCent;
    }
}
