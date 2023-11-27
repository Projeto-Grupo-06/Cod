package com.example.bitequestusuario.controller;

import com.example.bitequestusuario.controller.dto.UsuarioCreateRequestDto;
import com.example.bitequestusuario.controller.dto.UsuarioDTO;
import com.example.bitequestusuario.controller.dto.UsuarioResponseDto;
import com.example.bitequestusuario.controller.dto.UsuarioSimpleResponse;
import com.example.bitequestusuario.controller.dto.mapper.UsuarioMapper;
import com.example.bitequestusuario.entity.Usuario;
import com.example.bitequestusuario.service.UsuarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<UsuarioResponseDto>> listar() {
        List<Usuario> usuarios = usuarioService.listar();

        if (usuarios.isEmpty()) {
            return ResponseEntity.noContent().build();

        }
        List<UsuarioResponseDto> dtos = usuarios.stream().map(UsuarioMapper::toUsuarioReponseDto).toList();

        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponseDto> buscarPorId(@PathVariable int id) {
        Usuario u = usuarioService.buscarPorId(id);
        return ResponseEntity.ok(UsuarioMapper.toUsuarioReponseDto(u));
    }


    @PostMapping
    public ResponseEntity<UsuarioResponseDto> salvar(@RequestBody @Valid UsuarioCreateRequestDto usuarioDto) {
        Usuario u = UsuarioMapper.toEntity(usuarioDto);
        u = usuarioService.salvar(u);

        return ResponseEntity.created(URI.create("/usuarios/" + u.getId())).body(UsuarioMapper.toUsuarioReponseDto(u));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioResponseDto> atualizar(@PathVariable int id, @RequestBody @Valid Usuario usuario) {
        usuarioService.atualizar(id,usuario);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarUsuario(@PathVariable int id) {
        Usuario usuario = usuarioService.buscarPorId(id);

        if (usuario == null) {
            return ResponseEntity.notFound().build();
        }

        usuarioService.deletarUsuario(id);
        return ResponseEntity.noContent().build();
    }

  /*  @PatchMapping("/{id}")
    public ResponseEntity<Void> atualizarEmail(@RequestParam String email, @PathVariable Long id){
        usuarioService.atualizarEmail(id,email);
        return ResponseEntity.noContent().build();
    } */
}
