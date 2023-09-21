package com.projeto.barbearia.loja.cliente.infra;

import com.projeto.barbearia.loja.cliente.infra.data.ClienteLojaData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteDataRepositoryLoja extends JpaRepository<ClienteLojaData, Long> {
}
