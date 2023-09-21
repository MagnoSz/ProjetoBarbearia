package com.projeto.barbearia._shared.core.config.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@Setter
@AllArgsConstructor
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NaoEncontradoException extends RuntimeException {

    private static final long serialVersionUID = -4506442970006191470L;

    private String mensagem = "erro.registroNaoEncontrado";
    private Object[] args;

    public NaoEncontradoException(){}

    public NaoEncontradoException(String mensagem) {
        this.mensagem = mensagem;
    }

    public NaoEncontradoException(String mensagem, String... args){
        this.mensagem = mensagem;
        this.args = args;
    }

}
