package com.projeto.barbearia.agendamento.horarios.dto;

import com.projeto.barbearia.agendamento.pessoa.funcionario.entidade.Funcionario;
import com.projeto.barbearia.agendamento.servico.entidade.Servico;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class PesquisaHorariosDTO {
    private List<Servico> servicos;
    private Funcionario profissional;
    private Date data;
}
