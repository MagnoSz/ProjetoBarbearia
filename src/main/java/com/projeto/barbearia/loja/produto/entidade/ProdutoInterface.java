package com.projeto.barbearia.loja.produto.entidade;

import java.math.BigDecimal;

public interface ProdutoInterface {
    Long getId();
    String getDescricao();
    Long getQuantidade();
    BigDecimal getValor();
    void setQuantidade(Long quantidade);
}
