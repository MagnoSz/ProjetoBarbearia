package com.projeto.barbearia._shared.core.base;

public interface BaseMapper<DATA, DOMINIO> {
    DOMINIO toDomain(DATA data);
    DATA toData(DOMINIO dominio);
}
