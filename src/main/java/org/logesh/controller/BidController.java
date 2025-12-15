package org.logesh.controller;

import org.logesh.entity.Bid;
import org.logesh.service.BidService;

public class BidController {

    private final BidService bidService;

    public BidController(BidService bidService) {
        this.bidService = bidService;
    }

    public Bid createBid(String auctionId, String buyerId, double amount) {
        return this.bidService.createBid(auctionId, buyerId, amount);
    }

    public void updateBid(String auctionId, String buyerId, String bidId, double newBidAmount) {
        this.bidService.updateBid(auctionId, buyerId, bidId, newBidAmount);
    }

    public void withdrawBid(String bidId) {
        this.bidService.withdraw(bidId);
    }

}
