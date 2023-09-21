package com.projeto.barbearia.loja.cliente.controller;

import com.projeto.barbearia.loja.cliente.aplicacao.ClienteServiceLoja;
import com.projeto.barbearia.loja.cliente.dto.ClienteLojaDTO;
import com.projeto.barbearia.loja.cliente.entidade.Cliente;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cliente/loja")
public class ClienteControllerLoja {

    private final ClienteServiceLoja service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Long incluir(@RequestBody ClienteLojaDTO dto) {
        return service.inserir(dto).getId();
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public Long editar(@RequestBody ClienteLojaDTO dto) {
        return service.editar(dto).getId();
    }

    @Transactional(readOnly = true)
    @GetMapping("{id}")
    public ClienteLojaDTO consultar(@PathVariable Long id) {
        Cliente cliente = service.consultar(id);
        return new ClienteLojaDTO().from(cliente);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }

    @GetMapping
    public List<ClienteLojaDTO> listar() {
        return service.listar();
    }

}
