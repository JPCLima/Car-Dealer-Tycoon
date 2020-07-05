package com.company.model;

public class Vehicle{

    // Parameters
    private Integer id;
    private String brand;
    private Double value;
    private Double mileage;
    private String colour;
    private String segment;

    // Parts of car that can be repair
    private String brakesCondition;
    private String dampersCondition;
    private String engineCondition;
    private String carBodyCondition;
    private String gearBoxCondition;

    // Parameter for the trucks
    private Double loadCapacity;

    // Define the state of the car: working or destroyed
    // The car can be destroyed if the PPHU Adrian will ruin the car
    private Boolean isWorking;

    // Vehicle Type
    private String vehicleType;


    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Double getMileage() {
        return mileage;
    }

    public void setMileage(Double mileage) {
        this.mileage = mileage;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getSegment() {
        return segment;
    }

    public void setSegment(String segment) {
        this.segment = segment;
    }

    public String getBrakesCondition() {
        return brakesCondition;
    }

    public void setBrakesCondition(String brakesCondition) {
        this.brakesCondition = brakesCondition;
    }

    public String getDampersCondition() {
        return dampersCondition;
    }

    public void setDampersCondition(String dampersCondition) {
        this.dampersCondition = dampersCondition;
    }

    public String getEngineCondition() {
        return engineCondition;
    }

    public void setEngineCondition(String engineCondition) {
        this.engineCondition = engineCondition;
    }

    public String getCarBodyCondition() {
        return carBodyCondition;
    }

    public void setCarBodyCondition(String carBodyCondition) {
        this.carBodyCondition = carBodyCondition;
    }

    public String getGearBoxCondition() {
        return gearBoxCondition;
    }

    public void setGearBoxCondition(String gearBoxCondition) {
        this.gearBoxCondition = gearBoxCondition;
    }

    public Double getLoadCapacity() {
        return loadCapacity;
    }

    public void setLoadCapacity(Double loadCapacity) {
        this.loadCapacity = loadCapacity;
    }

    public Boolean getWorking() {
        return isWorking;
    }

    public void setWorking(Boolean working) {
        isWorking = working;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    @Override
    public String toString() {
        return "Brand: " + brand + " | Value: " + value;
    }
}
