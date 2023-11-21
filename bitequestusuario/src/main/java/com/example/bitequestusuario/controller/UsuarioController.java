package com.example.bitequestusuario.controller;

import com.example.bitequestusuario.dto.UsuarioDTO;
import com.example.bitequestusuario.model.Usuario;
import com.example.bitequestusuario.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @PostMapping
    public ResponseEntity<Usuario> adicionarUsuario(@RequestBody UsuarioDTO u){
        return ResponseEntity.ok(usuarioService.adicionar(u));
    }
    @PutMapping("/{id}")
    public ResponseEntity<Usuario> editarUsuario(@RequestBody UsuarioDTO u, @PathVariable Long id){
        return ResponseEntity.ok(usuarioService.editar(u,id));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarUsuario(@PathVariable Long id){
        usuarioService.deletarUsuario(id);
        return ResponseEntity.noContent().build();
    }
    @PatchMapping("/{id}")
    public ResponseEntity<Void> atualizarEmail(@RequestParam String email, @PathVariable Long id){
        usuarioService.atualizarEmail(id,email);
        return ResponseEntity.noContent().build();
    }
}
