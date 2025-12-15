package org.logesh.entity;

import lombok.Data;
import org.logesh.enums.AuctionState;

import java.util.UUID;

@Data
public class Auction {

    private final String auctionId;
    private final double lowestBid;
    private final double highestBid;
    private final double participationCost;
    private final Seller seller;
    private AuctionState auctionState;

    public Auction(double lowestBid, double highestBid, double participationCost, Seller seller) {
        this.auctionId = UUID.randomUUID().toString();
        this.lowestBid = lowestBid;
        this.highestBid = highestBid;
        this.participationCost = participationCost;
        this.seller = seller;
        this.auctionState = AuctionState.LIVE;
    }

}
