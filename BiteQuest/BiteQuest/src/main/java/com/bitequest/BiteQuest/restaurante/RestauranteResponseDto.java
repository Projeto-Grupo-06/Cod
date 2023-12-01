package com.bitequest.BiteQuest.restaurante;

import com.bitequest.BiteQuest.cardapio.CardapioResponseDto;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.validator.constraints.br.CNPJ;

import java.util.List;

@Data
public class RestauranteResponseDto {
    private Integer id;

    @NotBlank(message = "O nome é obrigatório")
    private String nome;

    @CNPJ(message = "CNPJ inválido")
    private String cnpj;

    private String cep;

    @NotBlank(message = "O endereço é obrigatório")
    private String endereco;

    private int numero; // Ou outro tipo numérico adequado

    private String complemento;

    private List<CardapioResponseDto> cardapios;

}
