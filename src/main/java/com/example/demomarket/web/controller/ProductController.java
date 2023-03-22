package com.example.demomarket.web.controller;

import com.example.demomarket.domain.Product;
import com.example.demomarket.domain.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService service;
    @GetMapping("/all")
    public List<Product> getAll(){
        return service.getAll();
    }
    @GetMapping("/{id}")
    public Product getById(@PathVariable("id") int productId){
        return service.getById(productId).orElse(null);
    }
    @GetMapping("/category/{id}")
    public List<Product> getByCategory(@PathVariable("id") int categoryId){
        return service.getByCategory(categoryId).orElse(null);
    }
    @PostMapping("/save")
    public Product save(@RequestBody Product product){
        return service.save(product);
    }
    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable("id") int productId){
        return service.delete(productId);
    }
}
