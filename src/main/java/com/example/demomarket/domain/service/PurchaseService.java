package com.example.demomarket.domain.service;

import com.example.demomarket.domain.Purchase;
import com.example.demomarket.domain.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PurchaseService {
    @Autowired
    private PurchaseRepository repository;
    public Optional<List<Purchase>> getAll(){
        return repository.getAll();
    }
    public Optional<List<Purchase>> getByClientId(String clientId){
        return repository.getByClient(clientId);
    }
    public Purchase save(Purchase purchase){
        return repository.save(purchase);
    }
}
