package com.minsait.SistemaFinanceiro.models;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Cliente {
    @Id
    private String cpf;

    private String nome;

    private String telefone;

    private BigDecimal rendimentoMensal;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ENDERECO_ID", referencedColumnName = "id")
    private Endereco endereco;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Emprestimo> emprestimos = new ArrayList<>();

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

    public List<Emprestimo> getEmprestimos() {
        return emprestimos;
    }

    public void setEmprestimos(List<Emprestimo> emprestimos) {
        this.emprestimos = emprestimos;
    }

    public BigDecimal getRendimentoMensal() {
        return rendimentoMensal;
    }

    public void setRendimentoMensal(BigDecimal rendimentoMensal) {
        this.rendimentoMensal = rendimentoMensal;
    }

    public void addEmprestimos(Emprestimo emprestimo) {
        emprestimos.add(emprestimo);
    }

    public BigDecimal getTotalEmprestimos() {
        BigDecimal total = new BigDecimal("0.0");
        for(Emprestimo emp : emprestimos) {
            total = total.add(emp.getValorFinal());
        }
        return total;
    }

    public int qtdEmprestimos() {
        return emprestimos.size();
    }
}
