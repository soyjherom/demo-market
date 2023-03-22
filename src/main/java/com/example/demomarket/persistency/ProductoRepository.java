package com.example.demomarket.persistency;

import com.example.demomarket.domain.Product;
import com.example.demomarket.domain.repository.ProductRepository;
import com.example.demomarket.persistency.crud.ProductoCrudRepository;
import com.example.demomarket.persistency.entities.Producto;
import com.example.demomarket.persistency.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public class ProductoRepository implements ProductRepository {
    @Autowired
    private ProductoCrudRepository crudRepository;
    @Autowired
    private ProductMapper mapper;

    public List<Producto> getByName(String nombreProducto){
        return crudRepository.findByProductName(nombreProducto);
    }

    @Override
    public List<Product> getAll() {
        List<Producto> productos = (List<Producto>) crudRepository.findAll();
        return mapper.toProducts(productos);
    }

    @Override
    public Optional<List<Product>> getByCategory(int categoryId) {
        List<Producto> productos = crudRepository.findByIdCategoriaOrderByNombreAsc(categoryId);
        return Optional.of(mapper.toProducts(productos));
    }

    @Override
    public Optional<List<Product>> getScarseProducts(int quantity) {
        Optional<List<Producto>> productos = crudRepository.findByCantidadStockLessThanAndEstado(quantity, true);
        return productos.map(prods->mapper.toProducts(prods));
    }

    @Override
    public Optional<Product> getById(int productId) {
        return crudRepository.findById(productId).map(prod->mapper.toProduct(prod));
    }

    @Override
    public Product save(Product product) {
        Producto producto = mapper.toProducto(product);
        return mapper.toProduct(crudRepository.save(producto));
    }

    @Override
    public void delete(int productId) {
        Optional<Producto> producto = crudRepository.findById(productId);
        producto.ifPresent(prod->crudRepository.delete(prod));
    }
}
