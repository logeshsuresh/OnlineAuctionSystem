package org.logesh.service.impl;

import org.logesh.entity.Bid;
import org.logesh.repository.RankerRepository;
import org.logesh.service.RankerService;

import java.util.Optional;

public class RankerServiceImpl implements RankerService {

    private final RankerRepository rankerRepository;

    public RankerServiceImpl(RankerRepository rankerRepository) {
        this.rankerRepository = rankerRepository;
    }

    @Override
    public void rank(String auctionId, Bid bid) {
        this.rankerRepository.rank(auctionId, bid);
    }

    @Override
    public void derank(Bid bid) {
        this.rankerRepository.derank(bid.getAuction().getAuctionId(), bid);
    }

    @Override
    public Optional<Bid> getHighestBid(String auctionId) {
        return this.rankerRepository.getHighestBid(auctionId);
    }

}
