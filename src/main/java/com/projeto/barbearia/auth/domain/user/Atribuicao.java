package com.projeto.barbearia.auth.domain.user;

import lombok.Getter;

@Getter
public enum Atribuicao {
    ADMIN("ADMIN"),
    EMPLOYEE("EMPLOYEE"),
    USER("USER");

    private String role;

    Atribuicao(String role){
        this.role = role;
    }

}
