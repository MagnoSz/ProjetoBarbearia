package com.projeto.barbearia.loja.produto.aplicacao;

import com.projeto.barbearia.loja.produto.dto.ProdutoDTO;
import com.projeto.barbearia.loja.produto.entidade.Produto;
import com.projeto.barbearia.loja.produto.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProdutoService {
    private final ProdutoRegras regras;
    private final ProdutoRepository repository;

    public Produto inserir(ProdutoDTO dto) {
        Produto produto = dto.toDomain();
        regras.execute(produto);
        regras.aplicarRegrasBeforeInsert(produto);
        return repository.inserir(produto).get();
    }

    public Produto editar(ProdutoDTO dto) {
        Produto produto = dto.toDomain();
        regras.execute(produto);
        regras.aplicarRegrasBeforeUpdate(produto);
        return repository.editar(produto).get();
    }

    public void deletar(Long id) {
        repository.deletar(id);
    }

    public Produto consultar(Long id) {
        return repository.consultar(id).get();
    }

    public List<ProdutoDTO> listar(){
        List<Produto> produtosDominio = repository.listar();
        return ProdutoDTO.from(produtosDominio);
    }

}
