package com.bitequest.BiteQuest.controller;

import com.bitequest.BiteQuest.entity.Cardapio;
import com.bitequest.BiteQuest.entity.exception.CardapioNaoEncontradoException;
import com.bitequest.BiteQuest.service.CardapioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cardapios")
public class CardapioController {

    @Autowired
    private CardapioService cardapioService;

    @GetMapping
    public ResponseEntity<List<Cardapio>> listarCardapios(){
        List<Cardapio> cardapios = cardapioService.todosCardapios();
        if (cardapios.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(cardapios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cardapio> cardapioPorId(@PathVariable Long id){
        Cardapio cardapio = cardapioService.cardapioPorId(id);
        if (cardapio == null) {
            throw new CardapioNaoEncontradoException(id);
        }
        return ResponseEntity.ok(cardapio);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCardapio(@PathVariable Long id){
        cardapioService.deletarCardapio(id);
        return ResponseEntity.noContent().build();
    }
}
