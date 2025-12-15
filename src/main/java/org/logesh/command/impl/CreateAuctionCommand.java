package org.logesh.command.impl;

import org.logesh.command.Command;
import org.logesh.controller.AuctionController;
import org.logesh.entity.Auction;

public class CreateAuctionCommand implements Command {

    private final AuctionController auctionController;
    private final String auctionId;
    private final double lowestBid;
    private final double highestBid;
    private final double participationCost;
    private final String sellerName;

    public CreateAuctionCommand(AuctionController auctionController, String auctionId, double lowestBid, double highestBid, double participationCost, String sellerName) {
        this.auctionController = auctionController;
        this.auctionId = auctionId;
        this.lowestBid = lowestBid;
        this.highestBid = highestBid;
        this.participationCost = participationCost;
        this.sellerName = sellerName;
    }

    @Override
    public void execute() {
        Auction auction = auctionController.createAuction(lowestBid, highestBid, participationCost, sellerName);
        System.out.println("Auction created successfully with ID: " + auction.getAuctionId());
    }

}