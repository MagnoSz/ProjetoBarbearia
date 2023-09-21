package com.projeto.barbearia.loja.reserva.aplicacao;

import com.projeto.barbearia.loja.reserva.dto.ReservaDTO;
import com.projeto.barbearia.loja.reserva.entidade.Reserva;
import com.projeto.barbearia.loja.reserva.repository.ReservaRepositoryLoja;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservaLojaService {

    private final ReservaLojaRegras regras;
    private final ReservaRepositoryLoja repository;

    public Reserva inserir(ReservaDTO dto) {
        Reserva reserva = dto.toDomain();
        regras.aplicarRegrasBeforeInsert(reserva);
        return repository.inserir(reserva).get();
    }

    public Reserva editar(ReservaDTO dto) {
        Reserva reserva = dto.toDomain();
        regras.aplicarRegrasBeforeUpdate(reserva);
        return repository.editar(reserva).get();
    }

    public void deletar(Long id) {
        repository.deletar(id);
    }

    public Reserva consultar(Long id) {
        return repository.consultar(id).get();
    }

    public List<ReservaDTO> listar(){
        List<Reserva> reservasDominio = repository.listar();
        return ReservaDTO.from(reservasDominio);
    }

}
