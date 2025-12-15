package org.logesh.factory;

import org.logesh.command.Command;
import org.logesh.command.impl.*;
import org.logesh.controller.AuctionController;
import org.logesh.controller.BidController;
import org.logesh.controller.BuyerController;
import org.logesh.controller.SellerController;

public class CommandFactory {

    private final BuyerController buyerController;
    private final SellerController sellerController;
    private final AuctionController auctionController;
    private final BidController bidController;

    public CommandFactory(BuyerController buyerController,
                          SellerController sellerController,
                          AuctionController auctionController,
                          BidController bidController) {
        this.buyerController = buyerController;
        this.sellerController = sellerController;
        this.auctionController = auctionController;
        this.bidController = bidController;
    }

    public Command createCommand(String commandType, String... args) {
        switch (commandType.toUpperCase()) {
            case "ADD_BUYER":
                return new AddBuyerCommand(buyerController, args[0]);

            case "ADD_SELLER":
                return new AddSellerCommand(sellerController, args[0]);

            case "CREATE_AUCTION":
                return new CreateAuctionCommand(
                        auctionController,
                        args[0], // auctionId
                        Double.parseDouble(args[1]), // lowestBid
                        Double.parseDouble(args[2]), // highestBid
                        Double.parseDouble(args[3]), // participationCost
                        args[4] // sellerName
                );

            case "CREATE_BID":
                return new CreateBidCommand(
                        bidController,
                        args[0], // buyerName
                        args[1], // auctionId
                        Double.parseDouble(args[2]) // bidAmount
                );

            case "UPDATE_BID":
                return new UpdateBidCommand(
                        bidController,
                        args[0], // buyerId
                        args[1], // auctionId
                        args[2], // bidId
                        Double.parseDouble(args[3]) // newBidAmount
                );

            case "WITHDRAW_BID":
                return new WithdrawBidCommand(
                        bidController,
                        args[0], // bidId (first parameter - unused in constructor but kept for consistency)
                        args[0]  // bidId (actual parameter used)
                );

            case "CLOSE_AUCTION":
                return new CloseAuctionCommand(auctionController, args[0]);

            default:
                throw new IllegalArgumentException("Unknown command: " + commandType);
        }
    }
}