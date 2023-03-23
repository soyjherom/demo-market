package com.example.demomarket.persistency.crud;

import com.example.demomarket.persistency.entities.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface ClienteCrudRepository extends CrudRepository<Cliente, Integer> {
}
