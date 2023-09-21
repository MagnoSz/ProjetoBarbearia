package com.projeto.barbearia.agendamento.servico.infra;

import com.projeto.barbearia.agendamento.servico.infra.data.ServicoData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicoDataRepository extends JpaRepository<ServicoData, Long> {
}
