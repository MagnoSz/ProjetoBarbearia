package com.projeto.barbearia.loja.reserva.infra;

import com.projeto.barbearia.loja.reserva.infra.data.ReservaLojaData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservaDataRepositoryLoja extends JpaRepository<ReservaLojaData, Long> {
}
