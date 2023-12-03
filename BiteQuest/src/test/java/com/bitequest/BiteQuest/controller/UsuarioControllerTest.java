package com.bitequest.BiteQuest.controller;

import com.bitequest.BiteQuest.entity.Usuario;
import com.bitequest.BiteQuest.service.UsuarioService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class UsuarioControllerTest {

    @Mock
    private UsuarioService usuarioService;

    @InjectMocks
    private UsuarioController usuarioController;

    @Test
    void testListarUsuarios() {
        // Arrange
        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(new Usuario(/* Construa um objeto de usuário para teste */));
        when(usuarioService.todosUsuarios()).thenReturn(usuarios);

        // Act
        ResponseEntity<List<Usuario>> response = usuarioController.listarUsuarios();

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(usuarios, response.getBody());
    }

    @Test
    void testUsuarioPorId() {
        // Arrange
        Long id = 1L;
        Usuario usuario = new Usuario(/* Construa um objeto de usuário para teste */);
        when(usuarioService.usuarioPorId(id)).thenReturn(usuario);

        // Act
        ResponseEntity<Usuario> response = usuarioController.usuarioPorId(id);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(usuario, response.getBody());
    }

    @Test
    void testUsuarioPorEmail() {
        // Arrange
        String email = "exemplo@teste.com";
        Optional<Usuario> usuarioOptional = Optional.of(new Usuario(/* Construa um objeto de usuário para teste */));
        when(usuarioService.usuarioPorEmail(email)).thenReturn(usuarioOptional);

        // Act
        ResponseEntity<Optional<Usuario>> response = usuarioController.usuarioPorEmail(email);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(usuarioOptional, response.getBody());
    }

    // Vou escrever os outros testes para os demais métodos da Controller (adicionarUsuario, editarUsuario, deletarUsuario, atualizarEmail)
}
