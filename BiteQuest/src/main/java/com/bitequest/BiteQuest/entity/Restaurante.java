package com.bitequest.BiteQuest.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Restaurante implements Observer {

    @Override
    public void update(Cardapio cardapio) {
        System.out.println("O cardápio foi atualizado: " + cardapio);
        // Aqui você pode adicionar a lógica para lidar com a atualização do cardápio
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "O nome do restaurante é obrigatório")
    private String nome;

    @NotBlank(message = "O CNPJ é obrigatório")
    private String cnpj;

    @NotBlank(message = "O CEP é obrigatório")
    private String cep;

    @NotBlank(message = "O endereço é obrigatório")
    private String endereco;

    private String numero;
    private String complemento;
    private String descricao;
    private String tipo;

    public Restaurante(String nome, String cnpj, String cep, String endereco, String numero, String complemento, String descricao, String tipo) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.cep = cep;
        this.endereco = endereco;
        this.numero = numero;
        this.complemento = complemento;
        this.descricao = descricao;
        this.tipo = tipo;
    }

    public Restaurante(Integer id, String nome, String cnpj, String cep, String endereco, String numero, String complemento, String descricao, String tipo) {
        this.id = id;
        this.nome = nome;
        this.cnpj = cnpj;
        this.cep = cep;
        this.endereco = endereco;
        this.numero = numero;
        this.complemento = complemento;
        this.descricao = descricao;
        this.tipo = tipo;
    }

    public Restaurante() {
        // Construtor padrão
    }


    @OneToMany(mappedBy = "restaurante", cascade = CascadeType.ALL)
    private List<HorarioFuncionamento> horarios;

    @OneToMany(mappedBy = "restaurante", cascade = CascadeType.ALL)
    private List<Cardapio> cardapios;
}
