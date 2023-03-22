package com.example.demomarket.persistency.crud;

import com.example.demomarket.persistency.entities.Producto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductoCrudRepository extends CrudRepository<Producto, Integer> {
    List<Producto> findByIdCategoriaOrderByNombreAsc(Integer idCategoria);
    Optional<List<Producto>> findByCantidadStockLessThanAndEstado(Integer cantidadStock, Boolean estado);

    @Query(value = "SELECT * FROM productos WHERE nombre = ?1", nativeQuery = true)
    List<Producto> findByProductName(String productName);
}
