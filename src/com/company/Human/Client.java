package com.company.Human;

public class Client extends Human{

    // Parameters for the Client
    public String interestVehicleType;
    public String interestSegment;
    public String interestCarState;

    public Client(String name, String cash, String interestVehicleType, String interestSegment, String interestCarState) {
        super(name, cash);
        this.interestVehicleType = interestVehicleType;
        this.interestSegment = interestSegment;
        this.interestCarState = interestCarState;
    }
}
