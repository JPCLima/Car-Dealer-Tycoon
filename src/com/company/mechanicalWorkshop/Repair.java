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
        Double cost;
        switch (vehicle.getSegment()) {
            case "premium":
                cost = 250.0;
                // Pay to fix
                player.setCash(player.getCash() - cost);
                // Accumulate the value in the vehicleCost
                vehicle.setVehicleRepairCost(vehicle.getVehicleRepairCost() + cost);
                break;
            case "standard":
                cost = 175.0;
                // Pay to fix
                player.setCash(player.getCash() - cost);
                // Accumulate the value in the vehicleCost
                vehicle.setVehicleRepairCost(vehicle.getVehicleRepairCost() + cost);
                break;
            case "budget":
                cost = 100.0;
                // Pay to fix
                player.setCash(player.getCash() - cost);
                // Accumulate the value in the vehicleCost
                vehicle.setVehicleRepairCost(vehicle.getVehicleRepairCost() + cost);
                break;
            default:
                System.out.println("That segment of the vehicle is not in our list");
                break;
        }
    }

    private void costElement(Player player, Vehicle vehicle,  Double cost){
        // The player need to pay the amount
        player.setCash(player.getCash() - cost);
        // Add that amount to the setVehicleRepairCost
        vehicle.setVehicleRepairCost(vehicle.getVehicleRepairCost() + cost);
    }

    // Brakes
    private void costBrakes(Player player, Vehicle vehicle){
        costElement(player, vehicle, 50.0);
    }

    // Dampers
    private void costDampers(Player player, Vehicle vehicle){
        costElement(player, vehicle,100.0);
    }

    // Engine
    private void costEngine(Player player, Vehicle vehicle){
        costElement(player, vehicle,1000.0);
    }

    // Car body
    private void costCarBody(Player player, Vehicle vehicle){
        costElement(player, vehicle,500.0);
    }

    // Gearbox
    private void costGearbox (Player player,Vehicle vehicle){
        costElement(player, vehicle, 800.0);
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
                    costBrakes(player, vehicle);
                    // Pay tax according with the segment
                    costSegment(player, vehicle);
                    break;
                case "dampers":
                    // Repair the Damper
                    repairDampers(vehicle);
                    // Pay for the repair
                    costDampers(player, vehicle);
                    // Pay tax according with the segment
                    costSegment(player, vehicle);

                    break;
                case "engine":
                    // Repair the Engine
                    repairEngine(vehicle);
                    // Pay for repair
                    costEngine(player, vehicle);
                    // Pay tax according with the segment
                    costSegment(player, vehicle);

                    break;
                case "car body":
                    // Repair the Car Body
                    repairCarBody(vehicle);
                    // Pay for repair
                    costCarBody(player, vehicle);
                    // Pay tax according with the segment
                    costSegment(player, vehicle);

                    break;
                case "gear box":
                    // Repair the Gear Box
                    repairGearbox(vehicle);
                    // Pay for repair
                    costGearbox(player, vehicle);
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
