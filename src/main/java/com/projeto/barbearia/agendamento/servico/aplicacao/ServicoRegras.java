package com.projeto.barbearia.agendamento.servico.aplicacao;

import com.projeto.barbearia._shared.core.base.Regras;
import com.projeto.barbearia.agendamento.servico.entidade.Servico;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ServicoRegras implements Regras<Servico> {
    @Override
    public void aplicarRegrasBeforeInsert(Servico servico) {

    }

    @Override
    public void aplicarRegrasBeforeUpdate(Servico servico) {

    }
}
