package com.example.demomarket.persistency;

import com.example.demomarket.domain.Purchase;
import com.example.demomarket.domain.repository.PurchaseRepository;
import com.example.demomarket.persistency.crud.CompraCrudRepository;
import com.example.demomarket.persistency.entities.Compra;
import com.example.demomarket.persistency.mapper.PurchaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CompraRepository implements PurchaseRepository {
    @Autowired
    private CompraCrudRepository repository;
    @Autowired
    private PurchaseMapper mapper;
    @Override
    public Optional<List<Purchase>> getAll() {
        return Optional.of(
                mapper.toPurchases(
                        (List<Compra>) repository.findAll()));
    }
    @Override
    public Optional<List<Purchase>> getByClient(String clientId) {
        return repository.findByIdCliente(clientId)
                .map(products -> mapper.toPurchases(products));
    }
    @Override
    public Purchase save(Purchase purchase) {
        Compra compra = mapper.toCompra(purchase);
        compra.getProductos().forEach(producto -> producto.setCompra(compra));
        return mapper.toPurchase(repository.save(compra));
    }
}
