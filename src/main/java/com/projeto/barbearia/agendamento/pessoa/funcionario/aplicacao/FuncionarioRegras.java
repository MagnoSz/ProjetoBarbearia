package com.projeto.barbearia.agendamento.pessoa.funcionario.aplicacao;

import com.projeto.barbearia._shared.core.base.Regras;
import com.projeto.barbearia.agendamento.pessoa.funcionario.entidade.Funcionario;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FuncionarioRegras implements Regras<Funcionario> {
    @Override
    public void aplicarRegrasBeforeInsert(Funcionario funcionario) {

    }

    @Override
    public void aplicarRegrasBeforeUpdate(Funcionario funcionario) {

    }
}
