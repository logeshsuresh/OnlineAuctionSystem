package org.logesh.command.impl;

import org.logesh.command.Command;
import org.logesh.controller.BidController;

public class UpdateBidCommand implements Command {

    private final BidController bidController;
    private final String buyerId;
    private final String auctionId;
    private final String bidId;
    private final double newBidAmount;

    public UpdateBidCommand(BidController bidController, String buyerId, String auctionId, String bidId, double newBidAmount) {
        this.bidController = bidController;
        this.buyerId = buyerId;
        this.auctionId = auctionId;
        this.bidId = bidId;
        this.newBidAmount = newBidAmount;
    }

    @Override
    public void execute() {
        bidController.updateBid(auctionId, buyerId, bidId, newBidAmount);
        System.out.println("Bid updated successfully by " + buyerId + " to amount: " + newBidAmount);
    }

}