package org.logesh.controller;

import org.logesh.entity.Buyer;
import org.logesh.service.BuyerService;

public class BuyerController {

    private final BuyerService buyerService;

    public BuyerController(BuyerService buyerService) {
        this.buyerService = buyerService;
    }

    public Buyer createBuyer(String userName) {
        return this.buyerService.createBuyer(userName);
    }

}
