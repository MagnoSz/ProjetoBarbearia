package com.projeto.barbearia.loja.cliente.aplicacao;

import com.projeto.barbearia._shared.core.base.Regras;
import com.projeto.barbearia.loja.cliente.entidade.Cliente;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ClienteRegrasLoja implements Regras<Cliente> {
    @Override
    public void aplicarRegrasBeforeInsert(Cliente cliente) {

    }

    @Override
    public void aplicarRegrasBeforeUpdate(Cliente cliente) {

    }
}
