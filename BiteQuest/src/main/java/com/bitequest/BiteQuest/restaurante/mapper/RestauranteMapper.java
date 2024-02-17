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
        restaurante.setNumero(String.valueOf(requestDto.getNumero())); // Ajustado para String
        restaurante.setComplemento(requestDto.getComplemento());
        restaurante.setDescricao(requestDto.getDescricao()); // Adicionado
        restaurante.setTipo(requestDto.getTipo()); // Adicionado
        return restaurante;
    }

    public static RestauranteResponseDto toRestauranteResponseDto(Restaurante entity) {
        if(entity == null) {
            return null;
        }
        RestauranteResponseDto responseDto = new RestauranteResponseDto();
        responseDto.setId(entity.getId());
        responseDto.setNome(entity.getNome());
        responseDto.setCnpj(entity.getCnpj());
        responseDto.setCep(entity.getCep());
        responseDto.setEndereco(entity.getEndereco());
        responseDto.setNumero(entity.getNumero());
        responseDto.setComplemento(entity.getComplemento());
        responseDto.setDescricao(entity.getDescricao()); // Adicionado
        responseDto.setTipo(entity.getTipo()); // Adicionado

        // O código para mapear os cardápios foi removido para simplificar. Se necessário, adicione aqui.

        return responseDto;
    }

    public static RestauranteSimpleResponse toRestauranteSimpleResponse(Restaurante entity) {
        if(entity == null) {
            return null;
        }
        RestauranteSimpleResponse simpleResponse = new RestauranteSimpleResponse();
        simpleResponse.setId(entity.getId());
        simpleResponse.setNome(entity.getNome());
        simpleResponse.setCnpj(entity.getCnpj());
        simpleResponse.setCep(entity.getCep());
        simpleResponse.setEndereco(entity.getEndereco());
        simpleResponse.setNumero(entity.getNumero());
        simpleResponse.setComplemento(entity.getComplemento());
        // Os campos descricao e tipo não são incluídos na resposta simples

        return simpleResponse;
    }
}

