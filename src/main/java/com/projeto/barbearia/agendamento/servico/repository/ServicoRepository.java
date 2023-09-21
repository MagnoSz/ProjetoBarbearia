package com.projeto.barbearia.agendamento.servico.repository;

import com.projeto.barbearia._shared.core.base.BaseRepository;
import com.projeto.barbearia.agendamento.servico.entidade.Servico;

import java.util.Optional;

public interface ServicoRepository extends BaseRepository<Servico> {
    Optional<String> validarNomeJaUtilizado(Servico servico);
}
