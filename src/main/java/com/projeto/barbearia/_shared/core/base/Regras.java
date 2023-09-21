package com.projeto.barbearia._shared.core.base;

public interface Regras<DOMINIO> {
    void aplicarRegrasBeforeInsert(DOMINIO dominio);
    void aplicarRegrasBeforeUpdate(DOMINIO dominio);
}
