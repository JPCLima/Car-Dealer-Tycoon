package com.company.database;

public class TestConnection {
    public static void main(String[] args) {

        try{
            new ConnectionDB().getConnection();
            System.out.println("Connected to the DB");
        }catch(Exception e){
            System.out.println("Not Connected | Error: " + e);
        }
    }
}

