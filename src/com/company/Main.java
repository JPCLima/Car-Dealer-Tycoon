package com.company;


import com.company.DAO.ClientDAO;
import com.company.DAO.VehicleDAO;
import com.company.human.Player;
import com.company.mechanicalWorkshop.MechanicalWorkshop;
import com.company.model.Client;
import com.company.model.Vehicle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // Initial cash game
        double initialCash = 200000.0;
        double winGame = 2*initialCash;

        // Create a Player
        Player player = new Player("Joao", initialCash);

        // Initialize a mechanical workshop
        MechanicalWorkshop mechanicalWorkshop = new MechanicalWorkshop();

        // Initialize Game
        // Get 3 Potential clients to sell the car
        player.getNRandomClients(2);

        // Get one Vehicle to the player
        player.getRandomVehicle();

        // Welcome msg
        printWelcomeMsg();

        while(player.getCash() < winGame){
            // Print Menu
            printOptions();
            // Ask for an user input
            int option = askForInput();

            switch (option){

                case 1:
                    // 1- List of cars you can buy
                    System.out.println("List of vehicles available to buy:");
                    player.printVehiclesAvailableToBuy();
                    break;
                case 2:
                    // 2- Buy a Vehicle
                    System.out.println("Please enter the ID of the vehicles you would like to buy:");
                    // Ask for the ID of the Car
                    int vehicleID = askForInput();
                    // Add a new vehicle
                    player.buyVehicle(vehicleID);
                    // Increase the number of moves
                    player.increaseMoves();
                    // Get 2 potential Clients
                    player.getClientsSuccessfulTransaction();
                    break;
                case 3:
                    // 3- Print all the cars in the garage
                    player.printGarageList();
                    break;
                case 4:
                    // 4 - Repair the car
                    printMechanicalWorkshops();
                    // Options of repair
                    int option4 = askForInput();

                    // declare variables to use in the switch
                    int vehicleIDToFix;
                    int componentToFix;
                    Vehicle newVehicle;

                    // List of the Options
                    switch (option4){

                        case 1:
                            // 1 - JanuszCars
                            System.out.println("Please enter the ID of the vehicle you would like to fix:");
                            // Display available vehicles in the garage
                            player.printGarageList();
                            // Ask for the ID of the Car
                            vehicleIDToFix = askForInput();
                            System.out.println("Please enter witch component you would like to fix:");
                            // Print components to fix
                            printComponentToFix();
                            // Ask for the ID of the Car
                            componentToFix = askForInput();

                            newVehicle = player.getGaragePosition(vehicleIDToFix);
                            mechanicalWorkshop.JanuszCars(player, newVehicle, componentToFix);

                            // Add the the repait to the VehicleHistory
                            player.addToVehicleHistory(newVehicle);
                            break;
                        case 2:
                            // 2 - MarianAuto
                            System.out.println("Please enter the ID of the vehicle you would like to fix:");
                            // Display available vehicles in the garage
                            player.printGarageList();
                            // Ask for the ID of the Car
                            vehicleIDToFix = askForInput();
                            System.out.println("Please enter witch component you would like to fix:");
                            // Print components to fix
                            printComponentToFix();
                            // Ask for the ID of the Car
                            componentToFix = askForInput();

                            newVehicle = player.getGaragePosition(vehicleIDToFix);
                            mechanicalWorkshop.MarianAuto(player, newVehicle, componentToFix);
                            break;
                        case 3:
                            // 3 - PPHU Adrian
                            System.out.println("Please enter the ID of the vehicle you would like to fix:");
                            // Display available vehicles in the garage
                            player.printGarageList();
                            // Ask for the ID of the Car
                            vehicleIDToFix = askForInput();
                            System.out.println("Please enter witch component you would like to fix:");
                            // Print components to fix
                            printComponentToFix();
                            // Ask for the ID of the Car
                            componentToFix = askForInput();

                            newVehicle = player.getGaragePosition(vehicleIDToFix);
                            mechanicalWorkshop.PPHUAdrian(player, newVehicle, componentToFix);
                            break;
                        default:
                            System.out.println("    Please choose valid option.");
                    }
                    // Increase the number of moves
                    player.increaseMoves();
                    break;
                case 5:
                    // 5- Get a list of potential clients
                    System.out.println("Potential Clients: ");
                    player.printPotentialClientList();
                    break;
                case 6:
                    // display Vehicles
                    player.printGarageList();
                    // Display client
                    player.printPotentialClientList();

                    // Ask for the the client  ID & vehicle ID
                    System.out.println("Please enter the vehicle ID: ");
                    int vID = askForInput();
                    System.out.println("Please enter the client ID: ");
                    int clientID = askForInput();

                    // Add a new vehicle
                    player.sellVehicle(vID, clientID);

                    // Increase the number of moves
                    player.increaseMoves();
                    // Get 2 potential Clients
                    player.getClientsSuccessfulTransaction();
                    break;
                case 7:
                    // 7- Buy an advertising
                    printMethodsToGetClients();
                    int option7 = askForInput();
                    // List of the Options
                    switch (option7){
                        case 1:
                            // Get more 5 potential clients
                            player.getClientsMarketingCampaign();
                            break;
                        case 2:
                            // Get more 3 potential clients
                            player.getClientsAnnouncement();
                            break;
                        case 3:
                            // Get more 1 potential clients
                            player.getClientsOnlineAnnouncement();
                            break;
                    }
                    // Increase the number of moves
                    player.increaseMoves();
                    break;
                case 8:
                    // 8 - Get your account balance
                    System.out.println("    Initial cash: " + initialCash);
                    System.out.println("    Current cash: " + player.getCash());
                    System.out.println("    Cash missing to win the game: " + (player.getCash() - (initialCash*2)));
                    System.out.println("    Number of moves: " + player.getMoves());

                    break;
                case 9:
                    // 9- Transactions history
                    System.out.println("Check transactions history: ");
                    player.printTransactions();
                    break;
                case 10:
                    // 10 - Vehicle repair History
                    player.printHistoryRepairVehicle();
                    break;
                case 11:
                    // 11 -  Check how much you spent to fix and clean a vehicle
                    player.getTotalCost();
                    break;
                case 0:
                    System.exit(0);
                default: {
                    System.out.println("    Please choose valid option.");
                }
            }

        }


        if(player.getCash() > winGame){
            System.out.println("    Congratulation you won!!!");
            System.out.println("    Number of moves: " + player.getMoves());
        }
    }

    // Main Menu
    public static void printOptions() {
        System.out.println("\nChoose option:");
        System.out.println("1 - List the vehicles you can buy");
        System.out.println("2 - Buy a vehicle");
        System.out.println("3 - List owned vehicle");
        System.out.println("4 - Repair the car");
        System.out.println("5 - View the potential clients");
        System.out.println("6 - Sell a car to potential client");
        System.out.println("7 - Buy an advertising");
        System.out.println("8 - Check your account balance");
        System.out.println("9 - Check transactions history");
        System.out.println("10 - Check vehicles repair history ");
        System.out.println("11 - Check how much you spent to fix and clean a car. ");
    }

    // Welcome Message
    public static void printWelcomeMsg(){
        System.out.println("Welcome to the Car Dealer Tycoon!!!");
    }

    public  static void printMethodsToGetClients(){
        System.out.println("\nChoose advertising to get more clients:");
        System.out.println("    1 - Marketing Campaign");
        System.out.println("    2 - Announcement ");
        System.out.println("    3 - Online Announcement");
    }

    public  static void printMechanicalWorkshops(){
        System.out.println("\nChoose one Mechanical workshop:");
        System.out.println("    1 - JanuszCars");
        System.out.println("    2 - MarianAuto ");
        System.out.println("    3 - PPHU Adrian ");
    }

    public  static void printComponentToFix(){
        System.out.println("\nChoose one Component to fix:");
        System.out.println("    1 - Brakes");
        System.out.println("    2 - Dampers ");
        System.out.println("    3 - Engine ");
        System.out.println("    4 - Car body ");
        System.out.println("    5 - Gearbox ");
    }

    public static int askForInput(){
        int option = 0;
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String s = br.readLine();
            option = Integer.parseInt(s);
        } catch (NumberFormatException ex) {
            System.out.println("Not a number !");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return option;
    }


}
