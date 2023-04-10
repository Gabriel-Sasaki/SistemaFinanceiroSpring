package com.minsait.SistemaFinanceiro.mappers;

import com.minsait.SistemaFinanceiro.dtos.emprestimo.CreateEmprestimoDto;
import com.minsait.SistemaFinanceiro.dtos.emprestimo.ReadEmprestimoDto;
import com.minsait.SistemaFinanceiro.models.Emprestimo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface EmprestimoMapper {
    EmprestimoMapper INSTANCE = Mappers.getMapper(EmprestimoMapper.class);

    ReadEmprestimoDto toReadDto(Emprestimo emprestimo);

    Emprestimo toEmprestimo(CreateEmprestimoDto emprestimoDto);

    List<ReadEmprestimoDto> toReadEmprestimos(List<Emprestimo> emprestimos);
}
