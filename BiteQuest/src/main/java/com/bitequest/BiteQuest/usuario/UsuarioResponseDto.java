package com.bitequest.BiteQuest.usuario;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class UsuarioResponseDto {
    private Long id;
    private String nome;
    private String sobrenome;
    private LocalDate dataNascimento;
    private String email;
    private Boolean hasDono;

}