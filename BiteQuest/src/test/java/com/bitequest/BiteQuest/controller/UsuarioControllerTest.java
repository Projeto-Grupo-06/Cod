package com.bitequest.BiteQuest.controller;

import com.bitequest.BiteQuest.entity.Usuario;
import com.bitequest.BiteQuest.service.UsuarioService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UsuarioControllerTest {

    @Mock
    private UsuarioService usuarioService;

    @InjectMocks
    private UsuarioController usuarioController;

    @Test
    public void testListarUsuarios() {
        List<Usuario> mockUsuarios = new ArrayList<>();
        when(usuarioService.todosUsuarios()).thenReturn(mockUsuarios);

        ResponseEntity<List<Usuario>> response = usuarioController.listarUsuarios();

        assertEquals(ResponseEntity.noContent().build(), response);
        verify(usuarioService, times(1)).todosUsuarios();
    }

    @Test
    public void testUsuarioPorId() {
        Long id = 1L;
        Usuario mockUsuario = new Usuario(); // Mock your Usuario object here
        when(usuarioService.usuarioPorId(id)).thenReturn(mockUsuario);

        ResponseEntity<Usuario> response = usuarioController.usuarioPorId(id);

        assertEquals(ResponseEntity.ok(mockUsuario), response);
        verify(usuarioService, times(1)).usuarioPorId(id);
    }

    // Test similar methods for usuarioPorEmail, adicionarUsuario, editarUsuario, deletarUsuario, atualizarEmail, and login
}