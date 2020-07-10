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
    private String vehicleState;

    // Vehicle Type
    private String vehicleType;

    // Vehicle costs
    private Double vehicleRepairCost;
    private Double vehicleCleaningCost;


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

    public String getVehicleState() {
        return vehicleState;
    }

    public void setVehicleState(String state) {
        vehicleState = state;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public Double getVehicleRepairCost() {
        return vehicleRepairCost;
    }

    public void setVehicleRepairCost(Double vehicleRepairCost) {
        this.vehicleRepairCost = vehicleRepairCost;
    }

    public Double getVehicleCleaningCost() {
        return vehicleCleaningCost;
    }

    public void setVehicleCleaningCost(Double vehicleCleaningCost) {
        this.vehicleCleaningCost = vehicleCleaningCost;
    }

    public String componentsState(){
        return "    Brakes: " + getBrakesCondition() + "    Dampers: " + getDampersCondition() +
               "    Engine: " + getEngineCondition() + "    Car Body: " + getCarBodyCondition() +
               "    Gearbox: " + getGearBoxCondition();

    }

    @Override
    public String toString() {
        return brand + "   |   " + vehicleType + "   |   " + vehicleState + "   |   " + segment + "   |   " + value + componentsState();
    }
}
