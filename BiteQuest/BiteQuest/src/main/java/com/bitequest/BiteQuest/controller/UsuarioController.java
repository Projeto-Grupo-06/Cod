package com.bitequest.BiteQuest.controller;

import com.bitequest.BiteQuest.entity.Usuario;
import com.bitequest.BiteQuest.service.UsuarioService;
import com.bitequest.BiteQuest.usuario.UsuarioCreateRequestDto;
import com.bitequest.BiteQuest.usuario.UsuarioSimpleResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

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
        return ResponseEntity.ok(usuarioService.adicionar(u));
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
}
