package com.bitequest.BiteQuest.entity;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.Set;

@SpringBootTest
public class CardapioTest {

    private final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    private final Validator validator = factory.getValidator();

    @Test
    public void testNomeNaoDeveSerVazio() {
        Cardapio cardapio = new Cardapio(null, "", 10.0, "Versao teste", new Restaurante());

        Set<ConstraintViolation<Cardapio>> violations = validator.validate(cardapio);

        assertFalse(violations.isEmpty());
    }

    @Test
    public void testPrecoNaoDeveSerNulo() {
        Cardapio cardapio = new Cardapio(null, "Nome do Cardapio", null, "Versao teste", new Restaurante());

        Set<ConstraintViolation<Cardapio>> violations = validator.validate(cardapio);

        assertFalse(violations.isEmpty());
    }

    @Test
    public void testGettersAndSetters() {
        Cardapio cardapio = new Cardapio();
        cardapio.setId(1);
        cardapio.setNome("Nome do Cardapio");
        cardapio.setPreco(10.0);
        cardapio.setVersao("Versao teste");
        cardapio.setRestaurante(new Restaurante());

        assertEquals(1, cardapio.getId());
        assertEquals("Nome do Cardapio", cardapio.getNome());
        assertEquals(10.0, cardapio.getPreco());
        assertEquals("Versao teste", cardapio.getVersao());
        assertNotNull(cardapio.getRestaurante());
    }

    // Outros testes de métodos da classe Cardapio podem ser adicionados aqui
}
