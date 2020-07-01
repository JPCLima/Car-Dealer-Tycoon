package com.company.MechanicalWorkshop;

import com.company.StandVehicle.Car;

import java.util.concurrent.ThreadLocalRandom;

public class MechanicalWorkshop implements Repair {

    // Get changes to succeed or fail the repair the part of the Vehicle
    private int generateRandomNumber(Integer min, Integer max){
        int randomNum = ThreadLocalRandom.current().nextInt(min, max + 1);
        return randomNum;
    }

    //Mechanical Workshops:

    // JanuszCars
    // 100% guarantee
    public void JanuszCars(Car car, String partToRepair){
        choosePartToRepair(car, partToRepair);
    }

    // MarianAuto
    public void MarianAuto(Car car, String partToRepair){
        // Generate a random number between 1 and 100
        // This number will decide the change for the repair be successful or fail
        int randomNumber = generateRandomNumber(0, 99);
        if(randomNumber >= 11){
            choosePartToRepair(car, partToRepair);
            System.out.println("Probability: " + randomNumber);
        } else {
            System.out.println("MarianAuto Fail the repair of you Vehicle");
        }
    }

    // PPHUAdrian
    public void PPHUAdrian(Car car, String partToRepair){
        // Generate a random number between 1 and 100
        // This number will decide the change for the repair be successful or fail
        int randomNumber = generateRandomNumber(0, 99);

        // If repair successfully if the number is grater or equal then 20
        if(randomNumber > 22){
            choosePartToRepair(car, partToRepair);
            System.out.println("Probability: " + randomNumber);

            // If mechanic ruin the car repair successfully if the number less then 2
        } else if (randomNumber < 2){
            System.out.println("Now you car is destroyed");
            System.out.println("Probability: " + randomNumber);

            // If the mechanic fail the repair of the car  if the number is between the interval [2, 22]
        }else {
            System.out.println("MarianAuto Fail the repair of you Vehicle");
            System.out.println("Probability: " + randomNumber);
        }
    }





}
