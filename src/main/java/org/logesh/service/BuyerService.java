package org.logesh.service;

import org.logesh.entity.Buyer;

public interface BuyerService {
    Buyer createBuyer(String userName);
    Buyer findById(String buyerId);
}
