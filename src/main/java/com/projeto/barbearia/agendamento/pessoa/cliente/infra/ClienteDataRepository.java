package com.projeto.barbearia.agendamento.pessoa.cliente.infra;

import com.projeto.barbearia.agendamento.pessoa.cliente.infra.data.ClienteData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteDataRepository extends JpaRepository<ClienteData, Long> {
}
