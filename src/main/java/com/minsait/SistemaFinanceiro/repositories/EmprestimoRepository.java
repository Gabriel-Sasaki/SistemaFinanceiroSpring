package com.minsait.SistemaFinanceiro.repositories;

import com.minsait.SistemaFinanceiro.models.Emprestimo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmprestimoRepository extends JpaRepository<Emprestimo, Long> {
}
