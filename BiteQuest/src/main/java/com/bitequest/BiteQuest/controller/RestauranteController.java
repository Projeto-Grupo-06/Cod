package com.bitequest.BiteQuest.controller;

import com.bitequest.BiteQuest.cardapio.CardapioCreateRequestDto;
import com.bitequest.BiteQuest.entity.Cardapio;
import com.bitequest.BiteQuest.entity.Restaurante;
import com.bitequest.BiteQuest.entity.Usuario;
import com.bitequest.BiteQuest.entity.exception.RestauranteNaoEncontradoException;
import com.bitequest.BiteQuest.restaurante.RestauranteCreateRequestDto;
import com.bitequest.BiteQuest.restaurante.RestauranteSimpleResponse;
import com.bitequest.BiteQuest.service.RestauranteService;
import com.bitequest.BiteQuest.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.AbstractMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


@RestController
@RequestMapping("/restaurantes")
public class RestauranteController {

    @Autowired
    private RestauranteService restauranteService;

    @Autowired
    private UsuarioService usuarioService;

    Queue<AbstractMap.SimpleEntry<RestauranteCreateRequestDto, Usuario>> filaAdicoes = new LinkedList<>();

    @GetMapping
    public ResponseEntity<?> listarRestaurantes() {
        try {
            List<Restaurante> restaurantes = restauranteService.todosRestaurantes();
            if (restaurantes.isEmpty()) {
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.ok(restaurantes);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao listar restaurantes: " + e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> restaurantePorId(@PathVariable Integer id) {
        try {
            Restaurante restaurante = restauranteService.restaurantePorId(id);
            if (restaurante == null) {
                throw new RestauranteNaoEncontradoException(id.toString());
            }
            return ResponseEntity.ok(restaurante);
        } catch (RestauranteNaoEncontradoException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao buscar restaurante: " + e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<?> adicionarRestaurante(@Valid @RequestBody RestauranteCreateRequestDto r, @RequestParam Long usuarioId) {
        try {
            // Busca o usuário pelo ID
            Usuario usuario = usuarioService.usuarioPorId(usuarioId);

            // Adiciona a solicitação à fila
            filaAdicoes.add(new AbstractMap.SimpleEntry<>(r, usuario));

            // Processa a primeira solicitação na fila
            AbstractMap.SimpleEntry<RestauranteCreateRequestDto, Usuario> requestEntry = filaAdicoes.poll();
            Restaurante restaurante = restauranteService.adicionar(requestEntry.getKey(), requestEntry.getValue());

            return ResponseEntity.ok("Restaurante adicionado com sucesso");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao adicionar restaurante: " + e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editarRestaurante(@PathVariable Integer id, @RequestBody RestauranteSimpleResponse r) {
        try {
            Restaurante restaurante = restauranteService.editar(id, r);
            return ResponseEntity.ok("Restaurante editado com sucesso");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao editar restaurante: " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarRestaurante(@PathVariable Integer id) {
        try {
            restauranteService.deletarRestaurante(id);
            return ResponseEntity.ok("Restaurante deletado com sucesso");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao deletar restaurante: " + e.getMessage());
        }
    }

    @GetMapping("/{id}/mapa")
    public ResponseEntity<?> abrirMapaRestaurante(@PathVariable Integer id) {
        try {
            Restaurante restaurante = restauranteService.restaurantePorId(id);

            // Obtenha o CEP do restaurante
            String cep = restaurante.getCep();

            // Substitua os espaços por '+' para formar a URL corretamente
            cep = cep.replace(" ", "+");

            // Cria a URL do Google Maps para o CEP
            String urlMapa = "https://www.google.com/maps/search/?api=1&query=" + cep;

            return ResponseEntity.ok(urlMapa);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao abrir mapa do restaurante: " + e.getMessage());
        }
    }

    @PostMapping("/{idRestaurante}/cardapios")
    public ResponseEntity<?> adicionarCardapio(@PathVariable Integer idRestaurante, @Valid @RequestBody CardapioCreateRequestDto cardapioDto) {
        try {
            Cardapio cardapio = restauranteService.adicionarCardapio(idRestaurante, cardapioDto);
            return ResponseEntity.ok("Cardápio adicionado com sucesso");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao adicionar cardápio: " + e.getMessage());
        }
    }

    @PutMapping("/{idRestaurante}/cardapios/{idCardapio}")
    public ResponseEntity<?> atualizarCardapio(@PathVariable Integer idRestaurante, @PathVariable Long idCardapio, @Valid @RequestBody CardapioCreateRequestDto cardapioDto) {
        try {
            Cardapio cardapio = restauranteService.atualizarCardapio(idRestaurante, idCardapio, cardapioDto);
            return ResponseEntity.ok("Cardápio atualizado com sucesso");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao atualizar cardápio: " + e.getMessage());
        }
    }

    @DeleteMapping("/{idRestaurante}/cardapios/{idCardapio}")
    public ResponseEntity<?> removerCardapio(@PathVariable Integer idRestaurante, @PathVariable Long idCardapio) {
        try {
            restauranteService.removerCardapio(idRestaurante, idCardapio);
            return ResponseEntity.ok("Cardápio removido com sucesso");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao remover cardápio: " + e.getMessage());
        }
    }
}


