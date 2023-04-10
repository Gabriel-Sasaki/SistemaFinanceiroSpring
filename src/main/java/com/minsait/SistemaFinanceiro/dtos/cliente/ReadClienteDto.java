package com.minsait.SistemaFinanceiro.dtos.cliente;

import com.minsait.SistemaFinanceiro.dtos.emprestimo.ReadEmprestimoDto;
import com.minsait.SistemaFinanceiro.models.Emprestimo;
import com.minsait.SistemaFinanceiro.models.Endereco;
import com.minsait.SistemaFinanceiro.mappers.EmprestimoMapper;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ReadClienteDto {
    private String cpf;

    private String nome;

    private String telefone;

    private BigDecimal rendimentoMensal;

    private Endereco endereco;

    private List<ReadEmprestimoDto> emprestimos = new ArrayList<>();

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public List<ReadEmprestimoDto> getEmprestimos() {
        return emprestimos;
    }

    public void setEmprestimos(List<Emprestimo> emprestimos) {
        this.emprestimos = EmprestimoMapper.INSTANCE.toReadEmprestimos(emprestimos);
    }

    public BigDecimal getRendimentoMensal() {
        return rendimentoMensal;
    }

    public void setRendimentoMensal(BigDecimal rendimentoMensal) {
        this.rendimentoMensal = rendimentoMensal;
    }
}
