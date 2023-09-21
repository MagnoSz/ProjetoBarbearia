package com.projeto.barbearia.loja.cliente.infra.data;

import com.projeto.barbearia._shared.core.base.EntidadeGenerica;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "tb_cliente_loja")
public class ClienteLojaData extends EntidadeGenerica {

    private String nome;
    private String cpf;
    private String telefone;

}
