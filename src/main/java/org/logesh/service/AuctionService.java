package org.logesh.service;

import org.logesh.entity.Auction;
import org.logesh.entity.Bid;

import java.util.Optional;

public interface AuctionService {
    Auction createAuction(double lowestBid, double highestBid, double participationCost, String sellerId);
    Auction findById(String auctionId);
    Optional<Bid> closeAuction(String auctionId);
}
