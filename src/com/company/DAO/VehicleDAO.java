package com.company.DAO;

import com.company.database.ConnectionDB;
import com.company.database.Query;
import com.company.model.Vehicle;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class VehicleDAO extends ConnectionDB {

    // Store all the clients from DB in the clientsDB
    public List<Vehicle> vehiclesDB;

    // Constructor of ClientDAO
    public VehicleDAO() {
        this.vehiclesDB = getVehicleListDB();
    }

    // Method to get all the list of Vehicle from DB
    public List<Vehicle> getVehicleListDB(){
        // Create connection to create run the queries
        Query query = new Query();

        // Open connection
        if(!query.open()){
            System.out.println("Cant't open datasource");
            return null;
        }

        // Execute the query
        List<Vehicle> vehicles = query.queryVehicle();
        if(vehicles == null){
            System.out.println("No vehicles");
            return null;
        }

        // close connection
        query.close();

        return vehicles;
    }

    // Method to get vehicle from DB using ID
    private Vehicle getClient(Integer vehicleID){
        if (vehiclesDB != null) {
            return vehiclesDB.get(vehicleID);
        }
        return null;
    }

    // Get a random Client from DB
    public Vehicle getRandomVehicle(){
        // Generate a random number as ID
        int randomNum = generateRandomNumber(vehiclesDB.size());
        return getClient(randomNum);
    }

    // Generate random number (I don't know where to store)
    private int generateRandomNumber(Integer max){
        return ThreadLocalRandom.current().nextInt(0, max + 1);
    }

}
