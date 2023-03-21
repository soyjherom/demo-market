package com.example.demomarket.persistency.crud;

import com.example.demomarket.persistency.entities.Producto;
import org.springframework.data.repository.CrudRepository;

public interface ProductoCrudRepository extends CrudRepository<Producto, Integer> {
}
