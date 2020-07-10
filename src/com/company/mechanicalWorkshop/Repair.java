package com.company.mechanicalWorkshop;

import com.company.human.Player;
import com.company.model.Vehicle;

public class Repair {

    // Repair part of the car method
    private static void repairPart(Vehicle vehicle, Double perCentValue){
        vehicle.setValue(vehicle.getValue() + (vehicle.getValue()*perCentValue));
    }

    // Increase the car’s value 10% - Brakes
    private void repairBrakes(Vehicle vehicle) {
        if(vehicle.getBrakesCondition().equals("bad")){
            repairPart(vehicle, 0.10);
            vehicle.setBrakesCondition("good");
        } else {
            System.out.println("Your brakes are in good conditions doesn't need to be fixed.");
        }
    }

    // Increase the car’s value 20% - Dampers
    private void repairDampers(Vehicle vehicle) {
        if(vehicle.getDampersCondition().equals("bad")) {
            repairPart(vehicle, 0.20);
            vehicle.setDampersCondition("good");
        }else{
            System.out.println("Your dampers are in good conditions doesn't need to be fixed.");
        }
    }

    // Increase the car’s value 100% - Engine
    private void repairEngine(Vehicle vehicle) {
        if(vehicle.getEngineCondition().equals("bad")) {
            repairPart(vehicle, 0.20);
            vehicle.setEngineCondition("good");
        }else{
            System.out.println("Your engine are in good conditions doesn't need to be fixed.");
        }
    }

    // Increase the car’s value 50% - Car Body
    private void repairCarBody(Vehicle vehicle) {
        if(vehicle.getCarBodyCondition().equals("bad")) {
        repairPart(vehicle, 0.50);
        vehicle.setCarBodyCondition("good");
    }else {
            System.out.println("Your car body are in good conditions doesn't need to be fixed.");
        }
    }

    // Increase the car’s value 50% - Gearbox
    private void repairGearbox(Vehicle vehicle) {
        if(vehicle.getCarBodyCondition().equals("bad")) {
            repairPart(vehicle, 0.50);
            vehicle.setGearBoxCondition("bad");
        }else {
            System.out.println("Your gearbox are in good conditions doesn't need to be fixed.");
        }

    }

    // Cost of repair
    // Cost of elements to repair
    private void costSegment(Player player, Vehicle vehicle){
        switch (vehicle.getSegment()) {
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
    void choosePartToRepair(Player player, Vehicle vehicle, String partToRepair){
        // Check if the car is working otherwise is not possible to fix the vehicle
        if (vehicle.getVehicleState().equals("working")) {
            switch (partToRepair) {
                case "brakes":
                    // Repair the Brakes
                    repairBrakes(vehicle);
                    // Pay for the repair
                    costBrakes(player);
                    // Pay tax according with the segment
                    costSegment(player, vehicle);

                    break;
                case "dampers":
                    // Repair the Damper
                    repairDampers(vehicle);
                    // Pay for the repair
                    costDampers(player);
                    // Pay tax according with the segment
                    costSegment(player, vehicle);

                    break;
                case "engine":
                    // Repair the Engine
                    repairEngine(vehicle);
                    // Pay for repair
                    costEngine(player);
                    // Pay tax according with the segment
                    costSegment(player, vehicle);

                    break;
                case "car body":
                    // Repair the Car Body
                    repairCarBody(vehicle);
                    // Pay for repair
                    costCarBody(player);
                    // Pay tax according with the segment
                    costSegment(player, vehicle);

                    break;
                case "gear box":
                    // Repair the Gear Box
                    repairGearbox(vehicle);
                    // Pay for repair
                    costGearbox(player);
                    // Pay tax according with the segment
                    costSegment(player, vehicle);

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
