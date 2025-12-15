package org.logesh.repository;

import org.logesh.entity.Bid;

import java.util.Optional;

public interface RankerRepository {
    void rank(String auctionId, Bid bid);
    void derank(String auctionId, Bid bid);
    Optional<Bid> getHighestBid(String auctionId);
}
