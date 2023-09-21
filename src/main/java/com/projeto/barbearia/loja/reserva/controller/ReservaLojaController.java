package com.projeto.barbearia.loja.reserva.controller;

import com.projeto.barbearia.loja.reserva.aplicacao.ReservaLojaService;
import com.projeto.barbearia.loja.reserva.dto.ReservaDTO;
import com.projeto.barbearia.loja.reserva.entidade.Reserva;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reserva/loja")
public class ReservaLojaController {

    private final ReservaLojaService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Long incluir(@RequestBody ReservaDTO dto) {
        return service.inserir(dto).getId();
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public Long editar(@RequestBody ReservaDTO dto) {
        return service.editar(dto).getId();
    }

    @Transactional(readOnly = true)
    @GetMapping("{id}")
    public ReservaDTO consultar(@PathVariable Long id) {
        Reserva reserva = service.consultar(id);
        return new ReservaDTO().from(reserva);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }

    @GetMapping
    public List<ReservaDTO> listar() {
        return service.listar();
    }

}
