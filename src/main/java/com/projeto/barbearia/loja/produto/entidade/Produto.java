package com.projeto.barbearia.loja.produto.entidade;

import com.projeto.barbearia._shared.core.config.exceptions.RegraNegocioException;
import com.projeto.barbearia._utils.Util;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Builder
@Getter
@Setter
public class Produto {

    private Long id;
    private BigDecimal valor;
    private String descricao;
    private Long quantidade;

    public Produto(Long id, BigDecimal valor, String descricao, Long quantidade) {
        this.id = id;
        this.valor = valor;
        this.descricao = descricao;
        this.quantidade = quantidade;
        validar();
    }

    public void validar() {
        if (Util.isDiferenteDeNullEDeVazio(valor) && valor.compareTo(BigDecimal.ZERO) <= 0) throw new RegraNegocioException("Valor não deve ser menor ou igual a zero") ;
        if (Util.isDiferenteDeNullEDeVazio(quantidade) && quantidade < 0) throw new RegraNegocioException("Quantidade deve ser maior que zero");
    }

}
