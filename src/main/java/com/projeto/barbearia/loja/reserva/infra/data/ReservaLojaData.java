package com.projeto.barbearia.loja.reserva.infra.data;

import com.projeto.barbearia._shared.core.base.EntidadeGenerica;
import com.projeto.barbearia.loja.cliente.infra.data.ClienteLojaData;
import com.projeto.barbearia.loja.produto.infra.data.ProdutoData;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "tb_reserva_loja")
public class ReservaLojaData extends EntidadeGenerica {

    @ManyToOne
    @JoinColumn(name = "id_cliente", referencedColumnName = "id")
    private ClienteLojaData clienteLojaData;

    @LazyCollection(LazyCollectionOption.FALSE)
    @ManyToMany
    @JoinTable(name = "tb_reserva_produtos", joinColumns = {@JoinColumn(name = "id_reserva")}, inverseJoinColumns = {@JoinColumn(name = "id_produto")})
    private List<ProdutoData> produtos;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dataPedido;

}
