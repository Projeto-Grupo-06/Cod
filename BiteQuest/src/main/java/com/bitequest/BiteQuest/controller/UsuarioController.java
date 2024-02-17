package com.bitequest.BiteQuest.controller;

import com.bitequest.BiteQuest.dto.UsuarioLoginDto;
import com.bitequest.BiteQuest.dto.UsuarioTokenDto;
import com.bitequest.BiteQuest.entity.Usuario;
import com.bitequest.BiteQuest.service.UsuarioService;
import com.bitequest.BiteQuest.usuario.UsuarioCreateRequestDto;
import com.bitequest.BiteQuest.usuario.UsuarioSimpleResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping
    public ResponseEntity<List<Usuario>> listarUsuarios(){
        List<Usuario> usuarios = usuarioService.todosUsuarios();
        if (usuarios.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(usuarios);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> usuarioPorId(@PathVariable Long id){
        Usuario usuario = usuarioService.usuarioPorId(id);
        return ResponseEntity.ok(usuario);
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<Optional<Usuario>> usuarioPorEmail(@PathVariable String email){
        Optional<Usuario> usuario = usuarioService.usuarioPorEmail(email);
        return ResponseEntity.ok(usuario);
    }
    @PostMapping
    public ResponseEntity<Usuario> adicionarUsuario(@RequestBody UsuarioCreateRequestDto u){
        Usuario usuario = usuarioService.adicionar(u);

        // Adiciona a ação ao histórico
        historicoAcoes.push("Usuário adicionado: " + usuario.getNome());

        return ResponseEntity.ok(usuario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> editarUsuario( @PathVariable Long id, @RequestBody UsuarioSimpleResponse u){
        return ResponseEntity.ok(usuarioService.editar(id,u));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarUsuario(@PathVariable Long id){
        usuarioService.deletarUsuario(id);
        return ResponseEntity.noContent().build();
    }
    @PatchMapping("/{id}")
    public ResponseEntity<Void> atualizarEmail( @PathVariable Long id, @RequestParam String email){
        usuarioService.atualizarEmail(id,email);
        return ResponseEntity.noContent().build();
    }
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UsuarioLoginDto loginRequest) {
        UsuarioTokenDto usuarioToken = usuarioService.autenticar(loginRequest);
        return ResponseEntity.ok(usuarioToken);
    }

    @GetMapping("/historico")
    public ResponseEntity<Stack<String>> getHistoricoAcoes() {
        // Retorna o histórico de ações do usuário
        return ResponseEntity.ok(historicoAcoes);
    }
}

