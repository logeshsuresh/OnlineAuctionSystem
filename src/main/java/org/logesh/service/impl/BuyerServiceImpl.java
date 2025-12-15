package org.logesh.service.impl;

import org.logesh.entity.Buyer;
import org.logesh.repository.BuyerRepository;
import org.logesh.service.BuyerService;

public class BuyerServiceImpl implements BuyerService {

    private final BuyerRepository buyerRepository;

    public BuyerServiceImpl(BuyerRepository buyerRepository) {
        this.buyerRepository = buyerRepository;
    }

    @Override
    public Buyer createBuyer(String userName) {
        Buyer buyer = new Buyer(userName);
        return this.buyerRepository.save(buyer);
    }

    @Override
    public Buyer findById(String buyerId) {
        return this.buyerRepository.findById(buyerId).orElseThrow(() -> new RuntimeException("BuyerId not found"));
    }

}
