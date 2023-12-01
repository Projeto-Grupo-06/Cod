package com.bitequest.BiteQuest.cardapio;

import lombok.Data;

@Data
public class CardapioResponseDto {
    private Integer id;
    private String nome;
    private Double preco;
    private String versao;

}
