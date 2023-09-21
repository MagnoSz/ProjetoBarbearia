package com.projeto.barbearia.loja.produto.infra.impl;

import com.projeto.barbearia._shared.core.config.exceptions.NaoEncontradoException;
import com.projeto.barbearia.loja.produto.ProdutoMapper;
import com.projeto.barbearia.loja.produto.entidade.Produto;
import com.projeto.barbearia.loja.produto.infra.ProdutoDataRepository;
import com.projeto.barbearia.loja.produto.infra.data.ProdutoData;
import com.projeto.barbearia.loja.produto.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
@RequiredArgsConstructor
public class ProdutoRepositoryImpl implements ProdutoRepository {

    private final ProdutoMapper mapper;
    private final ProdutoDataRepository repository;

    @Override
    public Optional<Produto> inserir(Produto produto) {
        ProdutoData data = mapper.toData(produto);
        data = repository.save(data);
        return Optional.of(mapper.toDomain(data));
    }

    @Override
    public Optional<Produto> editar(Produto produto) {
        ProdutoData data = mapper.toData(produto);
        data = repository.save(data);
        return Optional.of(mapper.toDomain(data));
    }

    @Override
    public void deletar(Long id) {
        repository.findById(id).ifPresent(repository::delete);
    }

    @Override
    public Optional<Produto> consultar(Long id) {
        ProdutoData data = repository.findById(id).orElseThrow(NaoEncontradoException::new);
        return Optional.of(mapper.toDomain(data));
    }

    @Override
    public List<Produto> listar() {
        List<ProdutoData> produtosData = repository.findAll();
        List<Produto> produtosDominio = new ArrayList<>();
        produtosData.forEach(produtoData -> produtosDominio.add(mapper.toDomain(produtoData)));
        return produtosDominio;
    }

    @Override
    public Optional<String> validarNomeJaUtilizado(Produto produto) {
        return Optional.empty();
    }

}
