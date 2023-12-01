package com.bitequest.BiteQuest.usuario;

import com.bitequest.BiteQuest.entity.Usuario;
import lombok.Data;

import java.time.LocalDate;

@Data
public class UsuarioSimpleResponse {
    private Long id;
    private String nome;
    private String sobrenome;
    private String email;
    private LocalDate dataNascimento;
    private Boolean hasDono;

    public UsuarioSimpleResponse(Usuario usuario) {
        // Inicialize os atributos com as propriedades do objeto Usuario
    }
    public UsuarioSimpleResponse(){

    }
}