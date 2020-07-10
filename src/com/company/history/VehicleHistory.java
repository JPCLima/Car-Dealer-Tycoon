package com.company.history;

import com.company.model.Vehicle;

public class VehicleHistory {

    public Vehicle vehicle;
    public Double amount;

    // Constructor
    public VehicleHistory(Vehicle vehicle, Double amount) {
        this.vehicle = vehicle;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "    Vehicle: " + vehicle + "    | Amount: " + amount;
    }
}
