package projeto.sprint.restauranteAplication.Entity;

import java.util.List;

public class Usuario {
    private String nome;
    private String email;
    private String senha;
    private List<HistoricoDeNavegacao> historicoDeNavegacao;
    private int quantidadeDeRestaurantesVisitados;

    public Usuario(String nome, String email, String senha, List<HistoricoDeNavegacao> historicoDeNavegacao, int quantidadeDeRestaurantesVisitados) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.historicoDeNavegacao = historicoDeNavegacao;
        this.quantidadeDeRestaurantesVisitados = quantidadeDeRestaurantesVisitados;
    }

    // Getters - Setters


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<HistoricoDeNavegacao> getHistoricoDeNavegacao() {
        return historicoDeNavegacao;
    }

    public void setHistoricoDeNavegacao(List<HistoricoDeNavegacao> historicoDeNavegacao) {
        this.historicoDeNavegacao = historicoDeNavegacao;
    }

    public int getQuantidadeDeRestaurantesVisitados() {
        return quantidadeDeRestaurantesVisitados;
    }

    public void setQuantidadeDeRestaurantesVisitados(int quantidadeDeRestaurantesVisitados) {
        this.quantidadeDeRestaurantesVisitados = quantidadeDeRestaurantesVisitados;
    }
}
