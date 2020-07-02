package com.company.Human;

public class Client extends Human{

    // Parameters for the Client
    public Integer id;
    public String interestVehicleType;
    public String interestSegment;
    public String interestCarState;

    public Client(String name, Double cash, Integer id, String interestVehicleType, String interestSegment, String interestCarState) {
        super(name, cash);
        this.id = id;
        this.interestVehicleType = interestVehicleType;
        this.interestSegment = interestSegment;
        this.interestCarState = interestCarState;
    }

    @Override
    public String toString() {
        return "   " + this.id + ". " + this.name;
    }
}
