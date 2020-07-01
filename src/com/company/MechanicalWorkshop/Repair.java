package com.company.MechanicalWorkshop;

import com.company.Player;
import com.company.StandVehicle.Car;

public class Repair {

    // Repair part of the car method
    private static void repairPart(Car car, Double perCentValue){
        car.value = car.value + (car.value*perCentValue);
    }

    // Increase the car’s value 10% - Brakes
    private void repairBrakes(Car car) {
        repairPart(car, 0.10);
    }

    // Increase the car’s value 20% - Dampers
    private void repairDampers(Car car) {
        repairPart(car, 0.20);
    }

    // Increase the car’s value 100% - Engine
    private void repairEngine(Car car) {
        repairPart(car, 0.20);
    }

    // Increase the car’s value 50% - Car Body
    private void repairCarBody(Car car) {
        repairPart(car, 0.50);
    }

    // Increase the car’s value 50% - Gearbox
    private void repairGearbox(Car car) {
        repairPart(car, 0.50);
    }

    // Cost of repair
    // Cost of elements to repair
    private void costSegment(Player player, Car car){
        switch (car.segment) {
            case "premium":
                player.cash -= 250;
                break;
            case "standard":
                player.cash -= 175;
                break;
            case "budget":
                player.cash -= 100;
                break;
            default:
                System.out.println("That segment of the vehicle is not in our list");
                break;
        }
    }

    private void costElement(Player player, Double cost){
        player.cash -= cost;
    }

    // Brakes
    private void costBrakes(Player player){
        costElement(player, 50.0);
    }

    // Dampers
    private void costDampers(Player player){
        costElement(player, 100.0);
    }

    // Engine
    private void costEngine(Player player){
        costElement(player, 1000.0);
    }

    // Car body
    private void costCarBody(Player player){
        costElement(player, 500.0);
    }

    // Gearbox
    private void costGearbox (Player player){
        costElement(player, 800.0);
    }

    // This method is choosing which part of the Vehicle is to repair and change the player for the work
    void choosePartToRepair(Player player, Car car, String partToRepair){
        // Check if the car is working otherwise is not possible to fix the vehicle
        if (car.isWorking) {
            switch (partToRepair) {
                case "brakes":
                    // Repair the Brakes
                    repairBrakes(car);
                    // Pay for the repair
                    costBrakes(player);
                    // Pay tax according with the segment
                    costSegment(player, car);

                    break;
                case "dampers":
                    // Repair the Damper
                    repairDampers(car);
                    // Pay for the repair
                    costDampers(player);
                    // Pay tax according with the segment
                    costSegment(player, car);

                    break;
                case "engine":
                    // Repair the Engine
                    repairEngine(car);
                    // Pay for repair
                    costEngine(player);
                    // Pay tax according with the segment
                    costSegment(player, car);

                    break;
                case "car body":
                    // Repair the Car Body
                    repairCarBody(car);
                    // Pay for repair
                    costCarBody(player);
                    // Pay tax according with the segment
                    costSegment(player, car);

                    break;
                case "gear box":
                    // Repair the Gear Box
                    repairGearbox(car);
                    // Pay for repair
                    costGearbox(player);
                    // Pay tax according with the segment
                    costSegment(player, car);

                    break;
                default:
                    System.out.println("We cannot fix that component of the car in our workshop");
                    break;
            }
        } else {
            System.out.println("This Vehicle is already destroyed cannot be fixed...");
        }
    }

}
