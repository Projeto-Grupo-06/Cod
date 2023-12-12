package com.bitequest.BiteQuest.controller;

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
    public ResponseEntity<List<Restaurante>> listarRestaurantes(){
        List<Restaurante> restaurantes = restauranteService.todosRestaurantes();
        if (restaurantes.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(restaurantes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Restaurante> restaurantePorId(@PathVariable Integer id){
        Restaurante restaurante = restauranteService.restaurantePorId(id);
        return ResponseEntity.ok(restaurante);
    }

    @PostMapping
    public ResponseEntity<Restaurante> adicionarRestaurante(@Valid @RequestBody RestauranteCreateRequestDto r){
        // Adiciona a solicitação à fila
        filaAdicoes.add(r);

        // Processa a primeira solicitação na fila
        RestauranteCreateRequestDto requestDto = filaAdicoes.poll();
        Restaurante restaurante = restauranteService.adicionar(requestDto);

        return ResponseEntity.ok(restaurante);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Restaurante> editarRestaurante(@PathVariable Integer id, @RequestBody RestauranteSimpleResponse r){
        return ResponseEntity.ok(restauranteService.editar(id, r));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarRestaurante(@PathVariable Integer id){
        restauranteService.deletarRestaurante(id);
        return ResponseEntity.noContent().build();
    }
}
