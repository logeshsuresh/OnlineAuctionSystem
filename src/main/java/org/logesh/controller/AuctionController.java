package org.logesh.controller;

import org.logesh.dto.CloseAuctionResponseDto;
import org.logesh.entity.Auction;
import org.logesh.entity.Bid;
import org.logesh.service.AuctionService;

import java.util.Optional;

public class AuctionController {

    private final AuctionService auctionService;

    public AuctionController(AuctionService auctionService) {
        this.auctionService = auctionService;
    }

    public Auction createAuction(double lowestBid, double highestBid, double participationCost, String sellerId) {
        return this.auctionService.createAuction(lowestBid, highestBid, participationCost, sellerId);
    }

    public CloseAuctionResponseDto closeAuction(String auctionId) {
        Optional<Bid> highestBid = this.auctionService.closeAuction(auctionId);
        return CloseAuctionResponseDto.from(highestBid.get());
    }

}
