package org.logesh.service;

import org.logesh.entity.Bid;

public interface BidService {
    Bid createBid(String auctionId, String buyerId, double amount);
    Bid findById(String bidId);
    void updateBid(String auctionId, String buyerId, String bidId, double newBidAmount);
    void withdraw(String bidId);
}
