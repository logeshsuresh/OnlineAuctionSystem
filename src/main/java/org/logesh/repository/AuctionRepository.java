package org.logesh.repository;

import org.logesh.entity.Auction;

public interface AuctionRepository extends ReadRepository<Auction, String>, WriteRepository<Auction, String> {
}
