package com.projeto.barbearia._utils;

public class Util {

    public static Boolean isDiferenteDeNullEDeVazio(Object objeto) {
        return (objeto != null && !objeto.equals(""));
    }

    public static boolean isEmpty(final String value) {
        return value != null && value.isEmpty();
    }

}
