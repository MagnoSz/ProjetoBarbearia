package com.projeto.barbearia._shared.core.base;

import java.util.List;
import java.util.Optional;

public interface BaseRepository<DOMINIO> {
    Optional<DOMINIO> inserir(DOMINIO dominio);
    Optional<DOMINIO> editar(DOMINIO dominio);
    void deletar(Long id);
    Optional<DOMINIO> consultar(Long id);
    List<DOMINIO> listar();
}
