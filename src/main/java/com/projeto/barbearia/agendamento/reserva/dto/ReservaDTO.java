package com.projeto.barbearia.agendamento.reserva.dto;

import com.projeto.barbearia._utils.Util;
import com.projeto.barbearia.agendamento.pessoa.cliente.dto.ClienteDTO;
import com.projeto.barbearia.agendamento.pessoa.cliente.entidade.Cliente;
import com.projeto.barbearia.agendamento.pessoa.funcionario.dto.FuncionarioDTO;
import com.projeto.barbearia.agendamento.pessoa.funcionario.entidade.Funcionario;
import com.projeto.barbearia.agendamento.reserva.entidade.Reserva;
import com.projeto.barbearia.agendamento.servico.dto.ServicoDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReservaDTO {

    private Long id;
    private ClienteDTO cliente;
    private FuncionarioDTO funcionario;
    private List<ServicoDTO> servicos;
    private Date dataInicial;
    private Date dataFim;

    public Reserva toDomain() {
        return new Reserva(
                id,
                Util.isDiferenteDeNullEDeVazio(cliente.getId()) ? new Cliente(cliente.getId()) : null,
                Util.isDiferenteDeNullEDeVazio(funcionario.getId()) ? new Funcionario(funcionario.getId()) : null,
                ServicoDTO.toDomain(servicos),
                dataInicial,
                dataFim
        );
    }

    public static List<Reserva> toDomain(List<ReservaDTO> reservasDTO) {
        return Util.isDiferenteDeNullEDeVazio(reservasDTO) ? reservasDTO.stream().map(ReservaDTO::toDomain).collect(Collectors.toList()) : new ArrayList<>();
    }

    public static ReservaDTO from(Reserva reserva) {
        if (reserva == null) return null;

        ReservaDTO reservaDTO = new ReservaDTO();
        reservaDTO.setId(reserva.getId());
        reservaDTO.setCliente(ClienteDTO.from(reserva.getCliente()));
        reservaDTO.setFuncionario(FuncionarioDTO.from(reserva.getFuncionario()));
        reservaDTO.setServicos(ServicoDTO.from(reserva.getServicos()));
        reservaDTO.setDataInicial(reserva.getDataInicial());
        reservaDTO.setDataFim(reserva.getDataFim());

        return reservaDTO;
    }

    public static List<ReservaDTO> from(List<Reserva> reservasDominio) {
        return Util.isDiferenteDeNullEDeVazio(reservasDominio) ? reservasDominio.stream().map(ReservaDTO::from).collect(Collectors.toList()) : new ArrayList<>();
    }

}
