package com.bitequest.BiteQuest.controller;

import com.bitequest.BiteQuest.cardapio.CardapioCreateRequestDto;
import com.bitequest.BiteQuest.entity.Cardapio;
import com.bitequest.BiteQuest.entity.Restaurante;
import com.bitequest.BiteQuest.restaurante.RestauranteCreateRequestDto;
import com.bitequest.BiteQuest.restaurante.RestauranteSimpleResponse;
import com.bitequest.BiteQuest.service.RestauranteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

@RestController
@RequestMapping("/restaurantes")
public class RestauranteController {

    @Autowired
    private RestauranteService restauranteService;

    private Queue<RestauranteCreateRequestDto> filaAdicoes = new LinkedList<>();

    @GetMapping
    public ResponseEntity<List<Restaurante>> listarRestaurantes() {
        List<Restaurante> restaurantes = restauranteService.todosRestaurantes();
        if (restaurantes.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(restaurantes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Restaurante> restaurantePorId(@PathVariable Integer id) {
        Restaurante restaurante = restauranteService.restaurantePorId(id);
        return ResponseEntity.ok(restaurante);
    }

    @PostMapping
    public ResponseEntity<Restaurante> adicionarRestaurante(@Valid @RequestBody RestauranteCreateRequestDto r) {
        // Adiciona a solicitação à fila
        filaAdicoes.add(r);

        // Processa a primeira solicitação na fila
        RestauranteCreateRequestDto requestDto = filaAdicoes.poll();
        Restaurante restaurante = restauranteService.adicionar(requestDto);

        return ResponseEntity.ok(restaurante);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Restaurante> editarRestaurante(@PathVariable Integer id, @RequestBody RestauranteSimpleResponse r) {
        return ResponseEntity.ok(restauranteService.editar(id, r));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarRestaurante(@PathVariable Integer id) {
        restauranteService.deletarRestaurante(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/mapa")
    public ResponseEntity<String> abrirMapaRestaurante(@PathVariable Integer id) {
        Restaurante restaurante = restauranteService.restaurantePorId(id);

        // Obtenha o CEP do restaurante
        String cep = restaurante.getCep();

        // Substitua os espaços por '+' para formar a URL corretamente
        cep = cep.replace(" ", "+");

        // Cria a URL do Google Maps para o CEP
        String urlMapa = "https://www.google.com/maps/search/?api=1&query=" + cep;

        return ResponseEntity.ok(urlMapa);
    }

    @PostMapping("/{idRestaurante}/cardapios")
    public ResponseEntity<Cardapio> adicionarCardapio(@PathVariable Integer idRestaurante, @Valid @RequestBody CardapioCreateRequestDto cardapioDto) {
        Cardapio cardapio = restauranteService.adicionarCardapio(idRestaurante, cardapioDto);
        return ResponseEntity.ok(cardapio);
    }

    @PutMapping("/{idRestaurante}/cardapios/{idCardapio}")
    public ResponseEntity<Cardapio> atualizarCardapio(@PathVariable Integer idRestaurante, @PathVariable Long idCardapio, @Valid @RequestBody CardapioCreateRequestDto cardapioDto) {
        Cardapio cardapio = restauranteService.atualizarCardapio(idRestaurante, idCardapio, cardapioDto);
        return ResponseEntity.ok(cardapio);
    }

    @DeleteMapping("/{idRestaurante}/cardapios/{idCardapio}")
    public ResponseEntity<Void> removerCardapio(@PathVariable Integer idRestaurante, @PathVariable Long idCardapio) {
        restauranteService.removerCardapio(idRestaurante, idCardapio);
        return ResponseEntity.noContent().build();
    }
}

