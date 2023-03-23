package com.example.demomarket.persistency.mapper;

import com.example.demomarket.domain.PurchaseItem;
import com.example.demomarket.persistency.entities.CompraProducto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel="spring", uses={ProductMapper.class})
public interface PurchaseItemMapper {
    @Mappings({
            @Mapping(source="id.idProducto", target="productId"),
            @Mapping(source="cantidad", target="quantity"),
            @Mapping(source="estado", target="active"),
    })
    PurchaseItem toPurchaseItem(CompraProducto producto);
    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target="compra", ignore = true),
            @Mapping(target="producto", ignore = true),
            @Mapping(target="id.idCompra", ignore = true)
    })
    CompraProducto toCompraProducto(PurchaseItem item);
}
