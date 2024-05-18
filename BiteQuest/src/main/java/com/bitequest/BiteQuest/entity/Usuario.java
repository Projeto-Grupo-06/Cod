package com.bitequest.BiteQuest.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Entity
@Getter
@Setter
@AllArgsConstructor
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String sobrenome;

    @CPF
    private String cpf;

    @Email
    @NotBlank(message = "O email é obrigatório")
    private String email;

    private LocalDate dataNascimento;
    @NotBlank(message = "A senha é obrigatória")
    private String senha;

    public Usuario() {
    }

    public Usuario(String nome, String sobrenome, String cpf, String email, LocalDate dataNascimento, String senha, List<Restaurante> restaurantes) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
        this.email = email;
        this.dataNascimento = dataNascimento;
        this.senha = senha;
    }

    public Usuario(Long id, String nome, String email, List<Restaurante> restaurantes) {
        this.id = id;
        this.nome = nome;
        this.email = email;
    }

    public Usuario(String nome, String sobrenome, String cpf, String email, LocalDate dataNascimento, String senha) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
        this.email = email;
        this.dataNascimento = dataNascimento;
        this.senha = senha;
    }

    // Construtor adicionado
    public Usuario(Long id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
    }
}
