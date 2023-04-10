package com.minsait.SistemaFinanceiro.mappers;

import com.minsait.SistemaFinanceiro.dtos.cliente.CreateClienteDto;
import com.minsait.SistemaFinanceiro.dtos.cliente.ReadClienteDto;
import com.minsait.SistemaFinanceiro.dtos.cliente.UpdateClienteDto;
import com.minsait.SistemaFinanceiro.models.Cliente;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ClienteMapper {
    ClienteMapper INSTANCE = Mappers.getMapper(ClienteMapper.class);

    ReadClienteDto toReadDto(Cliente cliente);

    Cliente toCliente(CreateClienteDto createClienteDto);

    Cliente toCliente(UpdateClienteDto updateClienteDto);

    List<ReadClienteDto> toReadClientesDto(List<Cliente> clientes);
}
