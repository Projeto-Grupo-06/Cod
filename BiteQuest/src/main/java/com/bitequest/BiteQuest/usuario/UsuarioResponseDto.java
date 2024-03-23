package com.bitequest.BiteQuest.usuario;

import com.bitequest.BiteQuest.entity.Restaurante;
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
}
