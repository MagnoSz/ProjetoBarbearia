package com.projeto.barbearia.loja.produto.controller;

import com.projeto.barbearia.loja.produto.aplicacao.ProdutoService;
import com.projeto.barbearia.loja.produto.dto.ProdutoDTO;
import com.projeto.barbearia.loja.produto.entidade.Produto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/produto")
public class ProdutoController {

    private final ProdutoService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Long incluir(@RequestBody ProdutoDTO dto) {
        return service.inserir(dto).getId();
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public Long editar(@RequestBody ProdutoDTO dto) {
        return service.editar(dto).getId();
    }

    @Transactional(readOnly = true)
    @GetMapping("{id}")
    public ProdutoDTO consultar(@PathVariable Long id) {
        Produto produto = service.consultar(id);
        return new ProdutoDTO().from(produto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }

    @GetMapping
    public List<ProdutoDTO> listar() {
        return service.listar();
    }

}
