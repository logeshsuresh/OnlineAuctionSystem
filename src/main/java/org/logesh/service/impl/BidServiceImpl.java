package org.logesh.service.impl;

import org.logesh.entity.Auction;
import org.logesh.entity.Bid;
import org.logesh.entity.Buyer;
import org.logesh.repository.BidRepository;
import org.logesh.service.AuctionService;
import org.logesh.service.BidService;
import org.logesh.service.BuyerService;
import org.logesh.service.RankerService;

public class BidServiceImpl implements BidService {

    private final AuctionService auctionService;
    private final BuyerService buyerService;
    private final BidRepository bidRepository;
    private final RankerService rankerService;

    public BidServiceImpl(AuctionService auctionService, BuyerService buyerService, BidRepository bidRepository, RankerService rankerService) {
        this.auctionService = auctionService;
        this.buyerService = buyerService;
        this.bidRepository = bidRepository;
        this.rankerService = rankerService;
    }

    @Override
    public Bid createBid(String auctionId, String buyerId, double amount) {
        Auction auction = this.auctionService.findById(auctionId);
        Buyer buyer = this.buyerService.findById(buyerId);
        Bid bid = this.bidRepository.save(new Bid(auction, buyer, amount));
        this.rankerService.rank(auction.getAuctionId(), bid);
        return bid;
    }

    @Override
    public Bid findById(String bidId) {
        return this.bidRepository.findById(bidId).orElseThrow(() -> new RuntimeException("BidId not found"));
    }

    @Override
    public void withdraw(String bidId) {
        Bid bid = this.findById(bidId);
        this.rankerService.derank(bid);
    }

}
