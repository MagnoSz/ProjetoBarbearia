package com.projeto.barbearia.agendamento.pessoa.cliente.entidade;

import com.projeto.barbearia._shared.core.config.exceptions.RegraNegocioException;
import com.projeto.barbearia._utils.CPFUtil;
import com.projeto.barbearia.agendamento.pessoa.Pessoa;

import java.util.Date;

public class Cliente extends Pessoa {

    public Cliente(Long id, String nome, String cpf, String telefone, Date dataCadastro, Boolean ativo) {
        super(id, nome, cpf, telefone, dataCadastro, ativo);
        validar();
    }

    public Cliente(Long id) {
        super(id);
    }

    private void validar() {
        if (!CPFUtil.cpfValido(getCpf().replace(".", "").replace("-", ""))) throw new RegraNegocioException("CPF Inválido!");
    }

}
