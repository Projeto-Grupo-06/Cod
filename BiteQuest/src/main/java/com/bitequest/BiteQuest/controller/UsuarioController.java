package com.bitequest.BiteQuest.controller;

import com.bitequest.BiteQuest.dto.UsuarioLoginDto;
import com.bitequest.BiteQuest.dto.UsuarioTokenDto;
import com.bitequest.BiteQuest.entity.Usuario;
import com.bitequest.BiteQuest.entity.exception.UsuarioNaoEncontradoException;
import com.bitequest.BiteQuest.service.UsuarioService;
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

    @Autowired
    private UsuarioService usuarioService;

    private Stack<String> historicoAcoes = new Stack<>();

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @ExceptionHandler(UsuarioNaoEncontradoException.class)
    public ResponseEntity<String> handleUsuarioNotFoundException(UsuarioNaoEncontradoException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> listarUsuarios(){
        try {
            List<Usuario> usuarios = usuarioService.todosUsuarios();
            if (usuarios.isEmpty()){
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.ok(usuarios);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> usuarioPorId(@PathVariable Long id){
        try {
            Usuario usuario = usuarioService.usuarioPorId(id);
            return ResponseEntity.ok(usuario);
        } catch (UsuarioNaoEncontradoException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<Optional<Usuario>> usuarioPorEmail(@PathVariable String email){
        try {
            Optional<Usuario> usuario = usuarioService.usuarioPorEmail(email);
            return ResponseEntity.ok(usuario);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PostMapping
    public ResponseEntity<Usuario> adicionarUsuario(@RequestBody UsuarioCreateRequestDto u){
        try {
            Usuario usuario = usuarioService.adicionar(u);

            // Adiciona a ação ao histórico
            historicoAcoes.push("Usuário adicionado: " + usuario.getNome());

            return ResponseEntity.ok(usuario);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> editarUsuario( @PathVariable Long id, @RequestBody UsuarioSimpleResponse u){
        try {
            return ResponseEntity.ok(usuarioService.editar(id,u));
        } catch (UsuarioNaoEncontradoException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarUsuario(@PathVariable Long id){
        try {
            usuarioService.deletarUsuario(id);
            return ResponseEntity.noContent().build();
        } catch (UsuarioNaoEncontradoException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PatchMapping("/{id}")

    public ResponseEntity<Void> atualizarEmail( @PathVariable Long id, @RequestParam String email){
        try {
            usuarioService.atualizarEmail(id,email);
            return ResponseEntity.noContent().build();
        } catch (UsuarioNaoEncontradoException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UsuarioLoginDto loginRequest) {
        try {
            UsuarioTokenDto usuarioToken = usuarioService.autenticar(loginRequest);
            return ResponseEntity.ok(usuarioToken);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/historico")
    public ResponseEntity<Stack<String>> getHistoricoAcoes() {
        try {
            // Retorna o histórico de ações do usuário
            return ResponseEntity.ok(historicoAcoes);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}


