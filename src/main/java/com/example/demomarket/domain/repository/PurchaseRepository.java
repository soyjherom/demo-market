package com.example.demomarket.domain.repository;

import com.example.demomarket.domain.Purchase;

import java.util.List;
import java.util.Optional;

public interface PurchaseRepository {
    Optional<List<Purchase>> getAll();
    Optional<List<Purchase>> getByClient(String clientId);
    Purchase save(Purchase purchase);
}
