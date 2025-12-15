package org.logesh.repository.impl;

import org.logesh.entity.Buyer;
import org.logesh.repository.BuyerRepository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class InMemoryBuyerRepositoryImpl implements BuyerRepository {

    private final Map<String, Buyer> buyerMap;

    public InMemoryBuyerRepositoryImpl(Map<String, Buyer> buyerMap) {
        this.buyerMap = buyerMap;
    }

    @Override
    public List<Buyer> fiindAll() {
        return this.buyerMap.values().stream().toList();
    }

    @Override
    public Optional<Buyer> findById(String id) {
        return Optional.of(this.buyerMap.get(id));
    }

    @Override
    public Buyer save(Buyer buyer) {
        return this.buyerMap.put(buyer.getUserId(), buyer);
    }

    @Override
    public void delete(String buyerId) {
        this.buyerMap.remove(buyerId);
    }

}
