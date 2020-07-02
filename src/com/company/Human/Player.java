package com.company.Human;

import com.company.StandVehicle.Car;
import com.company.StandVehicle.Vehicle;

import java.util.ArrayList;

public class Player extends Human {

    // Create an array list to store the cars from th player
    private ArrayList<Vehicle> garage = new ArrayList<>();

    // Constructor of the Player using the super
    public Player(String name, Double cash) {
        super(name, cash);
    }

    // Add a car to the Garage
    public void addVehicleToGarage(Vehicle vehicle){
        garage.add(vehicle);
    }

    // Print the list of cars
    public void printGarageList(){
        System.out.println("You have " + garage.size() + " cars in you garage");
        for (int i = 0; i < garage.size(); i++) {
            System.out.println((i+1) + ". " + garage.get(i));
        }
    }

    // Remove Car from garage by the position
    public void removeVehicleFromGarage(Vehicle vehicle){
        garage.remove(vehicle);
    }

    // Check if the car is in the garage
    public boolean isInGarage(Car car){
        return garage.contains(car);
    }

    // Method to buy a vehicle
    public void buyVehicle(Vehicle vehicle, Double vehiclePrice){
        if(this.cash >= vehiclePrice){
            // Pay tax to clean the car
            this.payTaxCleaning(vehiclePrice);
            // The change money to the player
            this.cash -= vehiclePrice;
            // Add the car to the garage
            this.addVehicleToGarage(vehicle);
            System.out.println("Congratulations, you have a new vehicle in you garage");
        }else{
            System.out.println("You don't have enough money to buy this vehicle");
        }
    }

    // Method to sell the car
    public void sellVehicle(Vehicle vehicle, Double vehiclePrice){
        // Pay tax to clean the car
        this.payTaxCleaning(vehiclePrice);
        // Add money to the cash of player
        this.cash += vehiclePrice;
        // Remove the car from the garage
        this.removeVehicleFromGarage(vehicle);
        System.out.println("Your vehicle has been sold");
    }

    private void payTaxCleaning(Double vehiclePrice) {
        this.cash -= (vehiclePrice * 0.02);
    }

    @Override
    public String toString() {
        return "Name: " + name  + " | Cash: " + cash ;
    }
}
