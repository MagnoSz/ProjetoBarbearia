package com.projeto.barbearia.agendamento.servico.infra.data;

import com.projeto.barbearia._shared.core.base.EntidadeGenerica;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "tb_servico")
public class ServicoData extends EntidadeGenerica {

    private BigDecimal valor;
    private String descricao;
    private Long tempo;

}
