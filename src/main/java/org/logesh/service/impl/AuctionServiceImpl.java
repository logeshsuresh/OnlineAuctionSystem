package org.logesh.service.impl;

import org.logesh.entity.Auction;
import org.logesh.entity.Bid;
import org.logesh.entity.Seller;
import org.logesh.enums.AuctionState;
import org.logesh.repository.AuctionRepository;
import org.logesh.service.AuctionService;
import org.logesh.service.RankerService;
import org.logesh.service.SellerService;

import java.util.Optional;

public class AuctionServiceImpl implements AuctionService {

    private final SellerService sellerService;
    private final RankerService rankerService;
    private final AuctionRepository auctionRepository;

    public AuctionServiceImpl(SellerService sellerService, RankerService rankerService, AuctionRepository auctionRepository) {
        this.sellerService = sellerService;
        this.rankerService = rankerService;
        this.auctionRepository = auctionRepository;
    }

    @Override
    public Auction createAuction(double lowestBid, double highestBid, double participationCost, String sellerId) {
        Seller seller = this.sellerService.findById(sellerId);
        Auction auction = new Auction(lowestBid, highestBid, participationCost, seller);
        return this.auctionRepository.save(auction);
    }

    @Override
    public Auction findById(String auctionId) {
        return this.auctionRepository.findById(auctionId).orElseThrow(() -> new RuntimeException("AuctionId not found"));
    }

    @Override
    public Optional<Bid> closeAuction(String auctionId) {
        Auction auction = this.findById(auctionId);
        auction.setAuctionState(AuctionState.CLOSED);
        this.auctionRepository.save(auction);
        return this.rankerService.getHighestBid(auction.getAuctionId());
    }

}
