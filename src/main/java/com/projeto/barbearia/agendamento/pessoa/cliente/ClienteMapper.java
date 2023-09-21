package com.projeto.barbearia.agendamento.pessoa.cliente;

import com.projeto.barbearia._shared.core.base.BaseMapper;
import com.projeto.barbearia.agendamento.pessoa.cliente.entidade.Cliente;
import com.projeto.barbearia.agendamento.pessoa.cliente.infra.data.ClienteData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ClienteMapper implements BaseMapper<ClienteData, Cliente> {

    @Override
    public Cliente toDomain(ClienteData clienteData) {
        return new Cliente(
                clienteData.getId(),
                clienteData.getNome(),
                clienteData.getCpf(),
                clienteData.getTelefone(),
                clienteData.getDataCadastro(),
                clienteData.getAtivo()
        );
    }

    @Override
    public ClienteData toData(Cliente cliente) {
        ClienteData clienteData = new ClienteData();
        clienteData.setId(cliente.getId());
        clienteData.setNome(cliente.getNome());
        clienteData.setCpf(cliente.getCpf());
        clienteData.setTelefone(cliente.getCpf());
        clienteData.setDataCadastro(cliente.getDataCadastro());
        clienteData.setAtivo(cliente.getAtivo());
        return clienteData;
    }
}
