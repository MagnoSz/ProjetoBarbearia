package com.projeto.barbearia.agendamento.reserva.entidade;

import com.projeto.barbearia._shared.core.config.exceptions.RegraNegocioException;
import com.projeto.barbearia._utils.Util;
import com.projeto.barbearia.agendamento.pessoa.cliente.entidade.Cliente;
import com.projeto.barbearia.agendamento.pessoa.funcionario.entidade.Funcionario;
import com.projeto.barbearia.agendamento.servico.entidade.Servico;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
public class Reserva {

    private Long id;
    private Cliente cliente;
    private Funcionario funcionario;
    private List<Servico> servicos;
    private Date dataInicial;
    private Date dataFim;

    public Reserva(Long id, Cliente cliente, Funcionario funcionario, List<Servico> servicos, Date dataInicial, Date dataFim) {
        this.id = id;
        this.cliente = cliente;
        this.funcionario = funcionario;
        this.servicos = servicos;
        this.dataInicial = dataInicial;
        this.dataFim = dataFim;
        validar();
    }

    private void validar() {
        if (cliente == null) throw new RegraNegocioException("É necessário que um cliente esteja associado a reserva");
        if (funcionario == null) throw new RegraNegocioException("É necessário que um funcionário esteja associado a reserva");
        if (!Util.isDiferenteDeNullEDeVazio(servicos)) throw new RegraNegocioException("É necessário que a reserva tenha ao menos um serviço");
    }

}
