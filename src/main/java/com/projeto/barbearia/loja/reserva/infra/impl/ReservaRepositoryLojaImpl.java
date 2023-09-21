package com.projeto.barbearia.loja.reserva.infra.impl;

import com.projeto.barbearia._shared.core.base.BaseRepositoryImpl;
import com.projeto.barbearia._shared.core.config.exceptions.NaoEncontradoException;
import com.projeto.barbearia.loja.reserva.ReservaMapperLoja;
import com.projeto.barbearia.loja.reserva.entidade.Reserva;
import com.projeto.barbearia.loja.reserva.infra.ReservaDataRepositoryLoja;
import com.projeto.barbearia.loja.reserva.infra.data.ReservaLojaData;
import com.projeto.barbearia.loja.reserva.repository.ReservaRepositoryLoja;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
@RequiredArgsConstructor
public class ReservaRepositoryLojaImpl extends BaseRepositoryImpl implements ReservaRepositoryLoja {

    private final ReservaMapperLoja mapper;
    private final ReservaDataRepositoryLoja repository;

    @Override
    public Optional<Reserva> inserir(Reserva reserva) {
        ReservaLojaData data = mapper.toData(reserva);
        data = repository.save(data);
        return Optional.of(mapper.toDomain(data));
    }

    @Override
    public Optional<Reserva> editar(Reserva reserva) {
        ReservaLojaData data = mapper.toData(reserva);
        data = repository.save(data);
        return Optional.of(mapper.toDomain(data));
    }

    @Override
    public void deletar(Long id) {
        repository.findById(id).ifPresent(repository::delete);
    }

    @Override
    public Optional<Reserva> consultar(Long id) {
        ReservaLojaData data = repository.findById(id).orElseThrow(NaoEncontradoException::new);
        return Optional.of(mapper.toDomain(data));
    }

    @Override
    public List<Reserva> listar() {
        List<ReservaLojaData> servicosData = repository.findAll();
        List<Reserva> servicosDominio = new ArrayList<>();
        servicosData.forEach(produtoData -> servicosDominio.add(mapper.toDomain(produtoData)));
        return servicosDominio;
    }
}
