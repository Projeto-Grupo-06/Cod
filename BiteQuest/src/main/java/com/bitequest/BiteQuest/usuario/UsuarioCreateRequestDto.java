package com.bitequest.BiteQuest.usuario;

import com.bitequest.BiteQuest.entity.Restaurante;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;
import java.util.List;

@Data
public class UsuarioCreateRequestDto {

    @NotBlank(message = "O nome é obrigatório")
    private String nome;

    @NotBlank(message = "O sobrenome é obrigatório")
    private String sobrenome;

    @PastOrPresent(message = "A data de nascimento deve estar no passado ou ser a data atual")
    private LocalDate dataNascimento;

    @CPF(message = "CPF inválido")
    private String cpf;

    @Email(message = "Email inválido")
    private String email;

    @NotBlank(message = "A senha é obrigatória")
    private String senha;

    private List<Restaurante> restaurantes; // novo campo
}

