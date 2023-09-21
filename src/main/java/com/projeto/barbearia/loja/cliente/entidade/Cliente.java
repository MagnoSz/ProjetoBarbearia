package com.projeto.barbearia.loja.cliente.entidade;

import com.projeto.barbearia._shared.core.config.exceptions.RegraNegocioException;
import com.projeto.barbearia._utils.CPFUtil;
import com.projeto.barbearia._utils.Util;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Cliente {

    private Long id;
    private String nome;
    private String cpf;
    private String telefone;
    private Date dataCadastro;
    private Boolean ativo;

    public Cliente(Long id, String nome, String cpf, String telefone, Date dataCadastro, Boolean ativo) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.dataCadastro = dataCadastro;
        this.ativo = ativo;
        validar();
    }

    public Cliente(Long id) {
        this.id = id;
    }

    private void validar() {
        if (Util.isDiferenteDeNullEDeVazio(cpf) && !CPFUtil.cpfValido(getCpf().replace(".", "").replace("-", ""))) throw new RegraNegocioException("CPF Inválido!");
    }

}
