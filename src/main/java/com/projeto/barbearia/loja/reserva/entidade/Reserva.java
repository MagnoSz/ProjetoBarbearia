package com.projeto.barbearia.loja.reserva.entidade;

import com.projeto.barbearia._shared.core.config.exceptions.RegraNegocioException;
import com.projeto.barbearia.loja.cliente.entidade.Cliente;
import com.projeto.barbearia.loja.produto.entidade.Produto;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Builder
@Getter
@Setter
public class Reserva {

    private Long id;
    private List<Produto> produtos;
    private Cliente cliente;
    private Date dataPedido;

    public Reserva(Long id, List<Produto> produtos, Cliente cliente, Date dataPedido) {
        this.id = id;
        this.produtos = produtos;
        this.cliente = cliente;
        this.dataPedido = dataPedido;
        validar();
    }

    private void validar() {
        if (produtos == null) throw new RegraNegocioException("A reserva deve conter produtos");
        if (cliente == null) throw new RegraNegocioException("A reserva deve conter um cliente");
    }

}
