package com.projeto.barbearia.agendamento.reserva.infra;

import com.projeto.barbearia.agendamento.reserva.infra.data.ReservaData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservaDataRepository extends JpaRepository<ReservaData, Long> {
}
