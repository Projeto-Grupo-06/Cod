package com.bitequest.BiteQuest.entity;
import com.bitequest.BiteQuest.cardapio.CardapioCreateRequestDto;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.Test;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CardapioTest {

    private final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    private final Validator validator = factory.getValidator();

    @Test
    public void testCardapioCreateRequestDtoValidation() {
        CardapioCreateRequestDto cardapio = new CardapioCreateRequestDto();
        cardapio.setNome("");
        cardapio.setPreco(-1.0); // Preço negativo
        cardapio.setVersao("");
        cardapio.setRestaurante(null); // Restaurante nulo

        Set<ConstraintViolation<CardapioCreateRequestDto>> violations = validator.validate(cardapio);

        assertEquals(4, violations.size());

        for (ConstraintViolation<CardapioCreateRequestDto> violation : violations) {
            switch (violation.getPropertyPath().toString()) {
                case "nome":
                    assertEquals("não deve estar em branco", violation.getMessage());
                    break;
                case "preco":
                    assertEquals("deve ser maior ou igual a 0", violation.getMessage());
                    break;
                case "versao":
                    assertEquals("não deve estar em branco", violation.getMessage());
                    break;
                case "restaurante":
                    assertEquals("não deve ser nulo", violation.getMessage());
                    break;
                default:
                    break;
            }
        }
    }
}
