package com.projeto.barbearia.agendamento.pessoa.cliente.infra.impl;

import com.projeto.barbearia.agendamento.pessoa.cliente.ClienteMapper;
import com.projeto.barbearia.agendamento.pessoa.cliente.entidade.Cliente;
import com.projeto.barbearia.agendamento.pessoa.cliente.infra.ClienteDataRepository;
import com.projeto.barbearia.agendamento.pessoa.cliente.infra.data.ClienteData;
import com.projeto.barbearia.agendamento.pessoa.cliente.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
@RequiredArgsConstructor
public class ClienteRepositoryImpl implements ClienteRepository {

    private final ClienteMapper mapper;
    private final ClienteDataRepository repository;

    @Override
    public Optional<Cliente> inserir(Cliente cliente) {
        ClienteData data = mapper.toData(cliente);
        data = repository.save(data);
        return Optional.of(mapper.toDomain(data));
    }

    @Override
    public Optional<Cliente> editar(Cliente cliente) {
        return Optional.empty();
    }

    @Override
    public void deletar(Long id) {

    }

    @Override
    public Optional<Cliente> consultar(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Cliente> listar() {
        return null;
    }
}
