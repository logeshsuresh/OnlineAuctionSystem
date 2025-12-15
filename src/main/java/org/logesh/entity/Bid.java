package org.logesh.entity;

import lombok.Data;

import java.util.UUID;

@Data
public class Bid {

    private final String bidId;
    private final Auction auction;
    private final Buyer buyer;
    private double amount;

    public Bid(Auction auction, Buyer buyer, double amount) {
        this.bidId = UUID.randomUUID().toString();
        this.auction = auction;
        this.buyer = buyer;
        this.amount = amount;
    }

}
