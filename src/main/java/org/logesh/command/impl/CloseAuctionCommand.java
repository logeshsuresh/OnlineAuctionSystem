package org.logesh.command.impl;

import org.logesh.command.Command;
import org.logesh.controller.AuctionController;
import org.logesh.dto.CloseAuctionResponseDto;

public class CloseAuctionCommand implements Command {

    private final AuctionController auctionController;
    private final String auctionId;

    public CloseAuctionCommand(AuctionController auctionController, String auctionId) {
        this.auctionController = auctionController;
        this.auctionId = auctionId;
    }

    @Override
    public void execute() {
        CloseAuctionResponseDto response = auctionController.closeAuction(auctionId);
        if (response.getBuyer() != null) {
            System.out.println("Auction closed. Winner: " + response.getBuyer().getUserName() + " with bid: " + response.getWinningBid().getAmount());
        } else {
            System.out.println("Auction closed with no winner");
        }
    }

}