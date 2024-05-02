package com.bitequest.BiteQuest.restaurante;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CNPJ;

import java.util.Map;

@Getter
@Setter
public class RestauranteSimpleResponse {
    private Integer id;

    @NotBlank(message = "O nome é obrigatório")
    private String nome;

    @CNPJ(message = "CNPJ inválido")
    private String cnpj;

    private String cep;

    @NotBlank(message = "O endereço é obrigatório")
    private String endereco;

    private String numero;

    private String complemento;

    private String descricao;

    private String tipo;

    private Map<String, String> horariosDeFuncionamento;
}


