package com.projeto.barbearia.agendamento.reserva.aplicacao;

import com.projeto.barbearia._shared.core.base.Regras;
import com.projeto.barbearia.agendamento.reserva.entidade.Reserva;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ReservaRegras implements Regras<Reserva> {
    @Override
    public void aplicarRegrasBeforeInsert(Reserva reserva) {

    }

    @Override
    public void aplicarRegrasBeforeUpdate(Reserva reserva) {

    }
}
