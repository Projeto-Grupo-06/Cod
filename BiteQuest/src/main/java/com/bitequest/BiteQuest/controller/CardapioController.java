package com.bitequest.BiteQuest.controller;

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

    @Autowired
    private CardapioService cardapioService;

    @GetMapping
    public ResponseEntity<?> listarCardapios(){
        try {
            List<Cardapio> cardapios = cardapioService.todosCardapios();
            if (cardapios.isEmpty()){
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.ok(cardapios);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao listar cardápios: " + e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> cardapioPorId(@PathVariable Long id){
        try {
            Cardapio cardapio = cardapioService.cardapioPorId(id);
            if (cardapio == null) {
                throw new CardapioNaoEncontradoException(id);
            }
            return ResponseEntity.ok(cardapio);
        } catch (CardapioNaoEncontradoException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao buscar cardápio: " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarCardapio(@PathVariable Long id){
        try {
            cardapioService.deletarCardapio(id);
            return ResponseEntity.ok("Cardápio deletado com sucesso");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao deletar cardápio: " + e.getMessage());
        }
    }
}

