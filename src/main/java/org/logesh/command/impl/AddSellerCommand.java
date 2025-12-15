package org.logesh.command.impl;

import org.logesh.command.Command;
import org.logesh.controller.SellerController;
import org.logesh.entity.Seller;

public class AddSellerCommand implements Command {

    private final SellerController sellerController;
    private final String name;

    public AddSellerCommand(SellerController sellerController, String name) {
        this.sellerController = sellerController;
        this.name = name;
    }

    @Override
    public void execute() {
        Seller seller = sellerController.createSeller(name);
        System.out.println("Seller added successfully: " + seller.getUserName());
    }

}