package com.bitequest.BiteQuest.usuario;

import com.bitequest.BiteQuest.entity.Restaurante;
import com.bitequest.BiteQuest.entity.Usuario;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class UsuarioSimpleResponse {
    private Long id;
    private String nome;
    private String sobrenome;
    private String email;
    private LocalDate dataNascimento;
    private Boolean hasDono;
    private List<Restaurante> restaurantes; // novo campo

    public UsuarioSimpleResponse(Usuario usuario) {
        this.id = usuario.getId();
        this.nome = usuario.getNome();
        this.sobrenome = usuario.getSobrenome();
        this.email = usuario.getEmail();
        this.dataNascimento = usuario.getDataNascimento();
        this.restaurantes = usuario.getRestaurantes(); // novo campo
    }

    public UsuarioSimpleResponse(){

    }
}
