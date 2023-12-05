package com.bitequest.BiteQuest.cardapio;

import lombok.Data;

@Data
public class CardapioResponseDto {
    private Long id;
    private String nome;
    private Double preco;
    private String versao;

}
