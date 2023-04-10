package com.minsait.SistemaFinanceiro.enumerators;

import java.math.BigDecimal;

public enum Relacionamento {
    BRONZE {
        @Override
        public BigDecimal getValorFinal(BigDecimal valorInicial, int qtdEmprestimos) {
            return valorInicial.multiply(new BigDecimal("1.8"));
        }
    },
    PRATA {
        @Override
        public BigDecimal getValorFinal(BigDecimal valorInicial, int qtdEmprestimos) {
            if(valorInicial.compareTo(new BigDecimal("5000")) > 0) {
                return valorInicial.multiply(new BigDecimal("1.4"));
            }

            return valorInicial.multiply(new BigDecimal("1.6"));
        }
    },
    OURO {
        @Override
        public BigDecimal getValorFinal(BigDecimal valorInicial, int qtdEmprestimos) {
            if(qtdEmprestimos == 1) {
                return valorInicial.multiply(new BigDecimal("1.2"));
            }

            return valorInicial.multiply(new BigDecimal("1.3"));
        }
    };

    public abstract BigDecimal getValorFinal(BigDecimal valorInicial, int qtdEmprestimos);
}
