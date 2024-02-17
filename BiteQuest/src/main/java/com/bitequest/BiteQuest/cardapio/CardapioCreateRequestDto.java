package com.bitequest.BiteQuest.cardapio;

import com.bitequest.BiteQuest.restaurante.RestauranteSimpleResponse;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

@Data
public class CardapioCreateRequestDto {
    @NotBlank
    private String nome;

    @PositiveOrZero
    private Double preco;

    @NotBlank
    private String versao;

    @NotNull
    private RestauranteSimpleResponse restaurante;

}
