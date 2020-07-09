package com.company.model;

public class Client{

    private Integer id;
    private String name;
    private Double cash;

    // Parameters for the Client
    private String interestVehicleType;
    private String interestSegment;
    private String interestCarState;

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getCash() {
        return cash;
    }

    public void setCash(Double cash) {
        this.cash = cash;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getInterestVehicleType() {
        return interestVehicleType;
    }

    public void setInterestVehicleType(String interestVehicleType) {
        this.interestVehicleType = interestVehicleType;
    }

    public String getInterestSegment() {
        return interestSegment;
    }

    public void setInterestSegment(String interestSegment) {
        this.interestSegment = interestSegment;
    }

    public String getInterestCarState() {
        return interestCarState;
    }

    public void setInterestCarState(String interestCarState) {
        this.interestCarState = interestCarState;
    }

    @Override
    public String toString() {
        return "    " +  this.name + "    |     " + this.interestVehicleType + "    |     " +  this.interestSegment + "    |     " + interestCarState;
    }
}
