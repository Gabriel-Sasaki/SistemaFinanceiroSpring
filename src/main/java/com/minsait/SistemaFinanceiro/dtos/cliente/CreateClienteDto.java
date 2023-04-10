package com.minsait.SistemaFinanceiro.dtos.cliente;

import com.minsait.SistemaFinanceiro.models.Endereco;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

public class CreateClienteDto {
    @Id
    @NotBlank(message = "O cpf é obrigatório!")
    @CPF(message = "O formato do CPF está inválido!")
    private String cpf;

    @NotBlank(message = "O nome é obrigatório!")
    private String nome;

    @NotBlank(message = "O telefone é obrigatório!")
    @Pattern(regexp = "^[0-9]{10}[0-9]?$", message = "O telefone precisa estar no padrão DDD + número, sem parenteses e traços!")
    private String telefone;

    @Positive(message = "O rendimento mensal precisa ser positivo!")
    @NumberFormat(style = NumberFormat.Style.CURRENCY)
    private BigDecimal rendimentoMensal;

    @NotNull(message = "O endereço é obrigatório!")
    private Endereco endereco;

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

    public BigDecimal getRendimentoMensal() {
        return rendimentoMensal;
    }

    public void setRendimentoMensal(BigDecimal rendimentoMensal) {
        this.rendimentoMensal = rendimentoMensal;
    }
}
