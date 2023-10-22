package org.example.entity;

import java.util.ArrayList;
import java.util.List;

public abstract class Cliente {
    private int id;
    private String nome;
    private String email;
    private String senha;
    private List<Pesquisa> historicoPesquisas;

    public Cliente(int id, String nome, String email, String senha) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.historicoPesquisas = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public List<Pesquisa> getHistoricoPesquisas() {
        return historicoPesquisas;
    }

    public void adicionarPesquisa(Pesquisa pesquisa) {
        historicoPesquisas.add(pesquisa);
    }

    @Override
    public String toString() {
        return "Cliente [id=" + id + ", nome=" + nome + ", email=" + email + ", senha=" + senha
                + ", historicoPesquisas=" + historicoPesquisas + "]";
    }
}

