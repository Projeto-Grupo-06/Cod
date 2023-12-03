package com.bitequest.BiteQuest.restaurante;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.validator.constraints.br.CNPJ;

@Data
public class RestauranteSimpleResponse {
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

}
