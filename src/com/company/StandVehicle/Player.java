package com.company.StandVehicle;

public class Player {

    public String name;
    public Double cash;

    public Player(String name, Double cash) {
        this.name = name;
        this.cash = cash;
    }

    @Override
    public String toString() {
        return "Name: " + name  + " | Cash: " + cash ;
    }
}