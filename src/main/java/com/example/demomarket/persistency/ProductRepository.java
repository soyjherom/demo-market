package com.example.demomarket.persistency;

import com.example.demomarket.persistency.crud.ProductoCrudRepository;
import com.example.demomarket.persistency.entities.Producto;

import java.util.List;
import java.util.Optional;

public class ProductRepository {
    private ProductoCrudRepository crudRepository;

    public List<Producto> getAll(){
        return (List<Producto>) crudRepository.findAll();
    }

    public Producto getOne(Integer idProducto){
        Optional<Producto> producto = crudRepository.findById(idProducto);
        return producto.orElse(null);
    }

    public Producto save(Producto producto){
        return crudRepository.save(producto);
    }

    public boolean remove(Integer id){
        Optional<Producto> result = crudRepository.findById(id);
        Producto producto = result.orElse(null);
        if(producto != null){
            crudRepository.delete(producto);
            return true;
        }
        return false;
    }

    public Producto update(Producto nuevo){
        Optional<Producto> anterior = crudRepository.findById(nuevo.getIdProducto());
        Producto producto = anterior.orElse(null);
        if(producto != null){
            return crudRepository.save(nuevo);
        }
        return null;
    }
}
