package com.projeto.barbearia.agendamento.pessoa.cliente.aplicacao;

import com.projeto.barbearia._shared.core.base.Regras;
import com.projeto.barbearia.agendamento.pessoa.cliente.entidade.Cliente;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ClienteRegras implements Regras<Cliente> {
    @Override
    public void aplicarRegrasBeforeInsert(Cliente cliente) {

    }

    @Override
    public void aplicarRegrasBeforeUpdate(Cliente cliente) {

    }
}
