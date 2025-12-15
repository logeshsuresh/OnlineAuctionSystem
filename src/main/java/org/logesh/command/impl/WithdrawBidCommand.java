package org.logesh.command.impl;

import org.logesh.command.Command;
import org.logesh.controller.BidController;

public class WithdrawBidCommand implements Command {

    private final BidController bidController;
    private final String bidId;

    public WithdrawBidCommand(BidController bidController, String bidId, String bidId1) {
        this.bidController = bidController;
        this.bidId = bidId1;
    }

    @Override
    public void execute() {
        bidController.withdrawBid(bidId);
        System.out.println(bidId + " bid withdrawn successfully");
    }
    
}