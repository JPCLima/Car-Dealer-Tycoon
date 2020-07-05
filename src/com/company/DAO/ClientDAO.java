package com.company.DAO;

import com.company.database.ConnectionDB;
import com.company.database.Query;
import com.company.model.Client;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class ClientDAO extends ConnectionDB {

    private static final int NUMBER_CLIENTS_DB = 2;

    // Method to get all the list of clients from DB
    private List<Client> getClientListDB(){
        // Create connection to create run the queries
        Query query = new Query();

        // Open connection
        if(!query.open()){
            System.out.println("Cant't open datasource");
            return null;
        }

        // Execute the query
        List<Client> clients = query.queryClient();
        if(clients == null){
            System.out.println("No clients");
            return clients;
        }

        // close connection
        query.close();

        return clients;
    }

    // Method to get client from DB using ID
    private Client getClient(Integer clientID){
        // Get all the DB clients and store in the list
        List<Client> clientsDB = getClientListDB();
        if (clientsDB != null) {
            return clientsDB.get(clientID);
        }
        return null;
    }

    // Get a random Client from DB
    public Client getRandomClient(){
        // Generate a random number as ID
        int randomNum = generateRandomNumber(0, NUMBER_CLIENTS_DB);
        return getClient(randomNum);
    }

    // Generate random number (I don't know where to store)
    private int generateRandomNumber(Integer min, Integer max){
        int randomNum = ThreadLocalRandom.current().nextInt(min, max + 1);
        return randomNum;
    }

    // Get 3 random clients
    public List<Client> getInitialClients(){
        // Create a new list to store the 3 initial clients
        List<Client> initialClients = new ArrayList<>();

        // Create a random number to choose the initial clients
        // The clients cannot be repeated
        while (initialClients.size() < 3){
            Client client = getRandomClient();

            if(!initialClients.contains(client)){
                System.out.println("Client added: " + client);
                initialClients.add(client);
            }
        }

        return initialClients ;
    }


}
