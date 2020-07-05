package com.company.database;

import com.company.human.Client;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Query extends ConnectionDB {

    public static final String TABLE_CLIENTS = "clients";
    public static final String COLUMN_VEHICLES = "vehicles";

    // Index of the column
    public static final int INDEX_ID = 1;
    public static final int INDEX_NAME = 2;
    public static final int INDEX_CASH = 3;
    public static final int INDEX_INTEREST_VEHICLE_TYPE = 4;
    public static final int INDEX_INTEREST_SEGMENT = 5;
    public static final int INDEX_INTEREST_CAR_STATE = 6;




    // Get all the clients from the data base and store them in the list
    public List<Client> queryClient() {
        // SQL query
        StringBuilder sb = new StringBuilder("SELECT * FROM ");
        sb.append(TABLE_CLIENTS);

        try (Statement statement = conn.createStatement();
             ResultSet results = statement.executeQuery(sb.toString())) {

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
}
