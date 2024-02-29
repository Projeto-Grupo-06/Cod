package com.bitequest.BiteQuest.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CNPJ;

import java.util.List;
import java.util.Map;

@Entity
@Getter
@Setter
public class Restaurante implements Observer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "O nome do restaurante é obrigatório")
    private String nome;

    @CNPJ
    @NotBlank(message = "O CNPJ é obrigatório")
    private String cnpj;

    @NotBlank(message = "O CEP é obrigatório")
    private String cep;

    @NotBlank(message = "O endereço é obrigatório")
    private String endereco;

    @NotBlank
    private String numero;

    @NotBlank
    private String complemento;

    @NotBlank
    private String descricao;

    @NotBlank
    private String tipo;

    @NotBlank
    private String comentario;

    @ElementCollection
    private Map<String, String> horariosDeFuncionamento;


    public Restaurante(String nome, String cnpj, String cep, String endereco, String numero, String complemento, String descricao, String tipo, String comentario, Map<String, String> horariosDeFuncionamento) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.cep = cep;
        this.endereco = endereco;
        this.numero = numero;
        this.complemento = complemento;
        this.descricao = descricao;
        this.tipo = tipo;
        this.comentario = comentario;
        this.horariosDeFuncionamento = horariosDeFuncionamento;
    }

    public Restaurante(Integer id, String nome, String cnpj, String cep, String endereco, String numero, String complemento, String descricao, String tipo, String comentario, Map<String, String> horariosDeFuncionamento) {
        this.id = id;
        this.nome = nome;
        this.cnpj = cnpj;
        this.cep = cep;
        this.endereco = endereco;
        this.numero = numero;
        this.complemento = complemento;
        this.descricao = descricao;
        this.tipo = tipo;
        this.comentario = comentario;
        this.horariosDeFuncionamento = horariosDeFuncionamento;
    }

    public Restaurante() {
        // Construtor padrão
    }

    @Override
    public void update(Cardapio cardapio) {
        System.out.println("Um novo cardápio foi criado: " + cardapio.getImagem());
    }
}
