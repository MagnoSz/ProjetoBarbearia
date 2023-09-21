package com.projeto.barbearia.agendamento.pessoa.funcionario.entidade;

import com.projeto.barbearia._shared.core.config.exceptions.RegraNegocioException;
import com.projeto.barbearia._utils.CPFUtil;
import com.projeto.barbearia._utils.Util;
import com.projeto.barbearia.agendamento.pessoa.Pessoa;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Funcionario extends Pessoa {

    private String descricaoFuncionario;

    public Funcionario(Long id, String nome, String cpf, String telefone, Date dataCadastro, Boolean ativo, String descricaoFuncionario) {
        super(id, nome, cpf, telefone, dataCadastro, ativo);
        this.descricaoFuncionario = descricaoFuncionario;
        validar();
    }

    public Funcionario(Long id) {
        super(id);
    }

    private void validar() {
        if (!CPFUtil.cpfValido(getCpf().replace(".", "").replace("-", ""))) throw new RegraNegocioException("CPF Inválido!");
        if (!Util.isDiferenteDeNullEDeVazio(descricaoFuncionario)) throw new RegraNegocioException("É necessário que o funcionário tenha uma descrição");
    }

}
