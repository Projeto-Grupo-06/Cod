package com.bitequest.BiteQuest.cardapio;

import com.bitequest.BiteQuest.entity.Cardapio;
import lombok.Data;

@Data
public class CardapioSimpleResponse {
    private Long id;
    private String imagem;

    // getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }
}
