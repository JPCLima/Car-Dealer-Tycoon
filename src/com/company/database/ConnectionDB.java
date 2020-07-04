package com.company.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import static com.company.database.ConfigurationDB.*;
import static com.company.database.ConfigurationDB.DB_URL;

public class ConnectionDB {
    public Connection getConnection(){
        try{
            Properties props = new Properties();
            props.setProperty("user", USER);
            props.setProperty("password", PASS);
            CONNECTION = DriverManager.getConnection(DB_URL, props);
            return CONNECTION;

        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
}
