package com.minsait.SistemaFinanceiro.dtos.emprestimo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.minsait.SistemaFinanceiro.enumerators.Relacionamento;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ReadEmprestimoDto {
    private Long id;

    private BigDecimal valorInicial;

    private BigDecimal valorFinal;

    private Relacionamento relacionamento;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataInicial;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataFinal;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getValorInicial() {
        return valorInicial;
    }

    public void setValorInicial(BigDecimal valorInicial) {
        this.valorInicial = valorInicial;
    }

    public BigDecimal getValorFinal() {
        return valorFinal;
    }

    public void setValorFinal(BigDecimal valorFinal) {
        this.valorFinal = valorFinal;
    }

    public Relacionamento getRelacionamento() {
        return relacionamento;
    }

    public void setRelacionamento(Relacionamento relacionamento) {
        this.relacionamento = relacionamento;
    }

    public LocalDate getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(LocalDate dataInicial) {
        this.dataInicial = dataInicial;
    }

    public LocalDate getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(LocalDate dataFinal) {
        this.dataFinal = dataFinal;
    }
}
