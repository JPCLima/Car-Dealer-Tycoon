package com.company.MechanicalWorkshop;

import com.company.StandVehicle.Car;

public interface Repair {

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

    // This method is choosing which part of the Vehicle is to repair
    default void choosePartToRepair(Car car, String partToRepair){
        if (partToRepair.equals("brakes")){
            repairBrakes(car);
        }else if(partToRepair.equals("dampers")){
            repairDampers(car);
        }else if(partToRepair.equals("engine")){
            repairEngine(car);
        }else if(partToRepair.equals("car body")){
            repairCarBody(car);
        }else if(partToRepair.equals("gear box")){
            repairGearbox(car);
        }else{
            System.out.println("We cannot fix that component of the car in our workshop");
        }
    }

}
