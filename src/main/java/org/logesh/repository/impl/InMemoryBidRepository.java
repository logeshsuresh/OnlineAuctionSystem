package org.logesh.repository.impl;

import org.logesh.entity.Bid;
import org.logesh.repository.BidRepository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class InMemoryBidRepository implements BidRepository {

    private final Map<String, Bid> bidMap;

    public InMemoryBidRepository(Map<String, Bid> bidMap) {
        this.bidMap = bidMap;
    }

    @Override
    public List<Bid> fiindAll() {
        return this.bidMap.values().stream().toList();
    }

    @Override
    public Optional<Bid> findById(String id) {
        return Optional.of(this.bidMap.get(id));
    }

    @Override
    public Bid save(Bid bid) {
        return this.bidMap.put(bid.getBidId(), bid);
    }

    @Override
    public void delete(String bidId) {
        this.bidMap.remove(bidId);
    }


}
