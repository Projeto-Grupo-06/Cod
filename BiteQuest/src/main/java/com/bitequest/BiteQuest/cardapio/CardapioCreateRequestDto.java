package com.bitequest.BiteQuest.cardapio;

import jakarta.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class CardapioCreateRequestDto {
    @NotBlank(message = "A imagem é obrigatória")
    private String imagem;

    // getters and setters
    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }
}
