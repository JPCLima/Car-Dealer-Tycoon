package com.company.database;

public class TestConnection {
    public static void main(String[] args) {

        try{
            ConnectionDB connectionDB = new ConnectionDB();
            connectionDB.open();
            System.out.println("Connected to the DB");
            connectionDB.close();
        }catch(Exception e){
            System.out.println("Not Connected | Error: " + e);
        }
    }
}

