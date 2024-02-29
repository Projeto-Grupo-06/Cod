package com.bitequest.BiteQuest.entity.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class RestauranteNaoEncontradoException extends RuntimeException {
    public RestauranteNaoEncontradoException(String id) {
        super("Restaurante com id " + id + " não encontrado");
    }
}
