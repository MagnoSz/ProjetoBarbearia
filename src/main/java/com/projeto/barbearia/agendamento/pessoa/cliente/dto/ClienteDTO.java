package com.projeto.barbearia.agendamento.pessoa.cliente.dto;

import com.projeto.barbearia._utils.Util;
import com.projeto.barbearia.agendamento.pessoa.cliente.entidade.Cliente;
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
public class ClienteDTO {

    private Long id;
    private String nome;
    private String cpf;
    private String telefone;
    private Date dataCadastro;
    private Boolean ativo;

    public Cliente toDomain() {
        return new Cliente(id, nome, cpf, telefone, dataCadastro, ativo);
    }

    public List<Cliente> toDomain(List<ClienteDTO> clientesDTO) {
        return Util.isDiferenteDeNullEDeVazio(clientesDTO) ? clientesDTO.stream().map(ClienteDTO::toDomain).collect(Collectors.toList()) : new ArrayList<>();
    }

    public static ClienteDTO from(Cliente cliente) {
        if (cliente == null) return null;

        ClienteDTO clienteDTO = new ClienteDTO();
        clienteDTO.setId(cliente.getId());
        clienteDTO.setNome(cliente.getNome());
        clienteDTO.setCpf(cliente.getCpf());
        clienteDTO.setTelefone(cliente.getTelefone());
        clienteDTO.setDataCadastro(cliente.getDataCadastro());
        clienteDTO.setAtivo(cliente.getAtivo());

        return clienteDTO;
    }

    public static List<ClienteDTO> from(List<Cliente> clientesDominio) {
        return Util.isDiferenteDeNullEDeVazio(clientesDominio) ? clientesDominio.stream().map(ClienteDTO::from).collect(Collectors.toList()) : new ArrayList<>();
    }

}
