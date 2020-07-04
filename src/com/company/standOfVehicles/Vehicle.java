package com.company.standOfVehicles;

public abstract class Vehicle{

    // Parameters
    public Double value;
    public String brand;
    public Double mileage;
    public String colour;
    public String segment;

    // Parts of car that can be repair
    public String brakesCondition;
    public String dampersCondition;
    public String engineCondition;
    public String carBodyCondition;
    public String gearBoxCondition;

    // Define the state of the car: working or destroyed
    // The car can be destroyed if the PPHU Adrian will ruin the car
    public Boolean isWorking;

    // Constructor of vehicle
    public Vehicle(Double value, String brand, Double mileage, String colour, String segment, String brakesCondition, String dampersCondition, String engineCondition, String carBodyCondition, String gearBoxCondition) {
        this.value = value;
        this.brand = brand;
        this.mileage = mileage;
        this.colour = colour;
        this.segment = segment;
        this.brakesCondition = brakesCondition;
        this.dampersCondition = dampersCondition;
        this.engineCondition = engineCondition;
        this.carBodyCondition = carBodyCondition;
        this.gearBoxCondition = gearBoxCondition;
        // All car created are working
        this.isWorking = true;
    }

    @Override
    public String toString() {
        return "Brand: " + brand + " | Value: " + value;
    }

}
