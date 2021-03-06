package com.company.database;

import java.sql.*;
import java.util.Properties;

import static com.company.database.ConfigurationDB.*;
import static com.company.database.ConfigurationDB.DB_URL;

public class ConnectionDB {

    // Queries
    public static final String QUERY_CLIENTS = "FROM clients SELECT *";
    public static final String QUERY_VEHICLE = "FROM vehicle SELECT *";

    public Connection conn;
    public PreparedStatement queryClient;
    public PreparedStatement queryVehicle;

    // NO NEED I CAN REMOVE
    // Method to open the connection
    public boolean open() {
        try {
            Properties props = new Properties();
            props.setProperty("user", USER);
            props.setProperty("password", PASS);
            conn = DriverManager.getConnection(DB_URL, props);
            queryClient = conn.prepareStatement(QUERY_CLIENTS);
            queryVehicle = conn.prepareStatement(QUERY_VEHICLE);

            return true;
        } catch (SQLException e) {
            System.out.println("Couldn't connect to database: " + e.getMessage());
            return false;
        }
    }

    // Method to  close connection
    public void close() {
        try {

            if(queryClient != null) {
                queryClient.close();
            }

        } catch (SQLException e) {
            System.out.println("Couldn't close connection: " + e.getMessage());
        }
    }

}
