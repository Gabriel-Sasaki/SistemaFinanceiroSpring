package com.minsait.SistemaFinanceiro.services;

import com.minsait.SistemaFinanceiro.models.Endereco;
import com.minsait.SistemaFinanceiro.repositories.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnderecoService {
    private EnderecoRepository repository;

    @Autowired
    public EnderecoService(EnderecoRepository repository) {
        this.repository = repository;
    }

    public void saveEndereco(Endereco endereco) {
        this.repository.save(endereco);
    }
}
