package com.minsait.SistemaFinanceiro.services;

import com.minsait.SistemaFinanceiro.models.Cliente;
import com.minsait.SistemaFinanceiro.models.Emprestimo;
import com.minsait.SistemaFinanceiro.repositories.EmprestimoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class EmprestimoService {
    private EmprestimoRepository repository;

    @Autowired
    public EmprestimoService(EmprestimoRepository repository) {
        this.repository = repository;
    }

    public void postEmprestimo(Cliente cliente, ClienteService clienteService, Emprestimo emprestimo) {
        setValorFinal(emprestimo, cliente);

        emprestimo.setCpfCliente(cliente);
        cliente.addEmprestimos(emprestimo);
        clienteService.putCliente(cliente.getCpf(), cliente);
    }

    public void deleteEmprestimo(Long id, String cpf, ClienteService clienteService) {
        Cliente cliente = clienteService.getClienteByCpf(cpf);
        Emprestimo emprestimo = cliente.getEmprestimos().stream().filter(emp -> emp.getId().equals(id))
                .findFirst().orElse(null);

        cliente.getEmprestimos().remove(emprestimo);
        clienteService.putCliente(cpf, cliente);

        this.repository.deleteById(id);
    }

    public boolean ehValido(Cliente cliente, BigDecimal valorEmprestimo) {
        return cliente.getTotalEmprestimos().add(valorEmprestimo).compareTo(cliente.getRendimentoMensal()
                .multiply(new BigDecimal(10))) <= 0;
    }

    public void setValorFinal(Emprestimo emprestimo, Cliente cliente) {
        emprestimo.setValorFinal(emprestimo.getRelacionamento()
                .getValorFinal(emprestimo.getValorInicial(), cliente.qtdEmprestimos()));
    }
}
