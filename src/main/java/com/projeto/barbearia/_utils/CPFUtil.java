package com.projeto.barbearia._utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;

public class CPFUtil {

    public static boolean cpfValido(String CPF){
        CPF = CPF.replace(".", "").replace("-", "");

        if(!isDiferenteDeNullEDeVazio(CPF)) return false;
        if(verificaSeTodosDigitosSaoIguais(CPF)) return false;
        if(!tamanhoDaStringEstaCorreto(CPF)) return false;

        char dig10,
                dig11;
        int sm, i, r, num, peso;
        try {
            sm = 0; peso = 10; for (i=0; i<9; i++) {
                num = (int)(CPF.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }
            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                dig10 = '0';
            else dig10 = (char)(r + 48);
            sm = 0;
            peso = 11;
            for(i=0; i<10; i++) {
                num = (int)(CPF.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }
            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                dig11 = '0';
            else dig11 = (char)(r + 48);
            if ((dig10 == CPF.charAt(9)) && (dig11 == CPF.charAt(10)))
                return(true);
            else
                return(false);
        } catch (InputMismatchException erro) {
            return(false);
        }
    }

    public static boolean verificaSeTodosDigitosSaoIguais(String CPF){
        return CPF.equals("00000000000") || CPF.equals("11111111111") || CPF.equals("22222222222") ||
                CPF.equals("33333333333") || CPF.equals("44444444444") || CPF.equals("55555555555")
                || CPF.equals("66666666666") || CPF.equals("77777777777") || CPF.equals("88888888888")
                || CPF.equals("99999999999");
    }

    public static boolean tamanhoDaStringEstaCorreto (String CPF){
        if (CPF.length() != 11) return false;
        return true;
    }

    public static Boolean isDiferenteDeNullEDeVazio(Object objeto) {
        return (objeto != null && !objeto.equals(""));
    }

    public static Date formatarStringParaDate(String dataEmString){
        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");

        try {
            Date data = formatador.parse(dataEmString);
            return data;
        } catch (ParseException e) {
            System.out.println("Data inválida");
        }
        return null;
    }

}
