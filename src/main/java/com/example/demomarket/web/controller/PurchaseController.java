package com.example.demomarket.web.controller;

import com.example.demomarket.domain.Product;
import com.example.demomarket.domain.Purchase;
import com.example.demomarket.domain.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/purchases")
public class PurchaseController {
    @Autowired
    private PurchaseService service;
    @GetMapping("/all")
    public ResponseEntity<List<Purchase>> getAll(){
        return service.getAll()
                .map(purchases -> new ResponseEntity<>(purchases, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @GetMapping("/client/{id}")
    public ResponseEntity<List<Purchase>> getByCategory(@PathVariable("id") String clientId){
        return service.getByClientId(clientId)
                .map(purchases -> new ResponseEntity<>(purchases, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @PostMapping("/save")
    public ResponseEntity<Purchase> save(@RequestBody Purchase purchase){
        return new ResponseEntity<>(service.save(purchase), HttpStatus.CREATED);
    }
}
