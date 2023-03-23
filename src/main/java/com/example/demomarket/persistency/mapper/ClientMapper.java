package com.example.demomarket.persistency.mapper;

import com.example.demomarket.domain.Client;
import com.example.demomarket.persistency.entities.Cliente;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses={CategoryMapper.class})
public interface ClientMapper {
    @Mappings({
            @Mapping(source="nombre", target="name"),
            @Mapping(source="apellidos", target="lastName"),
            @Mapping(source="celular", target="phone"),
            @Mapping(source="direccion", target="address"),
            @Mapping(source="correoElectronico", target="email"),
    })
    Client toClient(Cliente producto);
    List<Client> toClients(List<Cliente> clientes);
    @InheritInverseConfiguration
    @Mapping(target="compras", ignore = true)
    Cliente toCliente(Client client);
}
