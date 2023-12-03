package com.bitequest.BiteQuest.restaurante;

import com.bitequest.BiteQuest.cardapio.CardapioSimpleResponse;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;
import org.hibernate.validator.constraints.br.CNPJ;

@Data
public class RestauranteCreateRequestDto {
    @NotBlank(message = "O nome é obrigatório")
    private String nome;

    @CNPJ(message = "CNPJ inválido")
    private String cnpj;

    private String cep;

    @NotBlank(message = "O endereço é obrigatório")
    private String endereco;

    @PositiveOrZero(message = "O número deve ser um valor positivo ou zero")
    private int numero; // Ou outro tipo numérico adequado

    private String complemento;

    // Se este for um DTO de requisição, talvez esteja incorreto ter uma resposta como parte da requisição
    // Se for necessário, ajuste para um DTO mais simples refletindo os dados necessários para criar um restaurante
    private CardapioSimpleResponse cardapio;
}
