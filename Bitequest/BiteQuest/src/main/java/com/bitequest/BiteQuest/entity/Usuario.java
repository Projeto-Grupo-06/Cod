package com.bitequest.BiteQuest.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String sobrenome;
    private String cpf;
    private String email;
    private LocalDate dataNascimento;
    private String senha;
    private Boolean hasDono;

    public Usuario() {
    }

    public Usuario(String nome, String email, String senha, Boolean hasDono) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.hasDono = hasDono;
    }

    public Usuario(Long id, String nome, String email, Boolean hasDono) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.hasDono = hasDono;
    }

    @ManyToOne
    @JoinColumn(name = "restaurante_id") // Esta coluna será adicionada na tabela de usuários
    private Restaurante restaurante;
}
