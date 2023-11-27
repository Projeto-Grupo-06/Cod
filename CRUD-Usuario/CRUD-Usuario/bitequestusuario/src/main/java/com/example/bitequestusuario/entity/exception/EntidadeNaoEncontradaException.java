package com.example.bitequestusuario.entity.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EntidadeNaoEncontradaException extends RuntimeException{
    public EntidadeNaoEncontradaException(String message) {
        super("Entidade %s não encontrada".formatted(message));
    }
}
