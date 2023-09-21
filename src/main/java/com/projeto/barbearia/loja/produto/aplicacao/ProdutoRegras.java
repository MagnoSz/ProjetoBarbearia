package com.projeto.barbearia.loja.produto.aplicacao;

import com.projeto.barbearia._shared.core.base.Regras;
import com.projeto.barbearia.loja.produto.entidade.Produto;
import com.projeto.barbearia.loja.produto.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProdutoRegras implements Regras {

    private final ProdutoRepository produtoRepository;

    public void execute(Produto produto) {
        validarNomeJaUtilizado(produto);
    }

    @Override
    public void aplicarRegrasBeforeInsert(Object o) {
        validarNomeJaUtilizado((Produto) o);
    }

    @Override
    public void aplicarRegrasBeforeUpdate(Object o) {


    }

    private void validarNomeJaUtilizado(Produto produto) {
        produtoRepository.validarNomeJaUtilizado(produto);
    }

}
