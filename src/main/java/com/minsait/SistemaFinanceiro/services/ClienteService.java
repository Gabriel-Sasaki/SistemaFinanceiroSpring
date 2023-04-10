package com.minsait.SistemaFinanceiro.services;

import com.minsait.SistemaFinanceiro.models.Cliente;
import com.minsait.SistemaFinanceiro.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {
    private ClienteRepository repository;

    @Autowired
    public ClienteService(ClienteRepository repository) {
        this.repository = repository;
    }

    public void postCliente(Cliente cliente) {
        repository.save(cliente);
    }

    public List<Cliente> getAllClientes() {
        return repository.findAll();
    }

    public Cliente getClienteByCpf(String cpf) {
        return this.repository.findById(cpf).get();
    }

    public void putCliente(String cpf, Cliente cliente) {
        cliente.setCpf(cpf);
        this.repository.save(cliente);
    }

    public void deleteCliente(String cpf) {
        this.repository.deleteById(cpf);
    }
}
