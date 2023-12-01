package com.bitequest.BiteQuest.restaurante.mapper;

import com.bitequest.BiteQuest.restaurante.RestauranteCreateRequestDto;
import com.bitequest.BiteQuest.restaurante.RestauranteResponseDto;
import com.bitequest.BiteQuest.restaurante.RestauranteSimpleResponse;
import com.bitequest.BiteQuest.cardapio.CardapioResponseDto;
import com.bitequest.BiteQuest.cardapio.mapper.CardapioMapper;
import com.bitequest.BiteQuest.entity.Restaurante;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RestauranteMapper {
    public static Restaurante toEntity(RestauranteCreateRequestDto requestDto){
        if(requestDto == null) {
            return null;
        }
        Restaurante restaurante = new Restaurante();
        restaurante.setNome(requestDto.getNome());
        restaurante.setCnpj(requestDto.getCnpj());
        restaurante.setCep(requestDto.getCep());
        restaurante.setEndereco(requestDto.getEndereco());
        restaurante.setNumero(String.valueOf(requestDto.getNumero()));
        restaurante.setComplemento(requestDto.getComplemento());
        return restaurante;
    }

    public static RestauranteResponseDto toRestauranteResponseDto(Restaurante entity) {
        if(entity == null) {
            return null;
        }
        RestauranteResponseDto restaurante = new RestauranteResponseDto();
        restaurante.setId(entity.getId());
        restaurante.setNome(entity.getNome());
        restaurante.setEndereco(entity.getEndereco());

        if(entity.getCardapios() != null) {
            List<CardapioResponseDto> cardapios = entity.getCardapios()
                    .stream()
                    .map(CardapioMapper::toCardapioReponseDto)
                    .collect(Collectors.toList());
            restaurante.setCardapios(cardapios);
        }
        return restaurante;
    }

    public static RestauranteSimpleResponse toRestauranteSimpleResponse(Restaurante entity) {
        if(entity == null) {
            return null;
        }
        RestauranteSimpleResponse restaurante = new RestauranteSimpleResponse();
        restaurante.setId(entity.getId());
        restaurante.setNome(entity.getNome());
        restaurante.setEndereco(entity.getEndereco());
        return restaurante;
    }
}
