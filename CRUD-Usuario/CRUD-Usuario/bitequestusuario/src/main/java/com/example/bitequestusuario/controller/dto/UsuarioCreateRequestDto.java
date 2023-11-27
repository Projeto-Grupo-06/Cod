package com.example.bitequestusuario.controller.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

@Data
public class UsuarioCreateRequestDto {
    @NotBlank
    private String nome;
    @NotBlank
    private String sobrenome;
    @CPF
    private String  cpf;
    @Email
    private String email;
    @Past
    private LocalDate dataNascimento;
    @NotBlank
    private String senha;
}
