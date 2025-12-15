# Machine Coding - Online Auction System

## Problem Statement
Build an online auction platform where registered users can sell or bid on products. Sellers create auctions, and buyers participate in them.

## Functional Requirements

### Users
- Buyers can participate in multiple auctions
- Sellers can host auctions and track profit/loss

### Auctions
Each auction has:
- Unique id
- Lowest and highest bid limits
- A seller
- A fixed participation cost (Rs. X) paid by the participating buyer
- The seller receives 20% of the participation cost from each bidder
- The platform receives 80% of the participation cost from each bidder

### Winner Selection
- The highest bid which is unique (placed by one buyer) wins
- If no unique bid exists, no winner is declared

### Seller P&L Calculation
- If winner: `profit_or_loss = winning_bid_amount + (no_of_bidders * 0.2 * participation_cost) - average_of(lowest_bid_amount, highest_bid_limit)`
- If no winner: `profit_or_loss = no_of_bidders * 0.2 * participation_cost`

### (BONUS) Preferred Buyers
- Buyers who participate in more than 2 auctions are preferred buyers
- In case of a tie for the highest unique bid, preferred buyers win
- If multiple preferred buyers tie, fallback to the next unique highest bid

## Commands to Implement

| Command | Description |
|---------|-------------|
| `ADD_BUYER(name)` | Registers a new buyer |
| `ADD_SELLER(name)` | Registers a new seller |
| `CREATE_AUCTION(id, lowestBid, highestBid, participationCost, sellerName)` | Creates a new auction |
| `CREATE_BID(buyerName, auctionId, bidAmount)` | Buyer places a bid |
| `UPDATE_BID(buyerName, auctionId, newBidAmount)` | Updates buyer's bid |
| `WITHDRAW_BID(buyerName, auctionId)` | Withdraws buyer's bid |
| `CLOSE_AUCTION(auctionId)` | Finalizes the auction and announces winner |
| `GET_PROFIT(sellerName, auctionId)` | Displays the seller's profit/loss for the auction |