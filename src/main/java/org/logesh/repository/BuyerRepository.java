package org.logesh.repository;

import org.logesh.entity.Buyer;

public interface BuyerRepository extends ReadRepository<Buyer, String>, WriteRepository<Buyer, String> {
}
