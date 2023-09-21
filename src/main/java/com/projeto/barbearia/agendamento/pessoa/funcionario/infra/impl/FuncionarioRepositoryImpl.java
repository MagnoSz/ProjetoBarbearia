package com.projeto.barbearia.agendamento.pessoa.funcionario.infra.impl;

import com.projeto.barbearia._shared.core.config.exceptions.NaoEncontradoException;
import com.projeto.barbearia.agendamento.pessoa.funcionario.FuncionarioMapper;
import com.projeto.barbearia.agendamento.pessoa.funcionario.entidade.Funcionario;
import com.projeto.barbearia.agendamento.pessoa.funcionario.infra.FuncionarioDataRepository;
import com.projeto.barbearia.agendamento.pessoa.funcionario.infra.data.FuncionarioData;
import com.projeto.barbearia.agendamento.pessoa.funcionario.repository.FuncionarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
@RequiredArgsConstructor
public class FuncionarioRepositoryImpl implements FuncionarioRepository {

    private final FuncionarioMapper mapper;
    private final FuncionarioDataRepository repository;

    @Override
    public Optional<Funcionario> inserir(Funcionario funcionario) {
        FuncionarioData data = mapper.toData(funcionario);
        data = repository.save(data);
        return Optional.of(mapper.toDomain(data));
    }

    @Override
    public Optional<Funcionario> editar(Funcionario funcionario) {
        FuncionarioData data = mapper.toData(funcionario);
        data = repository.save(data);
        return Optional.of(mapper.toDomain(data));
    }

    @Override
    public void deletar(Long id) {
        repository.findById(id).ifPresent(repository::delete);
    }

    @Override
    public Optional<Funcionario> consultar(Long id) {
        FuncionarioData data = repository.findById(id).orElseThrow(NaoEncontradoException::new);
        return Optional.of(mapper.toDomain(data));
    }

    @Override
    public List<Funcionario> listar() {
        List<FuncionarioData> funcionariosData = repository.findAll();
        List<Funcionario> funcionariosDominio = new ArrayList<>();
        funcionariosData.forEach(funcionarioData -> funcionariosDominio.add(mapper.toDomain(funcionarioData)));
        return funcionariosDominio;
    }
}
