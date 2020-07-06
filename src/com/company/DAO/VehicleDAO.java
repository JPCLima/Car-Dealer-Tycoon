package com.company.DAO;

import com.company.database.ConnectionDB;
import com.company.database.Query;
import com.company.model.Vehicle;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class VehicleDAO {

    // Store all the vehicles from DB in the clientsDB
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

}
