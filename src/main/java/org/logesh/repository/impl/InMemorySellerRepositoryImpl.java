package org.logesh.repository.impl;

import org.logesh.entity.Seller;
import org.logesh.repository.SellerRepository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class InMemorySellerRepositoryImpl implements SellerRepository {

    private final Map<String, Seller> sellerMap;

    public InMemorySellerRepositoryImpl(Map<String, Seller> sellerMap) {
        this.sellerMap = sellerMap;
    }

    @Override
    public List<Seller> fiindAll() {
        return this.sellerMap.values().stream().toList();
    }

    @Override
    public Optional<Seller> findById(String id) {
        return Optional.of(this.sellerMap.get(id));
    }

    @Override
    public Seller save(Seller seller) {
        return this.sellerMap.put(seller.getUserId(), seller);
    }

    @Override
    public void delete(String sellerId) {
        this.sellerMap.remove(sellerId);
    }

}
