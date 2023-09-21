package com.projeto.barbearia.loja.reserva.aplicacao;

import com.projeto.barbearia._shared.core.base.Regras;
import com.projeto.barbearia.loja.reserva.entidade.Reserva;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ReservaLojaRegras implements Regras<Reserva> {
    @Override
    public void aplicarRegrasBeforeInsert(Reserva reserva) {

    }

    @Override
    public void aplicarRegrasBeforeUpdate(Reserva reserva) {

    }
}
