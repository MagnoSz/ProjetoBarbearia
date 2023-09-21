package com.projeto.barbearia.agendamento.pessoa.funcionario;

import com.projeto.barbearia._shared.core.base.BaseMapper;
import com.projeto.barbearia.agendamento.pessoa.funcionario.entidade.Funcionario;
import com.projeto.barbearia.agendamento.pessoa.funcionario.infra.data.FuncionarioData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FuncionarioMapper implements BaseMapper<FuncionarioData, Funcionario> {

    @Override
    public Funcionario toDomain(FuncionarioData funcionarioData) {
        return new Funcionario(
                funcionarioData.getId(),
                funcionarioData.getNome(),
                funcionarioData.getCpf(),
                funcionarioData.getTelefone(),
                funcionarioData.getDataCadastro(),
                funcionarioData.getAtivo(),
                funcionarioData.getDescricaoFuncionario()
        );
    }

    @Override
    public FuncionarioData toData(Funcionario funcionario) {
        FuncionarioData funcionarioData = new FuncionarioData();
        funcionarioData.setId(funcionario.getId());
        funcionarioData.setNome(funcionario.getNome());
        funcionarioData.setCpf(funcionario.getCpf());
        funcionarioData.setTelefone(funcionario.getTelefone());
        funcionarioData.setDataCadastro(funcionario.getDataCadastro());
        funcionarioData.setAtivo(funcionario.getAtivo());
        funcionarioData.setDescricaoFuncionario(funcionario.getDescricaoFuncionario());
        return funcionarioData;
    }
}
