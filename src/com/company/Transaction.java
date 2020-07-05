package com.company;

import com.company.human.Human;
import com.company.human.Player;
import com.company.model.Client;

public class Transaction{
    public Player playerSeller;
    public Client clientBuyer;
    public Player playerBuyer;

    // Constructor
    public Transaction(Player playerSeller, Client clientBuyer) {
        this.playerSeller = playerSeller;
        this.clientBuyer = clientBuyer;
    }

    public Transaction(Player playerBuyer) {
        this.playerBuyer =  playerBuyer;
    }

    @Override
    public String toString() {
        return "Transaction";

    }
}