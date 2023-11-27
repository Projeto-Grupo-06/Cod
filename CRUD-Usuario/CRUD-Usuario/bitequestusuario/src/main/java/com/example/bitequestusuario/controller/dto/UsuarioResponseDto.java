package com.example.bitequestusuario.controller.dto;

import lombok.Data;

import java.time.LocalDate;
import java.time.Period;

@Data
public class UsuarioResponseDto {
    private Integer id;
    private String nomeCompleto;
    private String documento;
    private String contato;
    private LocalDate dataNascimento;
    private String senha;

    public int getIdade() {
        return Period.between(dataNascimento, LocalDate.now()).getYears();
    }
}
