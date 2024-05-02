package com.bitequest.BiteQuest.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CNPJ;

import java.util.ArrayList;
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

    @ElementCollection
    private Map<String, String> horariosDeFuncionamento;


    public Restaurante(String nome, String cnpj, String cep, String endereco, String numero, String complemento, String descricao, String tipo, Map<String, String> horariosDeFuncionamento) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.cep = cep;
        this.endereco = endereco;
        this.numero = numero;
        this.complemento = complemento;
        this.descricao = descricao;
        this.tipo = tipo;
        this.horariosDeFuncionamento = horariosDeFuncionamento;
    }

    public Restaurante(Integer id, String nome, String cnpj, String cep, String endereco, String numero, String complemento, String descricao, String tipo, Map<String, String> horariosDeFuncionamento) {
        this.id = id;
        this.nome = nome;
        this.cnpj = cnpj;
        this.cep = cep;
        this.endereco = endereco;
        this.numero = numero;
        this.complemento = complemento;
        this.descricao = descricao;
        this.tipo = tipo;
        this.horariosDeFuncionamento = horariosDeFuncionamento;
    }

    public Restaurante(String nome, String cnpj, String cep, String endereco, String numero, String complemento, String descricao, String tipo, Map<String, String> horariosDeFuncionamento, Usuario usuario) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.cep = cep;
        this.endereco = endereco;
        this.numero = numero;
        this.complemento = complemento;
        this.descricao = descricao;
        this.tipo = tipo;
        this.horariosDeFuncionamento = horariosDeFuncionamento;
        this.usuario = usuario;
    }

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Cardapio> cardapios = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    public void addCardapio(Cardapio cardapio) {
        cardapios.add(cardapio);
        cardapio.addObserver(this);
    }

    public void removeCardapio(Cardapio cardapio) {
        cardapios.remove(cardapio);
        cardapio.removeObserver(this);
    }

    public Restaurante() {
        // Construtor padrão
    }

    @Override
    public void update(Cardapio cardapio) {
        System.out.println("Um novo cardápio foi criado: " + cardapio.getImagem());
    }
}
