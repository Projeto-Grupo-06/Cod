package com.bitequest.BiteQuest.entity.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NaoAutorizadoException extends RuntimeException {
    public NaoAutorizadoException(String message) {
        super("Não autorizado: %s".formatted(message));
    }
}

