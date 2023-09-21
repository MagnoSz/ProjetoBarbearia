package com.projeto.barbearia.agendamento.reserva.repository;

import com.projeto.barbearia._shared.core.base.BaseRepository;
import com.projeto.barbearia.agendamento.fidelidade.dto.FidelidadeDTO;
import com.projeto.barbearia.agendamento.reserva.entidade.Reserva;
import com.projeto.barbearia.agendamento.servico.entidade.Servico;

import java.util.Date;
import java.util.List;

public interface ReservaRepository extends BaseRepository<Reserva> {
    List<Reserva> obterReservasDoFuncionarioPorData(Long idFuncionario, Date dataReserva);
    List<String> getHorariosReservadosDasReservas(List<Reserva> reservas);
    List<String> getHorariosFiltrados(List<String> horariosReservados, List<Servico> servicos, Date dataPesquisada);
    FidelidadeDTO obterCountFidelidadeCliente(Long id);
    List<Reserva> listarFiltrado(Long funcionarioId, Date dataReserva);
}
