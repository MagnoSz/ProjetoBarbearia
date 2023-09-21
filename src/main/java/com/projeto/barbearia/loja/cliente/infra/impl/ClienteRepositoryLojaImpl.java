package com.projeto.barbearia.loja.cliente.infra.impl;

import com.projeto.barbearia._shared.core.config.exceptions.NaoEncontradoException;
import com.projeto.barbearia.loja.cliente.ClienteMapperLoja;
import com.projeto.barbearia.loja.cliente.entidade.Cliente;
import com.projeto.barbearia.loja.cliente.infra.ClienteDataRepositoryLoja;
import com.projeto.barbearia.loja.cliente.infra.data.ClienteLojaData;
import com.projeto.barbearia.loja.cliente.repository.ClienteRepositoryLoja;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
@RequiredArgsConstructor
public class ClienteRepositoryLojaImpl implements ClienteRepositoryLoja {

    private final ClienteMapperLoja mapper;
    private final ClienteDataRepositoryLoja repository;

    @Override
    public Optional<Cliente> inserir(Cliente cliente) {
        ClienteLojaData data = mapper.toData(cliente);
        data = repository.save(data);
        return Optional.of(mapper.toDomain(data));
    }

    @Override
    public Optional<Cliente> editar(Cliente cliente) {
        ClienteLojaData data = mapper.toData(cliente);
        data = repository.save(data);
        return Optional.of(mapper.toDomain(data));
    }

    @Override
    public void deletar(Long id) {
        repository.findById(id).ifPresent(repository::delete);
    }

    @Override
    public Optional<Cliente> consultar(Long id) {
        ClienteLojaData data = repository.findById(id).orElseThrow(NaoEncontradoException::new);
        return Optional.of(mapper.toDomain(data));
    }

    @Override
    public List<Cliente> listar() {
        List<ClienteLojaData> clientesData = repository.findAll();
        List<Cliente> clientesDominio = new ArrayList<>();
        clientesData.forEach(clienteLojaData -> clientesDominio.add(mapper.toDomain(clienteLojaData)));
        return clientesDominio;
    }
}
