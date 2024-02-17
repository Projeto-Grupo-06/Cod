package com.bitequest.BiteQuest.entity.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CardapioNaoEncontradoException extends RuntimeException{
    public CardapioNaoEncontradoException(String message) {
        super("Cardápio %s não encontrado".formatted(message));
    }
}
