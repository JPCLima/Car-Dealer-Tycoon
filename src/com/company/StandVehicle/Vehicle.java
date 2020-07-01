package com.company.StandVehicle;

public abstract class Vehicle {

    // Parameters
    public Double value;
    public String brand;
    public Double mileage;
    public String colour;
    public String segment;

    // Parts of car that can be repair
    public Boolean brakesIsOk;
    public Boolean dampersIsOk;
    public Boolean engineIsOk;
    public Boolean carBodyIsOk;
    public Boolean gearBoxIsOk;

    // Define the state of the car: working or destroyed
    // The car can be destroyed if the PPHU Adrian will ruin the car
    public Boolean isWorking;

    // Constructor of vehicle
    public Vehicle(Double value, String brand, Double mileage, String colour, String segment, Boolean brakesIsOk, Boolean dampersIsOk, Boolean engineIsOk, Boolean carBodyIsOk, Boolean gearBoxIsOk) {
        this.value = value;
        this.brand = brand;
        this.mileage = mileage;
        this.colour = colour;
        this.segment = segment;
        this.brakesIsOk = brakesIsOk;
        this.dampersIsOk = dampersIsOk;
        this.engineIsOk = engineIsOk;
        this.carBodyIsOk = carBodyIsOk;
        this.gearBoxIsOk = gearBoxIsOk;
        // All car created are working
        this.isWorking = true;
    }

    @Override
    public String toString() {
        return "Brand: " + brand + " | Value: " + value;
    }

}
