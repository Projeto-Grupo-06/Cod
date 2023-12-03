package com.bitequest.BiteQuest.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class UsuarioTest {

    private Usuario usuario;

    @BeforeEach
    public void setUp() {
        usuario = new Usuario("João", "joao@example.com", "senha123", true);
    }

    @Test
    public void testConstrutorComNomeEmailSenha() {
        Assertions.assertEquals("João", usuario.getNome());
        Assertions.assertEquals("joao@example.com", usuario.getEmail());
        Assertions.assertEquals("senha123", usuario.getSenha());
        //Assertions.assertTrue(usuario.isHasDono());
    }

    @Test
    public void testSettersAndGetters() {
        usuario.setId(1L);
        usuario.setSobrenome("Silva");
        usuario.setCpf("12345678900");
        usuario.setDataNascimento(LocalDate.of(1990, 5, 15));

        Assertions.assertEquals(1L, usuario.getId());
        Assertions.assertEquals("Silva", usuario.getSobrenome());
        Assertions.assertEquals("12345678900", usuario.getCpf());
        Assertions.assertEquals(LocalDate.of(1990, 5, 15), usuario.getDataNascimento());
    }

    @Test
    public void testRestauranteAssociado() {
        Restaurante restaurante = new Restaurante();
        usuario.setRestaurante(restaurante);

        Assertions.assertEquals(restaurante, usuario.getRestaurante());
    }
}
