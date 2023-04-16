package com.minsait.SistemaFinanceiro.controllers;

import com.minsait.SistemaFinanceiro.dtos.emprestimo.CreateEmprestimoDto;
import com.minsait.SistemaFinanceiro.mappers.EmprestimoMapper;
import com.minsait.SistemaFinanceiro.models.Cliente;
import com.minsait.SistemaFinanceiro.models.Emprestimo;
import com.minsait.SistemaFinanceiro.services.ClienteService;
import com.minsait.SistemaFinanceiro.services.EmprestimoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("api/v1/clientes/{cpf}/emprestimos")
@CrossOrigin(origins = "https://sistema-financeiro-angular.vercel.app")
public class EmprestimoController {
    private ClienteService clienteService;
    private EmprestimoService emprestimoService;

    public EmprestimoController(ClienteService clienteService, EmprestimoService emprestimoService) {
        this.clienteService = clienteService;
        this.emprestimoService = emprestimoService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Emprestimo> postEmprestimo(@Valid @PathVariable String cpf, @Valid @RequestBody CreateEmprestimoDto emprestimoDto) {
        Emprestimo emprestimo = EmprestimoMapper.INSTANCE.toEmprestimo(emprestimoDto);
        Cliente cliente = clienteService.getClienteByCpf(cpf);

        if(emprestimoService.ehValido(cliente, emprestimo.getValorInicial())) {
            emprestimoService.postEmprestimo(cliente, clienteService, emprestimo);

            URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(emprestimo.getId())
                    .toUri();
            return ResponseEntity.created(location).build();
        }

        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "O seu rendimento mensal não permite a inserção de mais um empréstimo!");
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Emprestimo>> getAllEmprestimos(@Valid @PathVariable String cpf) {
        List<Emprestimo> emprestimos = clienteService.getClienteByCpf(cpf).getEmprestimos();
        return ResponseEntity.ok().body(emprestimos);
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Emprestimo> getByIdEmprestimo(@Valid @PathVariable String cpf, @Valid @PathVariable Long id) {
        Cliente cliente = clienteService.getClienteByCpf(cpf);

        Emprestimo emprestimo = cliente.getEmprestimos().stream().filter(emp -> emp.getId().equals(id))
                .findFirst().orElse(null);

        return ResponseEntity.ok().body(emprestimo);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteEmprestimo(@Valid @PathVariable String cpf, @Valid @PathVariable Long id) {
        emprestimoService.deleteEmprestimo(id, cpf, clienteService);
    }
}
