package com.bitequest.BiteQuest.controller;

import com.bitequest.BiteQuest.cardapio.CardapioCreateRequestDto;
import com.bitequest.BiteQuest.cardapio.CardapioResponseDto;
import com.bitequest.BiteQuest.entity.Cardapio;
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
        return ResponseEntity.ok(cardapio);
    }
    @PostMapping
    public ResponseEntity<Cardapio> adicionarCardapio(@RequestBody CardapioCreateRequestDto c){
        return ResponseEntity.ok(cardapioService.adicionar(c));
    }
    @PutMapping("/{id}")
    public ResponseEntity<Cardapio> editarCardapio(@RequestBody CardapioResponseDto c, @PathVariable Long id){
        return ResponseEntity.ok(cardapioService.editar(c,id));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCardapio(@PathVariable Long id){
        cardapioService.deletarCardapio(id);
        return ResponseEntity.noContent().build();
    }
    @PatchMapping("/{id}")
    public ResponseEntity<Void> atualizarVersao(@RequestParam String versao, @PathVariable Long id){
        cardapioService.atualizarVersao(id,versao);
        return ResponseEntity.noContent().build();
    }
}