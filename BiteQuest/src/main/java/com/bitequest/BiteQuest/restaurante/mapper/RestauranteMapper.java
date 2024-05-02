package com.bitequest.BiteQuest.restaurante.mapper;

import com.bitequest.BiteQuest.cardapio.CardapioCreateRequestDto;
import com.bitequest.BiteQuest.entity.Cardapio;
import com.bitequest.BiteQuest.entity.Usuario;
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

    public static Restaurante toEntity(RestauranteCreateRequestDto requestDto, Usuario usuario){
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
        restaurante.setDescricao(requestDto.getDescricao());
        restaurante.setTipo(requestDto.getTipo());
        restaurante.setHorariosDeFuncionamento(requestDto.getHorariosDeFuncionamento());
        if(requestDto.getCardapios() != null) {
            for(CardapioCreateRequestDto cardapioDto : requestDto.getCardapios()) {
                Cardapio cardapio = CardapioMapper.toEntity(cardapioDto);
                restaurante.addCardapio(cardapio);
            }
        }
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
        responseDto.setDescricao(entity.getDescricao());
        responseDto.setTipo(entity.getTipo());
        responseDto.setHorariosDeFuncionamento(entity.getHorariosDeFuncionamento());
        if(entity.getCardapios() != null) {
            List<CardapioResponseDto> cardapioDtos = new ArrayList<>();
            for(Cardapio cardapio : entity.getCardapios()) {
                cardapioDtos.add(CardapioMapper.toCardapioResponseDto(cardapio));
            }
            responseDto.setCardapios(cardapioDtos);
        }

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
        simpleResponse.setHorariosDeFuncionamento(entity.getHorariosDeFuncionamento());

        return simpleResponse;
    }
}


