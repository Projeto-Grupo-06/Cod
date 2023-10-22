package org.example.entity;

import java.util.ArrayList;
import java.util.List;

public class Restaurante {
    private String descricao;
    private String horarioFuncionamento;
    private String cnpj;
    private Endereco endereco;
    private List<Cardapio> cardapios;

    public Restaurante(String descricao, String horarioFuncionamento, String cnpj, Endereco endereco) {
        this.descricao = descricao;
        this.horarioFuncionamento = horarioFuncionamento;
        this.cnpj = cnpj;
        this.endereco = endereco;
        this.cardapios = new ArrayList<>();
    }

    public String getDescricao() {
        return descricao;
    }

    public String getHorarioFuncionamento() {
        return horarioFuncionamento;
    }

    public String getCnpj() {
        return cnpj;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void adicionarCardapio(Cardapio cardapio) {
        cardapios.add(cardapio);
    }

    public void removerCardapio(Cardapio cardapio) {
        cardapios.remove(cardapio);
    }

    public double colocarValorMaxPrato() {
        double maxPreco = Double.MIN_VALUE;
        for (Cardapio cardapio : cardapios) {
            for (Prato prato : cardapio.getPratos()) {
                if (prato.getPreco() > maxPreco) {
                    maxPreco = prato.getPreco();
                }
            }
        }
        return maxPreco;
    }

    public double colocarValorMinPrato() {
        double minPreco = Double.MAX_VALUE;
        for (Cardapio cardapio : cardapios) {
            for (Prato prato : cardapio.getPratos()) {
                if (prato.getPreco() < minPreco) {
                    minPreco = prato.getPreco();
                }
            }
        }
        return minPreco;
    }
}


