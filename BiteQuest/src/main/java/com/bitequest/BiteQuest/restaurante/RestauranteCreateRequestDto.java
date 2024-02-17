package com.bitequest.BiteQuest.restaurante;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CNPJ;

@Getter
@Setter
public class RestauranteCreateRequestDto {
    @NotBlank(message = "O nome é obrigatório")
    private String nome;

    @CNPJ(message = "CNPJ inválido")
    private String cnpj;

    private String cep;

    @NotBlank(message = "O endereço é obrigatório")
    private String endereco;

    @PositiveOrZero(message = "O número deve ser um valor positivo ou zero")
    private String numero;

    private String complemento;
    private String descricao;
    private String tipo;


}
