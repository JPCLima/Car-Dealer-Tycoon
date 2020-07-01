package com.company.MechanicalWorkshop;

import com.company.Player;
import com.company.StandVehicle.Car;

public class Repair {

    // Repair part of the car method
    private static void repairPart(Car car, Integer perCentValue){
        car.value = car.value + (car.value*0.2);
    }

    // Increase the car’s value 10% - Brakes
    private void repairBrakes(Car car) {
        repairPart(car, 10);
    }

    // Increase the car’s value 20% - Dampers
    private void repairDampers(Car car) {
        repairPart(car, 20);
    }

    // Increase the car’s value 100% - Engine
    private void repairEngine(Car car) {
        repairPart(car, 20);
    }

    // Increase the car’s value 50% - Car Body
    private void repairCarBody(Car car) {
        repairPart(car, 50);
    }

    // Increase the car’s value 50% - Gearbox
    private void repairGearbox(Car car) {
        repairPart(car, 50);
    }

    // Cost of repair
    // Cost of elements to repair
    private Double costElement(Player player, Double cost){
        player.cash -= cost;
        return player.cash;
    }

    // Brakes
    private double costBrakes(Player player){
        return costElement(player, 50.0);
    }

    // Dampers
    private double costDampers(Player player){
        return costElement(player, 100.0);
    }

    // Engine
    private double costEngine(Player player){
        return costElement(player, 1000.0);
    }

    // Car body
    private double costCarBody(Player player){
        return costElement(player, 500.0);
    }

    // Gearbox
    private double costGearbox (Player player){
        return costElement(player, 800.0);
    }

    // This method is choosing which part of the Vehicle is to repair and change the player for the work
    void choosePartToRepair(Player player, Car car, String partToRepair){
        // Check if the car is working otherwise is not possible to fix the vehicle
        if (car.isWorking) {
            if (partToRepair.equals("brakes")) {
                // Repair the Brakes
                repairBrakes(car);
                // Pay for the repair
                costBrakes(player);

            } else if (partToRepair.equals("dampers")) {
                // Repair the Damper
                repairDampers(car);
                // Pay for the repair
                costDampers(player);

            } else if (partToRepair.equals("engine")) {
                // Repair the Engine
                repairEngine(car);
                // Pay for repair
                costEngine(player);

            } else if (partToRepair.equals("car body")) {
                // Repair the Car Body
                repairCarBody(car);
                // Pay for repair
                costCarBody(player);

            } else if (partToRepair.equals("gear box")) {
                // Repair the Gear Box
                repairGearbox(car);
                // Pay for repair
                costGearbox(player);

            } else {
                System.out.println("We cannot fix that component of the car in our workshop");
            }
        } else {
            System.out.println("This Vehicle is already destroyed cannot be fixed...");
        }
    }

}
