package com.projeto.barbearia.loja.cliente;

import com.projeto.barbearia.loja.cliente.entidade.Cliente;
import com.projeto.barbearia.loja.cliente.infra.data.ClienteLojaData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ClienteMapperLoja {

    public Cliente toDomain(ClienteLojaData clienteLojaData) {
        return new Cliente(
                clienteLojaData.getId(),
                clienteLojaData.getNome(),
                clienteLojaData.getCpf(),
                clienteLojaData.getTelefone(),
                clienteLojaData.getDataCadastro(),
                clienteLojaData.getAtivo()
        );
    }

    public ClienteLojaData toData(Cliente cliente) {
        ClienteLojaData clienteLojaData = new ClienteLojaData();
        clienteLojaData.setId(cliente.getId());
        clienteLojaData.setNome(cliente.getNome());
        clienteLojaData.setCpf(cliente.getCpf());
        clienteLojaData.setTelefone(cliente.getTelefone());
        clienteLojaData.setDataCadastro(cliente.getDataCadastro());
        clienteLojaData.setAtivo(cliente.getAtivo());
        return clienteLojaData;
    }

}
