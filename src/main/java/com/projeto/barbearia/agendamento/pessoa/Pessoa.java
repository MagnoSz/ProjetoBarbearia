package com.projeto.barbearia.agendamento.pessoa;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Builder
@Getter
@Setter
@NoArgsConstructor
public class Pessoa {

    private Long id;
    private String nome;
    private String cpf;
    private String telefone;
    private Date dataCadastro;
    private Boolean ativo;

    public Pessoa(Long id) {
        this.id = id;
    }

    public Pessoa(Long id, String nome, String cpf, String telefone, Date dataCadastro, Boolean ativo) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.dataCadastro = dataCadastro;
        this.ativo = ativo;
    }

}
