package org.logesh.repository.impl;

import org.logesh.entity.Bid;
import org.logesh.repository.RankerRepository;

import java.util.Comparator;
import java.util.Map;
import java.util.Optional;
import java.util.PriorityQueue;

public class InMemoryRankerRepository implements RankerRepository {

    private final Map<String, PriorityQueue<Bid>> bidsRanker;

    public InMemoryRankerRepository(Map<String, PriorityQueue<Bid>> bidsRanker) {
        this.bidsRanker = bidsRanker;
    }

    @Override
    public void rank(String auctionId, Bid bid) {
        PriorityQueue<Bid> auctionBids = this.bidsRanker.computeIfAbsent(
                auctionId,
                k -> new PriorityQueue<>(Comparator.comparingDouble(Bid::getAmount).reversed())
        );
        auctionBids.offer(bid);
    }

    @Override
    public void derank(String auctionId, Bid bid) {
        PriorityQueue<Bid> auctionBids = bidsRanker.get(auctionId);
        if (auctionBids == null || auctionBids.isEmpty()) {
            return;
        }
        auctionBids.remove(bid);
        if (auctionBids.isEmpty()) {
            bidsRanker.remove(auctionId);
        }
    }

    @Override
    public Optional<Bid> getHighestBid(String auctionId) {
        PriorityQueue<Bid> auctionBids = this.bidsRanker.get(auctionId);
        if (auctionBids == null || auctionBids.isEmpty()) {
            return Optional.empty();
        }
        return Optional.ofNullable(auctionBids.peek());
    }

}