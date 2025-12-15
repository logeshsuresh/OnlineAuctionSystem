package org.logesh.command.impl;

import org.logesh.command.Command;
import org.logesh.controller.BidController;
import org.logesh.entity.Bid;

public class CreateBidCommand implements Command {

    private final BidController bidController;
    private final String buyerName;
    private final String auctionId;
    private final double bidAmount;

    public CreateBidCommand(BidController bidController, String buyerName, String auctionId, double bidAmount) {
        this.bidController = bidController;
        this.buyerName = buyerName;
        this.auctionId = auctionId;
        this.bidAmount = bidAmount;
    }

    @Override
    public void execute() {
        Bid bid = bidController.createBid(auctionId, buyerName, bidAmount);
        System.out.println("Bid created successfully by " + buyerName + " for amount: " + bidAmount);
    }

}