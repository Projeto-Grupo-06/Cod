package org.example.entity;

public class Usuario extends Cliente {
    private int qtdRestaurantesVisitados;

    public Usuario(int id, String nome, String email, String senha) {
        super(id, nome, email, senha);
        this.qtdRestaurantesVisitados = 0;
    }

    public int getQtdRestaurantesVisitados() {
        return qtdRestaurantesVisitados;
    }

    public void visitarRestaurante() {
        qtdRestaurantesVisitados++;
    }
}
