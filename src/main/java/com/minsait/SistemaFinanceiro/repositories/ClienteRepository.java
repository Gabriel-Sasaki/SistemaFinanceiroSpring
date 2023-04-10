package com.minsait.SistemaFinanceiro.repositories;

import com.minsait.SistemaFinanceiro.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, String> {
}
