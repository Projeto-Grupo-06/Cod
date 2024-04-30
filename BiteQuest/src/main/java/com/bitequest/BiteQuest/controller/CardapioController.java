package com.bitequest.BiteQuest.controller;

import com.bitequest.BiteQuest.controller.Erro.ErroResponse;
import com.bitequest.BiteQuest.entity.Cardapio;
import com.bitequest.BiteQuest.entity.exception.CardapioNaoEncontradoException;
import com.bitequest.BiteQuest.service.CardapioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cardapios")
public class CardapioController {

    private final CardapioService cardapioService;

    @Autowired
    public CardapioController(CardapioService cardapioService) {
        this.cardapioService = cardapioService;
    }

    @ExceptionHandler(CardapioNaoEncontradoException.class)
    public ResponseEntity<ErroResponse> handleCardapioNotFoundException(CardapioNaoEncontradoException ex) {
        ErroResponse erro = new ErroResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage());
        return new ResponseEntity<>(erro, HttpStatus.NOT_FOUND);
    }

    @GetMapping
    public ResponseEntity<List<Cardapio>> listarCardapios() throws Exception {
        List<Cardapio> cardapios = cardapioService.todosCardapios();
        if (cardapios.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(cardapios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cardapio> cardapioPorId(@PathVariable Long id) throws CardapioNaoEncontradoException {
        Cardapio cardapio = cardapioService.cardapioPorId(id);
        return ResponseEntity.ok(cardapio);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCardapio(@PathVariable Long id) throws Exception {
        cardapioService.deletarCardapio(id);
        return ResponseEntity.noContent().build();
    }
}

