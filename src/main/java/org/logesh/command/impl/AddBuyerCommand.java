package org.logesh.command.impl;

import org.logesh.command.Command;
import org.logesh.controller.BuyerController;
import org.logesh.entity.Buyer;

public class AddBuyerCommand implements Command {

    private final BuyerController buyerController;
    private final String name;

    public AddBuyerCommand(BuyerController buyerController, String name) {
        this.buyerController = buyerController;
        this.name = name;
    }

    @Override
    public void execute() {
        Buyer buyer = buyerController.createBuyer(name);
        System.out.println("Buyer added successfully: " + buyer.getUserName());
    }

}