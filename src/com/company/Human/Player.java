package com.company.Human;

import com.company.StandVehicle.Car;

import java.util.ArrayList;

public class Player extends Human {

    // Create an array list to store the cars from th player
    private ArrayList<Car> garage =  new ArrayList<Car>();

    // Constructor of the Player using the super
    public Player(String name, String cash) {
        super(name, cash);
    }

    // Add a car to the Garage
    public void addCarToGarage(Car car){
        garage.add(car);
    }

    // Print the list of cars
    public void printGarageList(){
        System.out.println("You have " + garage.size() + " cars in you garage");
        for (int i = 0; i < garage.size(); i++) {
            System.out.println((i+1) + ". " + garage.get(i));
        }
    }

    // Remove Car from garage by the position
    public void removeCarFromGarage(Car car){
        garage.remove(car);
    }

    // Check if the car is in the garage
    public boolean isInGarage(Car car){
        return garage.contains(car);
    }

    @Override
    public String toString() {
        return "Name: " + name  + " | Cash: " + cash ;
    }
}
