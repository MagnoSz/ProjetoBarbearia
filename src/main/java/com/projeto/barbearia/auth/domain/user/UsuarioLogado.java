package com.projeto.barbearia.auth.domain.user;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;
import java.util.List;

public class UsuarioLogado {

    private static final String ROLE = "ROLE_";
    private static final Atribuicao ATRIBUICAO_ADMIN = Atribuicao.ADMIN;
    private static final Atribuicao ATRIBUICAO_EMPLOYEE = Atribuicao.EMPLOYEE;
    private static final Atribuicao ATRIBUICAO_USER = Atribuicao.USER;

    public static Collection<? extends GrantedAuthority> getListAuthorities(Atribuicao role) {
        if (role == ATRIBUICAO_ADMIN) return List.of(getSimpleGrantedAuthority(ATRIBUICAO_ADMIN), getSimpleGrantedAuthority(ATRIBUICAO_EMPLOYEE), getSimpleGrantedAuthority(ATRIBUICAO_USER));
        if (role == ATRIBUICAO_EMPLOYEE) return List.of(getSimpleGrantedAuthority(ATRIBUICAO_EMPLOYEE), getSimpleGrantedAuthority(ATRIBUICAO_USER));
        else return List.of(getSimpleGrantedAuthority(ATRIBUICAO_USER));
    }

    public static SimpleGrantedAuthority getSimpleGrantedAuthority(Atribuicao atribuicao) {
        return new SimpleGrantedAuthority(ROLE + atribuicao.getRole());
    }

}
