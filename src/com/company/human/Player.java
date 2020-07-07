package com.company.human;

import com.company.DAO.ClientDAO;
import com.company.DAO.VehicleDAO;
import com.company.Transaction;
import com.company.model.Client;
import com.company.model.Vehicle;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
public class Player extends Human {

    // Variable to store the number of moves of the player
    private Integer moves;

    // Initialize ClientDAO and VehicleDAO
    ClientDAO clientDAO = new ClientDAO();
    VehicleDAO vehicleDAO = new VehicleDAO();

    // Create a list to store the list of clients from DB
    private List<Client> clientListDB;
    private List<Vehicle> vehicleListDB;

    // Create a list to store the cars from th player
    private List<Vehicle> garage;

    // Create an array for the potential clients
    private List<Client> potentialClientList;

    // Create a list to store the transactions from th player
    private List<Transaction> transactions;

    // Constructor of the Player using the super
    public Player(String name, Double cash) {
        super(name, cash);
        this.moves = 0;
        garage = new ArrayList<>();
        potentialClientList = new ArrayList<>();
        transactions = new ArrayList<>();
        clientListDB = clientDAO.getClientListDB();
        vehicleListDB = vehicleDAO.getVehicleListDB();
    }

    // Getters and Setters
    public Integer getMoves() {
        return moves;
    }

    public void setMoves(Integer moves) {
        this.moves = moves;
    }

    // Method to increase the number of moves
    public void increaseMoves(){
        setMoves(getMoves() + 1);
    }


    // Add a vehicle to the Garage
    public void addVehicleToGarage(Vehicle vehicle){
        garage.add(vehicle);
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
            System.out.println("    " + (i+1) + ". " + garage.get(i));
        }
    }

    // Method to buy a vehicle
    public void buyVehicle(Integer id){
        Vehicle newVehicle = vehicleListDB.get(id);
        // Make sure the vehicle is already in the garage
        if(!garage.contains(newVehicle)){
            if(this.cash >= newVehicle.getValue()){
                // Pay tax to clean the car
                this.payTaxCleaning(newVehicle.getValue());
                // The change money to the player
                this.cash -= newVehicle.getValue();
                // Add the car to the garage
                this.addVehicleToGarage(newVehicle);
                System.out.println("Congratulations, you have a new vehicle in you garage");
            }else{
                System.out.println("You don't have enough money to buy this vehicle");
            }
        }

    }

    // Method to sell the car
    public void sellVehicle(Integer id){
        Vehicle newVehicle = vehicleListDB.get(id);
        if(garage.contains(newVehicle)){
            // Pay tax to clean the car
            this.payTaxCleaning(newVehicle.getValue());
            // Add money to the cash of player
            this.cash += newVehicle.getValue();
            // Remove the car from the garage
            this.removeVehicleFromGarage(newVehicle);
            System.out.println("Your vehicle has been sold");
        }else{
            System.out.println("You don't have any car with that ID");
        }

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
    private Client getClient(Integer clientID){
        if (clientListDB != null) {
            return clientListDB.get(clientID);
        }
        return null;
    }

    // Get random Client
    public Client getRandomClient(){
        Client client = new Client();
        if(potentialClientList.size() != clientListDB.size()){
            // While will not find a different from the DB keep run
            boolean notAdded = true;
            while (notAdded){
                // Generate a random number as ID
                int randomNum = generateRandomNumber(clientListDB.size() - 1);
                client =  getClient(randomNum);

                if(!potentialClientList.contains(client)){
                    potentialClientList.add(client);
                    notAdded = false;
                }
            }
        }
        return client;
    }

    // Get N Clients
    public void getNRandomClients(Integer numberOfClients){
        // Make sure all the clients are not in the potentialClientList
        if(potentialClientList.size() < clientListDB.size()){
            // Create a new list to store the N initial clients
            List<Client> initialClients = new ArrayList<>();

            // Create a random number to choose the initial clients
            // The clients cannot be repeated
            while (initialClients.size() < numberOfClients){
                Client client = getRandomClient();

                if(potentialClientList.contains(client)){
                    initialClients.add(client);
                }
            }
        }
    }
    // Print the list of cars
    public void printPotentialClientList(){
        System.out.println("You have " + potentialClientList.size() + " potential clients to make business");
        for (Client client : potentialClientList) {
            System.out.println(client);
        }
    }



    // Get more potential clients
    public void getClientsMarketingCampaign (){
        int potentialClientsToAdd = clientListDB.size() - potentialClientList.size();
        // If have full space add 5
        if(potentialClientsToAdd == 5){
            this.cash -= 250.0;
            getNRandomClients( 5);
        }else if(potentialClientsToAdd != 0){
            this.cash -= 250.0;
            getNRandomClients( potentialClientsToAdd);
        }else{
            System.out.println("You used all the potential clients");
        }
    }

    // Methods to get more Potential Clients
    public void getClientsAnnouncement (){
        int potentialClientsToAdd = clientListDB.size() - potentialClientList.size();
        // If have full space add 3
        if(potentialClientsToAdd == 3){
            this.cash -= 150.0;
            getNRandomClients(3);
        }else if(potentialClientsToAdd != 0){
            this.cash -= 150.0;
            getNRandomClients( potentialClientsToAdd);
        }else{
            System.out.println("You used all the potential clients");
        }

    }

    // Methods to get more Potential Clients
    public void getClientsOnlineAnnouncement (){
        int potentialClientsToAdd = clientListDB.size() - potentialClientList.size();
        // If have full space add 1
        if(potentialClientsToAdd == 1){
            this.cash -= 50.0;
            getNRandomClients(1);
        }else{
            System.out.println("You used all the potential clients");
        }
    }

    // Methods to get more Potential Clients
    public void getClientsSuccessfulTransaction  (){
        int potentialClientsToAdd = clientListDB.size() - potentialClientList.size();
        // If have full space add 1
        if(potentialClientsToAdd == 2){
            this.cash -= 50.0;
            getNRandomClients(1);
        }else{
            System.out.println("You used all the potential clients");
        }
    }




    // Methods for the potential Vehicles
    // Method to get vehicle from DB using ID
    private Vehicle getVehicle(Integer vehicleID){
        if (vehicleListDB != null) {
            return vehicleListDB.get(vehicleID);
        }
        return null;
    }

    // Get a random Vehicle from DB
    public void getRandomVehicle(){
        Vehicle vehicle;
        if(garage.size() != vehicleListDB.size()){
            // While will not find a different from the DB keep run
            boolean notAdded = true;
            while (notAdded){
                // Generate a random number as ID
                int randomNum = generateRandomNumber(vehicleListDB.size() - 1);
                vehicle =  getVehicle(randomNum);

                if(!garage.contains(vehicle)){
                    garage.add(vehicle);
                    notAdded = false;
                }
            }
        }
    }

    // Print Vehicle list
    public void printVehiclesAvailableToBuy(){
        // Remove all the vehicles form the Garage from the VehiclesDB
        System.out.println("You vehicles available Vehicles to buy:");
        for (int i = 0; i < vehicleListDB.size(); i++) {
            // Just print if is not in the garage
            if(!garage.contains(vehicleListDB.get(i))){
                System.out.println("    " + (i+1) + ". " + vehicleListDB.get(i));
            }
        }
    }

    // Generate random number (I don't know where to store)
    private int generateRandomNumber(Integer max){
        return ThreadLocalRandom.current().nextInt(0, max + 1);
    }

    @Override
    public String toString() {
        return "Name: " + name  + " | Cash: " + cash ;
    }

}
