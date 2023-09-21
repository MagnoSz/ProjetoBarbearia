package com.projeto.barbearia.loja.cliente.dto;

import com.projeto.barbearia._utils.Util;
import com.projeto.barbearia.loja.cliente.entidade.Cliente;
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
public class ClienteLojaDTO {

    private Long id;
    private String nome;
    private String cpf;
    private String telefone;
    private Date dataCadastro;
    private Boolean ativo;

    public Cliente toDomain() {
        return new Cliente(id, nome, cpf, telefone, dataCadastro, ativo);
    }

    public List<Cliente> toDomain(List<ClienteLojaDTO> clientesDTO) {
        return Util.isDiferenteDeNullEDeVazio(clientesDTO) ? clientesDTO.stream().map(ClienteLojaDTO::toDomain).collect(Collectors.toList()) : new ArrayList<>();
    }

    public static ClienteLojaDTO from(Cliente cliente) {
        if (cliente == null) return null;

        ClienteLojaDTO clienteLojaDTO = new ClienteLojaDTO();
        clienteLojaDTO.setId(cliente.getId());
        clienteLojaDTO.setNome(cliente.getNome());
        clienteLojaDTO.setCpf(cliente.getCpf());
        clienteLojaDTO.setTelefone(cliente.getTelefone());
        clienteLojaDTO.setDataCadastro(cliente.getDataCadastro());
        clienteLojaDTO.setAtivo(cliente.getAtivo());

        return clienteLojaDTO;
    }

    public static List<ClienteLojaDTO> from(List<Cliente> clientesDominio) {
        return Util.isDiferenteDeNullEDeVazio(clientesDominio) ? clientesDominio.stream().map(ClienteLojaDTO::from).collect(Collectors.toList()) : new ArrayList<>();
    }

}
