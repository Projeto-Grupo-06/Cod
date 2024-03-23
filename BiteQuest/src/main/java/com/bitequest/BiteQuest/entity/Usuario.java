package com.bitequest.BiteQuest.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
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
    private String email;

    private LocalDate dataNascimento;
    private String senha;

    public void setSenha(String senha) {
        Pattern pattern = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$");
        Matcher matcher = pattern.matcher(senha);
        if (matcher.matches()) {
            this.senha = senha;
        } else {
            throw new IllegalArgumentException("A senha deve conter no mínimo 8 caracteres, 1 caractere especial, 1 caractere numérico e 1 caractere maiúsculo.");
        }
    }

    //@OneToMany(cascade = CascadeType.ALL)
    //@JoinTable(
    //       name = "usuario_restaurante",
    //        joinColumns = @JoinColumn(name = "usuario_id"),
    //        inverseJoinColumns = @JoinColumn(name = "restaurante_id")
    //)
    //private List<Restaurante> restaurantes = new ArrayList<>();


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
}

