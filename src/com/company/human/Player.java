package com.company.human;

import com.company.Transaction;
import com.company.model.Client;
import com.company.model.Vehicle;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Player extends Human {

    // Create a list to store the cars from th player
    private List<Vehicle> garage;

    // Create an array for the potential clients
    private List<Client> potentialClientList;

    // Create a list to store the transactions from th player
    private List<Transaction> transactions;

    // Constructor of the Player using the super
    public Player(String name, Double cash) {
        super(name, cash);
        garage = new ArrayList<>();
        potentialClientList = new ArrayList<>();
        transactions = new ArrayList<>();
    }

    // Add a vehicle to the Garage
    public void addVehicleToGarage(Vehicle vehicle){
        garage.add(vehicle);
    }

    // Add a vehicles to the Garage
    public void  addVehicleToGarage(ArrayList<Vehicle> vehicleArrayList){
        garage.addAll(vehicleArrayList);
    }

    // Remove Car from garage by the position
    public void removeVehicleFromGarage(Vehicle vehicle){
        garage.remove(vehicle);
    }

    // Check if the car is in the garage
    public boolean isInGarage(Vehicle vehicle){
        return garage.contains(vehicle);
    }

    // Print the list of cars
    public void printGarageList(){
        System.out.println("You have " + garage.size() + " cars in you garage");
        for (int i = 0; i < garage.size(); i++) {
            System.out.println((i+1) + ". " + garage.get(i));
        }
    }

    // Method to buy a vehicle
    public void buyVehicle(Vehicle vehicle, Double vehiclePrice){
        if(this.cash >= vehiclePrice){
            // Pay tax to clean the car
            this.payTaxCleaning(vehiclePrice);
            // The change money to the player
            this.cash -= vehiclePrice;
            // Add the car to the garage
            this.addVehicleToGarage(vehicle);
            System.out.println("Congratulations, you have a new vehicle in you garage");
        }else{
            System.out.println("You don't have enough money to buy this vehicle");
        }
    }

    // Method to sell the car
    public void sellVehicle(Vehicle vehicle, Double vehiclePrice){
        // Pay tax to clean the car
        this.payTaxCleaning(vehiclePrice);
        // Add money to the cash of player
        this.cash += vehiclePrice;
        // Remove the car from the garage
        this.removeVehicleFromGarage(vehicle);
        System.out.println("Your vehicle has been sold");
    }

    // Pay tax method: 2% of the value of the vehicle
    private void payTaxCleaning(Double vehiclePrice) {
        this.cash -= (vehiclePrice * 0.02);
    }

    // Get the transactions
    public List<Transaction> getTransactions() {
        return transactions;
    }


    // Methods for the potential clients
    // Method to get client from DB using ID
    private Client getClient(List<Client> clientsDB, Integer clientID){
        if (clientsDB != null) {
            return clientsDB.get(clientID);
        }
        return null;
    }

    // Get random Client
    public Client getRandomClient(List<Client> clientsDB){
        if(potentialClientList.size() != clientsDB.size()){
            // While will not find a different from the DB keep run
            boolean notAdded = true;
            while (notAdded){
                // Generate a random number as ID
                int randomNum = generateRandomNumber(0, clientsDB.size() - 1);
                Client client =  getClient(clientsDB, randomNum);

                if(!potentialClientList.contains(client)){
                    potentialClientList.add(client);
                    notAdded = false;
                }
            }
        }
        return null;
    }

    // Get N Clients
    public List<Client> getNRandomClients(List<Client> clientsDB, Integer numberOfClients){
        // Create a new list to store the N initial clients
        List<Client> initialClients = new ArrayList<>();

        // Create a random number to choose the initial clients
        // The clients cannot be repeated
        while (initialClients.size() < numberOfClients){
            Client client = getRandomClient(clientsDB);

            if(!potentialClientList.contains(client)){
                initialClients.add(client);
            }
        }

        return initialClients;
    }

    // Print the list of cars
    public void printPotentialClientList(){
        System.out.println("You have " + potentialClientList.size() + " potential clients to make business");
        for (Client client : potentialClientList) {
            System.out.println(client);
        }
    }

    public void getClientsMarketingCampaign (List<Client> clientsDB){
        this.cash -= 250.0;
        getNRandomClients(clientsDB, 5);
    }

    // Methods to get more Potential Clients
    public void getClientsAnnouncement (List<Client> clientsDB){
        this.cash -= 150.0;
        getNRandomClients(clientsDB, 3);
    }

    // Methods to get more Potential Clients
    public void getClientsOnlineAnnouncement (List<Client> clientsDB){
        this.cash -= 50.0;
        getNRandomClients(clientsDB, 1);
    }

    // Generate random number (I don't know where to store)
    private int generateRandomNumber(Integer min, Integer max){
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    @Override
    public String toString() {
        return "Name: " + name  + " | Cash: " + cash ;
    }

}
