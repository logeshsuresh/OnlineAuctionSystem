package org.logesh.service.impl;

import org.logesh.entity.Seller;
import org.logesh.repository.SellerRepository;
import org.logesh.service.SellerService;

public class SellerServiceImpl implements SellerService {

    private final SellerRepository sellerRepository;

    public SellerServiceImpl(SellerRepository sellerRepository) {
        this.sellerRepository = sellerRepository;
    }

    @Override
    public Seller createSeller(String userName) {
        Seller seller = new Seller(userName);
        return this.sellerRepository.save(seller);
    }

    @Override
    public Seller findById(String sellerId) {
        return this.sellerRepository.findById(sellerId).orElseThrow(() -> new RuntimeException("SellerId not found"));
    }

}
