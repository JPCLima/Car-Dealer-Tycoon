package com.company.MechanicalWorkshop;

import com.company.Player;
import com.company.StandVehicle.Car;

import java.util.concurrent.ThreadLocalRandom;

public class MechanicalWorkshop extends Repair {

    // Get changes to succeed or fail the repair the part of the Vehicle
    private int generateRandomNumber(Integer min, Integer max){
        int randomNum = ThreadLocalRandom.current().nextInt(min, max + 1);
        return randomNum;
    }

    //Mechanical Workshops:

    // JanuszCars
    public void JanuszCars(Player player, Car car, String partToRepair){
        // Check if car is in the garage of the player and if the car is working
        if(player.isInGarage(car) && car.isWorking) {
            choosePartToRepair(player, car, partToRepair);
        } else {
            System.out.println("This is destroyed doesn't belong to you");
        }
    }

    // MarianAuto
    public void MarianAuto(Player player, Car car, String partToRepair){
        // Check if car is in the garage of the player and if the car is working
        if(player.isInGarage(car) && car.isWorking){
            // Generate a random number between 1 and 100
            // This number will decide the change for the repair be successful or fail
            int randomNumber = generateRandomNumber(0, 99);
            if(randomNumber >= 11){
                choosePartToRepair(player, car, partToRepair);
                System.out.println("Probability: " + randomNumber);
            } else {
                System.out.println("MarianAuto Fail the repair of you Vehicle");
            }
        } else {
            System.out.println("This is destroyed doesn't belong to you");
        }
    }

    // PPHUAdrian
    public void PPHUAdrian(Player player, Car car, String partToRepair){
        // Check if car is in the garage of the player and if the car is working
        if(player.isInGarage(car) && car.isWorking){
        // Generate a random number between 1 and 100
        // This number will decide the change for the repair be successful or fail
        int randomNumber = generateRandomNumber(0, 99);

        // If repair successfully if the number is grater or equal then 20
        if(randomNumber > 22){
            choosePartToRepair(player, car, partToRepair);
            System.out.println("Probability: " + randomNumber);

            // If mechanic ruin the car repair successfully if the number less then 2
        } else if (randomNumber < 2){
            System.out.println("Now you car is destroyed");
            System.out.println("Probability: " + randomNumber);
            // Change the status of the car to false, means that cannot be used again
            car.isWorking = false;
            // Remove from the garage
            player.removeCarFromGarage(car);

            // If the mechanic fail the repair of the car  if the number is between the interval [2, 22]
        }else {
            System.out.println("MarianAuto Fail the repair of you Vehicle");
            System.out.println("Probability: " + randomNumber);
        }
    }else{
            System.out.println("This is destroyed doesn't belong to you");
        }
    }
}
