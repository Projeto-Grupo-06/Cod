package com.bitequest.BiteQuest.controller;

import com.bitequest.BiteQuest.cardapio.CardapioCreateRequestDto;
import com.bitequest.BiteQuest.controller.Erro.ErroResponse;
import com.bitequest.BiteQuest.entity.Cardapio;
import com.bitequest.BiteQuest.entity.Comentario;
import com.bitequest.BiteQuest.entity.Restaurante;
import com.bitequest.BiteQuest.entity.Usuario;
import com.bitequest.BiteQuest.entity.exception.RestauranteNaoEncontradoException;
import com.bitequest.BiteQuest.entity.exception.UsuarioNaoEncontradoException;
import com.bitequest.BiteQuest.repository.ComentarioRepository;
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

    private final RestauranteService restauranteService;
    private final UsuarioService usuarioService;
    @Autowired
    private ComentarioRepository comentarioRepository;

    Queue<AbstractMap.SimpleEntry<RestauranteCreateRequestDto, Usuario>> filaAdicoes = new LinkedList<>();

    @Autowired
    public RestauranteController(RestauranteService restauranteService, UsuarioService usuarioService) {
        this.restauranteService = restauranteService;
        this.usuarioService = usuarioService;
    }

    @ExceptionHandler({RestauranteNaoEncontradoException.class, UsuarioNaoEncontradoException.class})
    public ResponseEntity<ErroResponse> tratarExcecaoNaoEncontrado(Exception ex) {
        ErroResponse erro = new ErroResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage());
        return new ResponseEntity<>(erro, HttpStatus.NOT_FOUND);
    }

    @GetMapping
    public ResponseEntity<List<Restaurante>> obterTodosRestaurantes() throws Exception {
        List<Restaurante> restaurantes = restauranteService.todosRestaurantes();
        if (restaurantes.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(restaurantes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Restaurante> obterRestaurantePorId(@PathVariable Integer id) throws RestauranteNaoEncontradoException {
        Restaurante restaurante = restauranteService.restaurantePorId(id);
        return ResponseEntity.ok(restaurante);
    }

    @PostMapping
    public ResponseEntity<Restaurante> criarRestaurante(@Valid @RequestBody RestauranteCreateRequestDto r, @RequestParam Long usuarioId) throws Exception {
        // Busca o usuário pelo ID
        Usuario usuario = usuarioService.usuarioPorId(usuarioId);

        // Adiciona a solicitação à fila
        filaAdicoes.add(new AbstractMap.SimpleEntry<>(r, usuario));

        // Processa a primeira solicitação na fila
        AbstractMap.SimpleEntry<RestauranteCreateRequestDto, Usuario> requestEntry = filaAdicoes.poll();
        Restaurante restaurante = restauranteService.adicionar(requestEntry.getKey(), requestEntry.getValue());

        return ResponseEntity.ok(restaurante);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Restaurante> atualizarRestaurante(@PathVariable Integer id, @RequestBody RestauranteSimpleResponse r) throws Exception {
        Restaurante restaurante = restauranteService.editar(id, r);
        return ResponseEntity.ok(restaurante);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerRestaurante(@PathVariable Integer id) throws Exception {
        restauranteService.deletarRestaurante(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/mapa")
    public ResponseEntity<String> obterMapaRestaurante(@PathVariable Integer id) throws Exception {
        Restaurante restaurante = restauranteService.restaurantePorId(id);

        String cep = restaurante.getCep();

        cep = cep.replace(" ", "+");

        String urlMapa = "https://www.google.com/maps/search/?api=1&query=" + cep;

        return ResponseEntity.ok(urlMapa);
    }

    @PostMapping("/{idRestaurante}/cardapios")
    public ResponseEntity<Cardapio> criarCardapio(@PathVariable Integer idRestaurante, @Valid @RequestBody CardapioCreateRequestDto cardapioDto) throws Exception {
        Cardapio cardapio = restauranteService.adicionarCardapio(idRestaurante, cardapioDto);
        return ResponseEntity.ok(cardapio);
    }

    @PutMapping("/{idRestaurante}/cardapios/{idCardapio}")
    public ResponseEntity<Cardapio> atualizarCardapio(@PathVariable Integer idRestaurante, @PathVariable Long idCardapio, @Valid @RequestBody CardapioCreateRequestDto cardapioDto) throws Exception {
        Cardapio cardapio = restauranteService.atualizarCardapio(idRestaurante, idCardapio, cardapioDto);
        return ResponseEntity.ok(cardapio);
    }

    @DeleteMapping("/{idRestaurante}/cardapios/{idCardapio}")
    public ResponseEntity<Void> removerCardapio(@PathVariable Integer idRestaurante, @PathVariable Long idCardapio) throws Exception {
        restauranteService.removerCardapio(idRestaurante, idCardapio);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/comentarios")
    public ResponseEntity<List<Comentario>> obterComentariosDoRestaurante(@PathVariable Integer id) throws Exception {
        Restaurante restaurante = restauranteService.restaurantePorId(id);
        List<Comentario> comentarios = comentarioRepository.findByRestauranteId(id);
        return ResponseEntity.ok(comentarios);
    }
}



