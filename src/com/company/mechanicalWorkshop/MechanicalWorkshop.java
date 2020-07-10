package com.company.mechanicalWorkshop;
import com.company.human.Player;
import com.company.model.Vehicle;

import java.util.concurrent.ThreadLocalRandom;

public class MechanicalWorkshop extends Repair {

    // Get changes to succeed or fail the repair the part of the Vehicle
    private int generateRandomNumber(Integer min, Integer max){
        int randomNum = ThreadLocalRandom.current().nextInt(min, max + 1);
        return randomNum;
    }

    //Mechanical Workshops:

    // JanuszCars
    public void JanuszCars(Player player, Vehicle vehicle, Integer partToRepair){

        // Check if car is in the garage of the player and if the car is working
        if(player.isInGarage(vehicle) && vehicle.getVehicleState().equals("working")) {
            // Fix the component
            choosePartToRepair(player, vehicle, clientChoosePartToRepair(partToRepair));

            // Check the components state of the vehicle
            System.out.println(vehicle.componentsState());
            System.out.println("    Your " + clientChoosePartToRepair(partToRepair) + " has been fixed" );
        } else {
            System.out.println("    Your vehicle is destroyed you cannot use it");
        }
    }

    // MarianAuto
    public void MarianAuto(Player player, Vehicle vehicle, Integer partToRepair){

        // Check if car is in the garage of the player and if the car is working
        if(player.isInGarage(vehicle) && vehicle.getVehicleState().equals("working")){
            // Generate a random number between 1 and 100
            // This number will decide the change for the repair be successful or fail
            int randomNumber = generateRandomNumber(0, 99);
            if(randomNumber >= 11){
                // Fix the component
                choosePartToRepair(player, vehicle, clientChoosePartToRepair(partToRepair));

                // Check the components state of the vehicle
                System.out.println(vehicle.componentsState());
                System.out.println("    Your " + clientChoosePartToRepair(partToRepair) + " has been fixed" );
            } else {
                System.out.println("    MarianAuto Fail the repair of you Vehicle");
            }
        } else {
            System.out.println("    This is destroyed doesn't belong to you");
        }
    }

    // PPHUAdrian
    public void PPHUAdrian(Player player, Vehicle vehicle, Integer partToRepair){

        // Check if car is in the garage of the player and if the car is working
        if(player.isInGarage(vehicle) && vehicle.getVehicleState().equals("working")){
        // Generate a random number between 1 and 100
        // This number will decide the change for the repair be successful or fail
        int randomNumber = generateRandomNumber(0, 99);

        // If repair successfully if the number is grater or equal then 20
        if(randomNumber > 22){
            // Fix the component
            choosePartToRepair(player, vehicle, clientChoosePartToRepair(partToRepair));

            // Check the components state of the vehicle
            System.out.println(vehicle.componentsState());
            System.out.println("    Your " + clientChoosePartToRepair(partToRepair) + " has been fixed" );

            // If mechanic ruin the car repair successfully if the number less then 2
        } else if (randomNumber < 2){
            System.out.println("Now you car is destroyed");
            System.out.println("Probability: " + randomNumber);
            // Change the status of the car to false, means that cannot be used again
            vehicle.setVehicleState("not working");
            // Remove from the garage
            player.removeVehicleFromGarage(vehicle);

            // If the mechanic fail the repair of the car  if the number is between the interval [2, 22]
        }else {
            System.out.println("MarianAuto Fail the repair of you Vehicle");
        }
    }else{
            System.out.println("This is destroyed doesn't belong to you");
        }
    }

    private String clientChoosePartToRepair(Integer partToRepair) {
        String chosenPart = null;
        switch (partToRepair){
            case 1:
                // 1 - Brakes
                chosenPart = "brakes";
                break;
            case 2:
                // 2 - Dampers
                chosenPart = "dampers";
                break;
            case 3:
                // 3 - Engine
                chosenPart = "engine";
                break;
            case 4:
                // 4 - Car body
                chosenPart = "car body";
                break;
            case 5:
                // 5 - Gear box
                chosenPart = "gear box";
                break;
        }
        return chosenPart;
    }

}
