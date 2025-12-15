package org.logesh.controller;

import org.logesh.entity.Seller;
import org.logesh.service.SellerService;

public class SellerController {

    private final SellerService sellerService;

    public SellerController(SellerService sellerService) {
        this.sellerService = sellerService;
    }

    public Seller createSeller(String userName) {
        return this.sellerService.createSeller(userName);
    }

}
