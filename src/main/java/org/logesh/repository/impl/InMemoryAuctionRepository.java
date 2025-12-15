package org.logesh.repository.impl;

import org.logesh.entity.Auction;
import org.logesh.repository.AuctionRepository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class InMemoryAuctionRepository implements AuctionRepository {

    private final Map<String, Auction> auctionMap;

    public InMemoryAuctionRepository(Map<String, Auction> auctionMap) {
        this.auctionMap = auctionMap;
    }

    @Override
    public List<Auction> fiindAll() {
        return this.auctionMap.values().stream().toList();
    }

    @Override
    public Optional<Auction> findById(String id) {
        return Optional.of(this.auctionMap.get(id));
    }

    @Override
    public Auction save(Auction auction) {
        return this.auctionMap.put(auction.getAuctionId(), auction);
    }

    @Override
    public void delete(String auctionId) {
        this.auctionMap.remove(auctionId);
    }


}
