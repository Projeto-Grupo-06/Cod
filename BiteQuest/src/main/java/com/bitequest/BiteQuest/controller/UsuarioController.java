package com.bitequest.BiteQuest.controller;

import com.bitequest.BiteQuest.controller.Erro.ErroResponse;
import com.bitequest.BiteQuest.dto.UsuarioLoginDto;
import com.bitequest.BiteQuest.dto.UsuarioTokenDto;
import com.bitequest.BiteQuest.entity.Comentario;
import com.bitequest.BiteQuest.entity.Usuario;
import com.bitequest.BiteQuest.entity.exception.UsuarioNaoEncontradoException;
import com.bitequest.BiteQuest.service.UsuarioService;
import com.bitequest.BiteQuest.usuario.ComentarioCreateRequestDto;
import com.bitequest.BiteQuest.usuario.UsuarioCreateRequestDto;
import com.bitequest.BiteQuest.usuario.UsuarioSimpleResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Stack;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;
    private final Stack<String> historicoAcoes = new Stack<>();

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @ExceptionHandler(UsuarioNaoEncontradoException.class)
    public ResponseEntity<ErroResponse> handleUsuarioNotFoundException(UsuarioNaoEncontradoException ex) {
        ErroResponse erro = new ErroResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage());
        return new ResponseEntity<>(erro, HttpStatus.NOT_FOUND);
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> listarUsuarios() throws Exception {
        List<Usuario> usuarios = usuarioService.todosUsuarios();
        if (usuarios.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(usuarios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> usuarioPorId(@PathVariable Long id) throws UsuarioNaoEncontradoException {
        Usuario usuario = usuarioService.usuarioPorId(id);
        return ResponseEntity.ok(usuario);
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<Usuario> usuarioPorEmail(@PathVariable String email) throws Exception {
        Usuario usuario = usuarioService.usuarioPorEmail(email).orElseThrow(() -> new UsuarioNaoEncontradoException("Usuário não encontrado"));
        return ResponseEntity.ok(usuario);
    }

    @PostMapping
    public ResponseEntity<Usuario> adicionarUsuario(@RequestBody UsuarioCreateRequestDto u) throws Exception {
        Usuario usuario = usuarioService.adicionar(u);

        // Adiciona a ação ao histórico
        synchronized (historicoAcoes) {
            historicoAcoes.push("Usuário adicionado: " + usuario.getNome());
        }

        return ResponseEntity.ok(usuario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> editarUsuario( @PathVariable Long id, @RequestBody UsuarioSimpleResponse u) throws UsuarioNaoEncontradoException {
        return ResponseEntity.ok(usuarioService.editar(id,u));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarUsuario(@PathVariable Long id) throws UsuarioNaoEncontradoException {
        usuarioService.deletarUsuario(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> atualizarEmail( @PathVariable Long id, @RequestParam String email) throws UsuarioNaoEncontradoException {
        usuarioService.atualizarEmail(id,email);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UsuarioLoginDto loginRequest) throws Exception {
        UsuarioTokenDto usuarioToken = usuarioService.autenticar(loginRequest);
        return ResponseEntity.ok(usuarioToken);
    }

    @GetMapping("/historico")
    public ResponseEntity<Stack<String>> getHistoricoAcoes() throws Exception {
        // Retorna o histórico de ações do usuário
        synchronized (historicoAcoes) {
            return ResponseEntity.ok(historicoAcoes);
        }
    }

    @PostMapping("/{idUsuario}/restaurantes/{idRestaurante}/comentarios")
    public ResponseEntity<Comentario> adicionarComentario(@PathVariable Long idUsuario, @PathVariable Integer idRestaurante, @Valid @RequestBody ComentarioCreateRequestDto comentarioDto) throws Exception {
        Comentario comentario = usuarioService.adicionarComentario(idUsuario, idRestaurante, comentarioDto);
        return ResponseEntity.ok(comentario);
    }
}