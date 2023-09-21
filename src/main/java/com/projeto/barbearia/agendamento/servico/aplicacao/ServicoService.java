package com.projeto.barbearia.agendamento.servico.aplicacao;

import com.projeto.barbearia.agendamento.servico.dto.ServicoDTO;
import com.projeto.barbearia.agendamento.servico.entidade.Servico;
import com.projeto.barbearia.agendamento.servico.repository.ServicoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ServicoService {

    private final ServicoRegras regras;
    private final ServicoRepository repository;

    public Servico inserir(ServicoDTO dto) {
        Servico servico = dto.toDomain();
        regras.aplicarRegrasBeforeInsert(servico);
        return repository.inserir(servico).get();
    }

    public Servico editar(ServicoDTO dto) {
        Servico servico = dto.toDomain();
        regras.aplicarRegrasBeforeUpdate(servico);
        return repository.editar(servico).get();
    }

    public void deletar(Long id) {
        repository.deletar(id);
    }

    public Servico consultar(Long id) {
        return repository.consultar(id).get();
    }

    public List<ServicoDTO> listar(){
        List<Servico> servicosDominio = repository.listar();
        return ServicoDTO.from(servicosDominio);
    }

}
