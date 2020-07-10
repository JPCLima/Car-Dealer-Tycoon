package com.company.history;

public class Transaction{
    public String seller;
    public String buyer;
    public Double amount;
    // Constructor
    public Transaction(String seller, String buyer, Double amount) {
        this.seller = seller;
        this.buyer = buyer;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "    Seller: " + seller + "     | Buyer: " + buyer + "     | Amount: "  + amount;
    }
}