package com.company.database;

import com.company.model.Client;
import com.company.model.Vehicle;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Query extends ConnectionDB {

    public static final String TABLE_CLIENTS = "clients";
    public static final String TABLE_CLIENTS_VEHICLES = "vehicles";

    // Index of the column
    public static final int INDEX_ID = 1;
    public static final int INDEX_NAME = 2;
    public static final int INDEX_CASH = 3;
    public static final int INDEX_INTEREST_VEHICLE_TYPE = 4;
    public static final int INDEX_INTEREST_SEGMENT = 5;
    public static final int INDEX_INTEREST_CAR_STATE = 6;

    public static final int INDEX_BRAND = 2;
    public static final int INDEX_VALUE = 3;
    public static final int INDEX_MILEAGE = 4;
    public static final int INDEX_COLOUR = 5;
    public static final int INDEX_SEGMENT = 6;
    public static final int INDEX_BRAKES_CONDITIONS = 7;
    public static final int INDEX_DAMPERS_CONDITIONS = 8;
    public static final int INDEX_ENGINE_CONDITIONS = 9;
    public static final int INDEX_CAR_BODY_CONDITIONS = 10;
    public static final int INDEX_GEAR_BOX_CONDITIONS = 11;
    public static final int INDEX_LOAD_CAPACITY = 12;
    public static final int INDEX_VEHICLE_STATE = 13;
    public static final int INDEX_VEHICLE_TYPE = 14;


    // Get all the clients from the data base and store them in the list
    public List<Client> queryClient() {
        // SQL query
        try (Statement statement = conn.createStatement();
             ResultSet results = statement.executeQuery("SELECT * FROM " + TABLE_CLIENTS)) {

            List<Client> clients = new ArrayList<>();
            while (results.next()) {
                Client client = new Client();
                client.setId(results.getInt(INDEX_ID));
                client.setName(results.getString(INDEX_NAME));
                client.setCash(results.getDouble(INDEX_CASH));
                client.setInterestVehicleType(results.getString(INDEX_INTEREST_VEHICLE_TYPE));
                client.setInterestSegment(results.getString(INDEX_INTEREST_SEGMENT));
                client.setInterestCarState(results.getString(INDEX_INTEREST_CAR_STATE));
                clients.add(client);
            }
            return clients;

        } catch (SQLException e) {
            System.out.println("Query failed: " + e.getMessage());
            return null;
        }
    }

    // Get all the vehicle from the data base and store them in the list
    public List<Vehicle> queryVehicle() {
        // SQL query
        try (Statement statement = conn.createStatement();
             ResultSet results = statement.executeQuery("SELECT * FROM " + TABLE_CLIENTS_VEHICLES)) {

            List<Vehicle> vehicles = new ArrayList<>();
            while (results.next()) {
                Vehicle vehicle = new Vehicle();
                vehicle.setId(results.getInt(INDEX_ID));
                vehicle.setBrand(results.getString(INDEX_BRAND));
                vehicle.setValue(results.getDouble(INDEX_VALUE));
                vehicle.setMileage(results.getDouble(INDEX_MILEAGE));
                vehicle.setColour(results.getString(INDEX_COLOUR));
                vehicle.setSegment(results.getString(INDEX_SEGMENT));
                vehicle.setBrakesCondition(results.getString(INDEX_BRAKES_CONDITIONS ));
                vehicle.setDampersCondition(results.getString(INDEX_DAMPERS_CONDITIONS));
                vehicle.setEngineCondition(results.getString(INDEX_ENGINE_CONDITIONS));
                vehicle.setCarBodyCondition(results.getString(INDEX_CAR_BODY_CONDITIONS));
                vehicle.setGearBoxCondition(results.getString(INDEX_GEAR_BOX_CONDITIONS));
                vehicle.setLoadCapacity(results.getDouble(INDEX_LOAD_CAPACITY));
                vehicle.setVehicleState(results.getString(INDEX_VEHICLE_STATE));
                vehicle.setVehicleType(results.getString(INDEX_VEHICLE_TYPE));
                vehicles.add(vehicle);
            }
            return vehicles;

        } catch (SQLException e) {
            System.out.println("Query failed: " + e.getMessage());
            return null;
        }
    }
}
