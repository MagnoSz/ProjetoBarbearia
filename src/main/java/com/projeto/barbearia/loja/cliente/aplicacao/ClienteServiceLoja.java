package com.projeto.barbearia.loja.cliente.aplicacao;

import com.projeto.barbearia.loja.cliente.dto.ClienteLojaDTO;
import com.projeto.barbearia.loja.cliente.entidade.Cliente;
import com.projeto.barbearia.loja.cliente.repository.ClienteRepositoryLoja;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteServiceLoja {

    private final ClienteRegrasLoja regras;
    private final ClienteRepositoryLoja repository;

    public Cliente inserir(ClienteLojaDTO dto) {
        Cliente funcionario = dto.toDomain();
        regras.aplicarRegrasBeforeInsert(funcionario);
        return repository.inserir(funcionario).get();
    }

    public Cliente editar(ClienteLojaDTO dto) {
        Cliente cliente = dto.toDomain();
        regras.aplicarRegrasBeforeUpdate(cliente);
        return repository.editar(cliente).get();
    }

    public void deletar(Long id) {
        repository.deletar(id);
    }

    public Cliente consultar(Long id) {
        return repository.consultar(id).get();
    }

    public List<ClienteLojaDTO> listar(){
        List<Cliente> clientesDominio = repository.listar();
        return ClienteLojaDTO.from(clientesDominio);
    }

}
