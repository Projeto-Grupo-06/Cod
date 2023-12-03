package com.bitequest.BiteQuest.cardapio;

import com.bitequest.BiteQuest.entity.Cardapio;
import lombok.Data;

@Data
public class CardapioSimpleResponse extends Cardapio {
    private Integer id;
    private String nome;
    private Double preco;
    private String versao;
}
