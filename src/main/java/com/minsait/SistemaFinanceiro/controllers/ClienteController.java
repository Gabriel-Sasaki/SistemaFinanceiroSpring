package com.minsait.SistemaFinanceiro.controllers;

import com.minsait.SistemaFinanceiro.dtos.cliente.CreateClienteDto;
import com.minsait.SistemaFinanceiro.dtos.cliente.ReadClienteDto;
import com.minsait.SistemaFinanceiro.dtos.cliente.UpdateClienteDto;
import com.minsait.SistemaFinanceiro.dtos.emprestimo.CreateEmprestimoDto;
import com.minsait.SistemaFinanceiro.dtos.emprestimo.ReadEmprestimoDto;
import com.minsait.SistemaFinanceiro.models.Cliente;
import com.minsait.SistemaFinanceiro.models.Emprestimo;
import com.minsait.SistemaFinanceiro.mappers.ClienteMapper;
import com.minsait.SistemaFinanceiro.mappers.EmprestimoMapper;
import com.minsait.SistemaFinanceiro.services.ClienteService;
import com.minsait.SistemaFinanceiro.services.EmprestimoService;
import com.minsait.SistemaFinanceiro.services.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/clientes")
@CrossOrigin(origins = "*")
public class ClienteController {
    private ClienteService clienteService;
    private EnderecoService enderecoService;

    @Autowired
    public ClienteController(ClienteService clienteService, EnderecoService enderecoService) {
        this.clienteService = clienteService;
        this.enderecoService = enderecoService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Cliente> postCliente(@Valid @RequestBody CreateClienteDto clienteDto) {
        Cliente cliente = ClienteMapper.INSTANCE.toCliente(clienteDto);

        enderecoService.saveEndereco(cliente.getEndereco());
        clienteService.postCliente(cliente);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{cpf}")
                .buildAndExpand(cliente.getCpf())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<ReadClienteDto>> getAllClientes() {
        List<ReadClienteDto> clienteDtos = ClienteMapper.INSTANCE
                .toReadClientesDto(clienteService.getAllClientes());

        return ResponseEntity.ok().body(clienteDtos);
    }

    @GetMapping("{cpf}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ReadClienteDto> getClienteByCpf(@Valid @PathVariable String cpf) {
        ReadClienteDto clienteDto = ClienteMapper.INSTANCE.toReadDto(clienteService.getClienteByCpf(cpf));

        return ResponseEntity.ok().body(clienteDto);
    }

    @PutMapping("{cpf}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void putCliente(@Valid @PathVariable String cpf, @Valid @RequestBody UpdateClienteDto clienteDto) {
        Cliente cliente = ClienteMapper.INSTANCE.toCliente(clienteDto);
        clienteService.putCliente(cpf, cliente);
    }

    @DeleteMapping("{cpf}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCliente(@Valid @PathVariable String cpf) {
        clienteService.deleteCliente(cpf);
    }
}
