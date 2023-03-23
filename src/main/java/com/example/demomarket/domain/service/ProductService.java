package com.example.demomarket.domain.service;

import com.example.demomarket.domain.Product;
import com.example.demomarket.domain.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;
    public List<Product> getAll(){
        return repository.getAll();
    }
    public Optional<Product> getById(int productId){
        return repository.getById(productId);
    }
    public Optional<List<Product>> getByCategory(int categoryId){
        return repository.getByCategory(categoryId);
    }
    public Product save(Product product){
        return repository.save(product);
    }
    public boolean delete(int productId){
        return getById(productId).map(product ->{
            repository.delete(productId);
            return true;
        }).orElse(false);
    }
}
