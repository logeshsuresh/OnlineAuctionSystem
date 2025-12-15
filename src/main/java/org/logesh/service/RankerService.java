package org.logesh.service;

import org.logesh.entity.Bid;

import java.util.Optional;

public interface RankerService {
    void rank(String auctionId, Bid bid);
    void derank(Bid bid);
    Optional<Bid> getHighestBid(String auctionId);
}
