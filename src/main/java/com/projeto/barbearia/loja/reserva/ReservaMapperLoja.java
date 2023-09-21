package com.projeto.barbearia.loja.reserva;

import com.projeto.barbearia._shared.core.base.BaseMapper;
import com.projeto.barbearia.loja.cliente.ClienteMapperLoja;
import com.projeto.barbearia.loja.produto.ProdutoMapper;
import com.projeto.barbearia.loja.reserva.entidade.Reserva;
import com.projeto.barbearia.loja.reserva.infra.data.ReservaLojaData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ReservaMapperLoja implements BaseMapper<ReservaLojaData, Reserva> {

    private final ClienteMapperLoja clienteMapperLoja;
    private final ProdutoMapper produtoMapper;

    @Override
    public Reserva toDomain(ReservaLojaData reservaLojaData) {
        return Reserva.builder()
                .id(reservaLojaData.getId())
                .cliente(this.clienteMapperLoja.toDomain(reservaLojaData.getClienteLojaData()))
                .produtos(this.produtoMapper.toDomain(reservaLojaData.getProdutos()))
                .dataPedido(reservaLojaData.getDataPedido())
                .build();
    }

    public List<Reserva> toDomain(List<ReservaLojaData> reservasData) {
        return reservasData.stream().map(this::toDomain).collect(Collectors.toList());
    }

    @Override
    public ReservaLojaData toData(Reserva reserva) {
        if (reserva == null) return null;

        ReservaLojaData reservaLojaData = new ReservaLojaData();
        reservaLojaData.setId(reserva.getId());
        reservaLojaData.setClienteLojaData(this.clienteMapperLoja.toData(reserva.getCliente()));
        reservaLojaData.setProdutos(this.produtoMapper.toData(reserva.getProdutos()));
        reservaLojaData.setDataPedido(reservaLojaData.getDataPedido());

        return reservaLojaData;
    }

    public List<ReservaLojaData> toData(List<Reserva> reservasDominio) {
        return reservasDominio.stream().map(this::toData).collect(Collectors.toList());
    }

}
