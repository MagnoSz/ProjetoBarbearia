package com.projeto.barbearia.agendamento.reserva.infra.impl;

import com.projeto.barbearia._shared.core.base.BaseRepositoryImpl;
import com.projeto.barbearia._shared.core.config.exceptions.NaoEncontradoException;
import com.projeto.barbearia._utils.DateUtil;
import com.projeto.barbearia.agendamento.fidelidade.dto.FidelidadeDTO;
import com.projeto.barbearia.agendamento.horarios.entidade.HorariosDisponiveis;
import com.projeto.barbearia.agendamento.pessoa.cliente.infra.data.ClienteData;
import com.projeto.barbearia.agendamento.pessoa.funcionario.infra.data.FuncionarioData;
import com.projeto.barbearia.agendamento.reserva.ReservaMapper;
import com.projeto.barbearia.agendamento.reserva.entidade.Reserva;
import com.projeto.barbearia.agendamento.reserva.entidade.StatusReservaEnum;
import com.projeto.barbearia.agendamento.reserva.infra.ReservaDataRepository;
import com.projeto.barbearia.agendamento.reserva.infra.data.ReservaData;
import com.projeto.barbearia.agendamento.reserva.repository.ReservaRepository;
import com.projeto.barbearia.agendamento.servico.entidade.Servico;
import jakarta.persistence.Tuple;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Repository
@Transactional
@RequiredArgsConstructor
public class ReservaRepositoryImpl extends BaseRepositoryImpl implements ReservaRepository {

    private final ReservaMapper mapper;
    private final ReservaDataRepository repository;

    @Override
    public Optional<Reserva> inserir(Reserva reserva) {
        ReservaData data = mapper.toData(reserva);
        data = repository.save(data);
        return Optional.of(mapper.toDomain(data));
    }

    @Override
    public Optional<Reserva> editar(Reserva reserva) {
        ReservaData data = mapper.toData(reserva);
        data = repository.save(data);
        return Optional.of(mapper.toDomain(data));
    }

    @Override
    public void deletar(Long id) {
        repository.findById(id).ifPresent(repository::delete);
    }

    @Override
    public Optional<Reserva> consultar(Long id) {
        ReservaData data = repository.findById(id).orElseThrow(NaoEncontradoException::new);
        return Optional.of(mapper.toDomain(data));
    }

    @Override
    public List<Reserva> listar() {
        List<ReservaData> reservasData = repository.findAll();
        List<Reserva> reservasDominio = new ArrayList<>();
        reservasData.forEach(reservaData -> reservasDominio.add(mapper.toDomain(reservaData)));
        return reservasDominio;
    }

    @Override
    public List<Reserva> obterReservasDoFuncionarioPorData(Long idFuncionario, Date dataReserva) {
        final CriteriaBuilder builder = em.getCriteriaBuilder();
        final CriteriaQuery<Tuple> query = builder.createTupleQuery();
        final Root<ReservaData> root = query.from(ReservaData.class);
        final Join<ReservaData, FuncionarioData> rootFuncionario = root.join("funcionario");

        query.select(builder.tuple(
                root.get("dataInicial").alias("dataInicial"),
                root.get("dataFim").alias("dataFim")
        ));

        Date dataInicial = DateUtil.converterDateInicioDia(dataReserva);
        Date dataFinal = DateUtil.converterDateFimDia(dataReserva);

        query.where(
                builder.equal(rootFuncionario.get("id"), idFuncionario),
                builder.between(root.get("dataInicial"), dataInicial, dataFinal),
                builder.equal(root.get("statusReserva"), StatusReservaEnum.RESERVADO)
        );

        return mapper.toDomain(this.executeQueryAndTransforResult(query, ReservaData.class));
    }

    public List<String> getHorariosReservadosDasReservas(List<Reserva> reservas) {
        List<String> horariosReservados = new ArrayList<>();
        for (Reserva reserva: reservas) {
            Calendar inicio = DateUtil.getCalendarDate(reserva.getDataInicial());
            Calendar fim = DateUtil.getCalendarDate(reserva.getDataFim());
            Calendar temp = (Calendar) inicio.clone();
            temp.add(Calendar.MINUTE, 30);

            horariosReservados.add(DateUtil.getStringHorario(inicio));
            while (temp.before(fim)) {
                horariosReservados.add(DateUtil.getStringHorario(temp));
                temp.add(Calendar.MINUTE, 30);
            }
        }
        return horariosReservados;
    }

    public List<String> getHorariosFiltrados(List<String> horariosReservados, List<Servico> servicos, Date dataPesquisada) {
        List<String> horariosDisponiveis = HorariosDisponiveis.getHorarios().stream().filter(horario -> !horariosReservados.contains(horario)).collect(Collectors.toList());

        int qntHorariosNecessarios = getQntHorariosNecessarios(servicos);
        if (qntHorariosNecessarios > 0) {
            List<String> horariosRemocao = horariosDisponiveis.stream()
                    .filter(horario -> {
                        for (int i = 1; i <= qntHorariosNecessarios; i++) {
                            String horarioTemp = HorariosDisponiveis.getNext(horario, i);
                            if (horarioTemp == null || !horariosDisponiveis.contains(horarioTemp)) {
                                return true;
                            }
                        }
                        return false;
                    })
                    .collect(Collectors.toList());
            horariosDisponiveis.removeIf(horariosRemocao::contains);
        }
        return horariosDisponiveis.stream()
                .filter(horario -> !HorariosDisponiveis.getCalendarData(horario, dataPesquisada).getTime().before(DateUtil.getCalendarDate(new Date()).getTime()))
                .collect(Collectors.toList());
    }

    private int getQntHorariosNecessarios(List<Servico> servicos) {
        return (int) Math.ceil((double) servicos.stream().mapToLong(Servico::getTempo).sum()/30)-1;
    }

    public FidelidadeDTO obterCountFidelidadeCliente(Long id) {
        final CriteriaBuilder builder = em.getCriteriaBuilder();
        final CriteriaQuery<Tuple> query = builder.createTupleQuery();
        final Root<Reserva> root = query.from(Reserva.class);

        query.select(builder.tuple(
                root.get("id").alias("id")));

        query.where(builder.equal(root.get("cliente"), id),
                builder.equal(root.get("statusReserva"), StatusReservaEnum.FINALIZADO));

        FidelidadeDTO fidelidadeDTO = new FidelidadeDTO();
        fidelidadeDTO.setIdCliente(id);
        fidelidadeDTO.setCountReservas(this.executeQueryAndTransforResult(query, Reserva.class).size());

        return fidelidadeDTO;
    }

    public List<Reserva> listarFiltrado(Long funcionarioId, Date dataReserva) {
        final CriteriaBuilder builder = em.getCriteriaBuilder();
        final CriteriaQuery<Tuple> query = builder.createTupleQuery();
        final Root<ReservaData> root = query.from(ReservaData.class);
        final Join<ReservaData, ClienteData> rootCliente = root.join("cliente");
        final Join<ReservaData, FuncionarioData> rootFuncionario = root.join("funcionario");

        query.select(builder.tuple(
                root.get("id").alias("id"),

                rootCliente.get("id").alias("cliente.id"),
                rootCliente.get("nome").alias("cliente.nome"),

                rootFuncionario.get("id").alias("funcionario.id"),
                rootFuncionario.get("nome").alias("funcionario.nome"),

                root.get("dataInicial").alias("dataInicial"),
                root.get("dataFim").alias("dataFim"),
                root.get("statusReserva").alias("statusReserva")
        ));

        Date dataInicial = DateUtil.converterDateInicioDia(dataReserva);
        Date dataFinal = DateUtil.converterDateFimDia(dataReserva);

        query.where(
                builder.equal(rootFuncionario.get("id"), funcionarioId),
                builder.between(root.get("dataInicial"), dataInicial, dataFinal),
                builder.equal(root.get("statusReserva"), StatusReservaEnum.RESERVADO)
        );

        return mapper.toDomain(this.executeQueryAndTransforResult(query, ReservaData.class));
    }

}
