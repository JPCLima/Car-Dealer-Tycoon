package com.company.DAO;

import com.company.database.ConnectionDB;
import com.company.database.Query;
import com.company.human.Player;
import com.company.model.Client;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class ClientDAO extends ConnectionDB {

    // Store all the clients from DB in the clientsDB
    public List<Client> clientsDB;

    // Constructor of ClientDAO
    public ClientDAO() {
        this.clientsDB = getClientListDB();
    }

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
            return null;
        }

        // close connection
        query.close();

        return clients;
    }

    // Method to get client from DB using ID
    private Client getClient(Integer clientID){
        if (clientsDB != null) {
            return clientsDB.get(clientID);
        }
        return null;
    }

    // Get a random Client from DB
    public Client getRandomClient(){
        // Generate a random number as ID
        int randomNum = generateRandomNumber(0, clientsDB.size());
        return getClient(randomNum);
    }

    // Get N random clients
    public List<Client> getNClients(Integer numberOfClients){
        // Create a new list to store the 3 initial clients
        List<Client> initialClients = new ArrayList<>();

        // Create a random number to choose the initial clients
        // The clients cannot be repeated
        while (initialClients.size() < numberOfClients){
            Client client = getRandomClient();

            if(!initialClients.contains(client)){
                initialClients.add(client);
            }
        }

        return initialClients ;
    }

    // Methods to get more Potential Clients
    public List<Client> getClientsMarketingCampaign (Player player){
        player.cash -= 250.0;
        return getNClients(5) ;
    }

    // Methods to get more Potential Clients
    public List<Client> getClientsAnnouncement (Player player){
        player.cash -= 150.0;
        return getNClients(3) ;
    }

    // Methods to get more Potential Clients
    public List<Client> getClientsOnlineAnnouncement (Player player){
        player.cash -= 50.0;
        return getNClients(1) ;
    }

    // Generate random number (I don't know where to store)
    private int generateRandomNumber(Integer min, Integer max){
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }
}
