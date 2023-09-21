package com.projeto.barbearia.agendamento.pessoa.funcionario.dto;

import com.projeto.barbearia._utils.Util;
import com.projeto.barbearia.agendamento.pessoa.funcionario.entidade.Funcionario;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FuncionarioDTO {

    private Long id;
    private String nome;
    private String cpf;
    private String telefone;
    private Date dataCadastro;
    private Boolean ativo;
    private String descricaoFuncionario;

    public Funcionario toDomain() {
        return new Funcionario(id, nome, cpf, telefone, dataCadastro, ativo, descricaoFuncionario);
    }

    public List<Funcionario> toDomain(List<FuncionarioDTO> funcionariosDTO) {
        return Util.isDiferenteDeNullEDeVazio(funcionariosDTO) ? funcionariosDTO.stream().map(FuncionarioDTO::toDomain).collect(Collectors.toList()) : new ArrayList<>();
    }

    public static FuncionarioDTO from(Funcionario funcionario) {
        if (funcionario == null) return null;

        FuncionarioDTO funcionarioDTO = new FuncionarioDTO();
        funcionarioDTO.setId(funcionario.getId());
        funcionarioDTO.setNome(funcionario.getNome());
        funcionarioDTO.setCpf(Util.isDiferenteDeNullEDeVazio(funcionarioDTO.getCpf()) ? funcionario.getCpf() : null);
        funcionarioDTO.setTelefone(Util.isDiferenteDeNullEDeVazio(funcionario.getTelefone()) ? funcionario.getTelefone() :  null);
        funcionarioDTO.setDataCadastro(Util.isDiferenteDeNullEDeVazio(funcionario.getDataCadastro()) ? funcionario.getDataCadastro() : null);
        funcionarioDTO.setAtivo(Util.isDiferenteDeNullEDeVazio(funcionario.getAtivo()) ? funcionario.getAtivo() : null);
        funcionarioDTO.setDescricaoFuncionario(Util.isDiferenteDeNullEDeVazio(funcionario.getDescricaoFuncionario()) ? funcionario.getDescricaoFuncionario() : null);

        return funcionarioDTO;
    }

    public static List<FuncionarioDTO> from(List<Funcionario> funcionariosDominio) {
        return Util.isDiferenteDeNullEDeVazio(funcionariosDominio) ? funcionariosDominio.stream().map(FuncionarioDTO::from).collect(Collectors.toList()) : new ArrayList<>();
    }

}
