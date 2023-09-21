package com.projeto.barbearia.agendamento.pessoa.funcionario.controller;

import com.projeto.barbearia.agendamento.pessoa.funcionario.aplicacao.FuncionarioService;
import com.projeto.barbearia.agendamento.pessoa.funcionario.dto.FuncionarioDTO;
import com.projeto.barbearia.agendamento.pessoa.funcionario.entidade.Funcionario;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/funcionario")
public class FuncionarioController {

    private final FuncionarioService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Long incluir(@RequestBody FuncionarioDTO dto) {
        return service.inserir(dto).getId();
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public Long editar(@RequestBody FuncionarioDTO dto) {
        return service.editar(dto).getId();
    }

    @Transactional(readOnly = true)
    @GetMapping("{id}")
    public FuncionarioDTO consultar(@PathVariable Long id) {
        Funcionario funcionario = service.consultar(id);
        return new FuncionarioDTO().from(funcionario);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }

    @GetMapping
    public List<FuncionarioDTO> listar() {
        return service.listar();
    }

}
