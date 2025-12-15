package org.logesh.service;

import org.logesh.entity.Seller;

public interface SellerService {
    Seller createSeller(String userName);
    Seller findById(String sellerId);
}
