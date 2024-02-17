package com.bitequest.BiteQuest.entity;

import com.bitequest.BiteQuest.restaurante.RestauranteCreateRequestDto;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.Test;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RestauranteTest {

    private final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    private final Validator validator = factory.getValidator();

    @Test
    public void testRestauranteCreateRequestDtoValidation() {
        RestauranteCreateRequestDto restaurante = new RestauranteCreateRequestDto();
        restaurante.setNome("");
        restaurante.setCnpj("12345678901234"); // CNPJ inválido
        restaurante.setCep("123"); // CEP inválido
        restaurante.setEndereco("");
        restaurante.setNumero(String.valueOf(-1)); // Número negativo
        restaurante.setComplemento("");

        Set<ConstraintViolation<RestauranteCreateRequestDto>> violations = validator.validate(restaurante);

        assertEquals(4, violations.size());

        for (ConstraintViolation<RestauranteCreateRequestDto> violation : violations) {
            switch (violation.getPropertyPath().toString()) {
                case "nome":
                    assertEquals("O nome é obrigatório", violation.getMessage());
                    break;
                case "cnpj":
                    assertEquals("CNPJ inválido", violation.getMessage());
                    break;
                case "cep":
                    // Verificar a mensagem de erro para o CEP, se houver validação específica
                    break;
                case "endereco":
                    assertEquals("O endereço é obrigatório", violation.getMessage());
                    break;
                case "numero":
                    assertEquals("O número deve ser um valor positivo ou zero", violation.getMessage());
                    break;
                case "cardapio":
                    assertEquals("não pode ser nulo", violation.getMessage());
                    break;
                default:
                    // Lidar com outros campos, se necessário
                    break;
            }
        }
    }
}
