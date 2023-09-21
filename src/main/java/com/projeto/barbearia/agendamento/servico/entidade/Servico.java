package com.projeto.barbearia.agendamento.servico.entidade;

import com.projeto.barbearia._shared.core.config.exceptions.RegraNegocioException;
import com.projeto.barbearia._utils.Util;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor
public class Servico {

    private Long id;
    private BigDecimal valor;
    private String descricao;
    private Long tempo;

    public Servico(Long id, BigDecimal valor, String descricao, Long tempo) {
        this.id = id;
        this.valor = valor;
        this.descricao = descricao;
        this.tempo = tempo;
        validar();
    }

    public Servico(Long id) {
        this.id = id;
    }

    private void validar() {
        if (Util.isDiferenteDeNullEDeVazio(valor) && valor.compareTo(BigDecimal.ZERO) <= 0) throw new RegraNegocioException("Valor não deve ser menor ou igual a zero") ;
        if (Util.isDiferenteDeNullEDeVazio(tempo) && tempo <= 0) throw new RegraNegocioException("Tempo deve ser maior que zero");
    }

}
