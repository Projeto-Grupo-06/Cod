package com.example.bitequestusuario.controller;

import com.example.bitequestusuario.dto.CardapioDTO;
import com.example.bitequestusuario.model.Cardapio;
import com.example.bitequestusuario.service.CardapioService;
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
    public ResponseEntity<Cardapio> adicionarCardapio(@RequestBody CardapioDTO c){
        return ResponseEntity.ok(cardapioService.adicionar(c));
    }
    @PutMapping("/{id}")
    public ResponseEntity<Cardapio> editarCardapio(@RequestBody CardapioDTO c, @PathVariable Long id){
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
