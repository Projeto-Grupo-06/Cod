package com.bitequest.BiteQuest.entity;

import com.bitequest.BiteQuest.usuario.UsuarioCreateRequestDto;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UsuarioTest {

    private final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    private final Validator validator = factory.getValidator();

    @Test
    public void testUsuarioCreateRequestDtoValidation() {
        UsuarioCreateRequestDto usuario = new UsuarioCreateRequestDto();
        usuario.setNome("");
        usuario.setSobrenome("");
        usuario.setDataNascimento(LocalDate.now().plusDays(1)); // Data futura
        usuario.setCpf("12345678900"); // CPF inválido
        usuario.setEmail("email@invalid"); // Email inválido
        usuario.setSenha(""); // Senha em branco
        usuario.setHasDono(null); // hasDono não definido

        Set<ConstraintViolation<UsuarioCreateRequestDto>> violations = validator.validate(usuario);

        assertEquals(5, violations.size());

        for (ConstraintViolation<UsuarioCreateRequestDto> violation : violations) {
            switch (violation.getPropertyPath().toString()) {
                case "nome":
                    assertEquals("O nome é obrigatório", violation.getMessage());
                    break;
                case "sobrenome":
                    assertEquals("O sobrenome é obrigatório", violation.getMessage());
                    break;
                case "dataNascimento":
                    assertEquals("A data de nascimento deve estar no passado ou ser a data atual", violation.getMessage());
                    break;
                case "cpf":
                    assertEquals("CPF inválido", violation.getMessage());
                    break;
                case "email":
                    assertEquals("Email inválido", violation.getMessage());
                    break;
                case "senha":
                    assertEquals("A senha é obrigatória", violation.getMessage());
                    break;
                default:
                    break;
            }
        }
    }
}
