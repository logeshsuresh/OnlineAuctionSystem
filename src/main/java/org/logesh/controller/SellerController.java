package org.logesh.controller;

import org.logesh.service.SellerService;

public class SellerController {

    private final SellerService sellerService;

    public SellerController(SellerService sellerService) {
        this.sellerService = sellerService;
    }

}
