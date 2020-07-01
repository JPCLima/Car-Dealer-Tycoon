package com.company.MechanicalWorkshop;

import com.company.StandVehicle.Car;

public interface Repair {

    // Repair part of the car method
    private static void repairPart(Car car, Integer perCentValue){
        car.value = car.value + (car.value*0.2);
    }

    // Increase the car’s value 10% - Brakes
    default void repairBrakes(Car car) {
        repairPart(car, 10);
    }

    // Increase the car’s value 20% - Dampers
    default void repairDampers(Car car) {
        repairPart(car, 20);
    }

    // Increase the car’s value 100% - Engine
    default void repairEngine(Car car) {
        repairPart(car, 20);
    }

    // Increase the car’s value 50% - Car Body
    default void repairCarBody(Car car) {
        repairPart(car, 50);
    }

    // Increase the car’s value 50% - Gearbox
    default void repairGearbox(Car car) {
        repairPart(car, 50);
    }

}
