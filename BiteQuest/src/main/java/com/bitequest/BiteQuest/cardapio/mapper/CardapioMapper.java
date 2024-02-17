package com.bitequest.BiteQuest.cardapio.mapper;

import com.bitequest.BiteQuest.cardapio.CardapioCreateRequestDto;
import com.bitequest.BiteQuest.cardapio.CardapioResponseDto;
import com.bitequest.BiteQuest.cardapio.CardapioSimpleResponse;
import com.bitequest.BiteQuest.entity.Cardapio;
import com.bitequest.BiteQuest.entity.Restaurante;

public class CardapioMapper {
    public static Cardapio toEntity(CardapioCreateRequestDto dto) {
        Cardapio cardapio = new Cardapio();
        cardapio.setNome(dto.getNome());
        cardapio.setPreco(dto.getPreco());
        cardapio.setVersao(dto.getVersao());

        Restaurante restaurante = new Restaurante();
        restaurante.setId(dto.getRestaurante().getId());

        cardapio.setRestaurante(restaurante);

        return cardapio;
    }

    public static CardapioResponseDto toCardapioReponseDto(Cardapio entity) {
        CardapioResponseDto cardapio = new CardapioResponseDto();

        cardapio.setId(entity.getId());
        cardapio.setNome(entity.getNome());
        cardapio.setPreco(entity.getPreco());
        cardapio.setVersao(entity.getVersao());

        return cardapio;
    }

    public static CardapioSimpleResponse toCardapioSimpleResponse(Cardapio entity) {
        if (entity == null) {
            return null;
        }

        CardapioSimpleResponse cardapio = new CardapioSimpleResponse();
        cardapio.setId(entity.getId());
        cardapio.setNome(entity.getNome());
        cardapio.setPreco(entity.getPreco());
        cardapio.setVersao(entity.getVersao());

        return cardapio;
    }
}
