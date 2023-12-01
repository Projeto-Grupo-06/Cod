package com.bitequest.BiteQuest.entity.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
@ResponseStatus(HttpStatus.NOT_FOUND)
public class EntidadeNaoEncontradaExceptionn extends RuntimeException{
    public EntidadeNaoEncontradaExceptionn(String message) {
        super("Entidade %s não encontrada".formatted(message));
    }
}
