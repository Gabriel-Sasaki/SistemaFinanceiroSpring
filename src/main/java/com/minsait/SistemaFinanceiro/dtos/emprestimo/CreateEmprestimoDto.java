package com.minsait.SistemaFinanceiro.dtos.emprestimo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.minsait.SistemaFinanceiro.enumerators.Relacionamento;

import javax.validation.constraints.Future;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

public class CreateEmprestimoDto {
    @NotNull(message = "O valor inicial é obrigatório!")
    private BigDecimal valorInicial;

    @NotNull(message = "O relacionamento é obrigatório!")
    private Relacionamento relacionamento;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @FutureOrPresent(message = "A data inicial precisa ser igual ou superior a data atual!")
    private LocalDate dataInicial;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Future(message = "A data final precisa ser superior a data atual!")
    private LocalDate dataFinal;

    public BigDecimal getValorInicial() {
        return valorInicial;
    }

    public void setValorInicial(BigDecimal valorInicial) {
        this.valorInicial = valorInicial;
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
