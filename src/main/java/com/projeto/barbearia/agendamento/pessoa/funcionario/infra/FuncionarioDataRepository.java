package com.projeto.barbearia.agendamento.pessoa.funcionario.infra;

import com.projeto.barbearia.agendamento.pessoa.funcionario.infra.data.FuncionarioData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionarioDataRepository extends JpaRepository<FuncionarioData, Long> {
}
