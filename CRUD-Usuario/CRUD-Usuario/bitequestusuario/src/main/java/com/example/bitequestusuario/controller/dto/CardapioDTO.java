package com.example.bitequestusuario.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CardapioDTO {
    private Long id;
    private String nome;
    private Double preco;
    private String versao;
}

