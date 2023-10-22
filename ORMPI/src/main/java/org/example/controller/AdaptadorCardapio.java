package org.example.controller;

import org.example.entity.Cardapio;
import org.example.repository.IAdaptadorCardapio;

public class AdaptadorCardapio implements IAdaptadorCardapio {
    private Cardapio cardapio;

    public AdaptadorCardapio(Cardapio cardapio) {
        this.cardapio = cardapio;
    }

    @Override
    public double obterValorMaximoPrato() {
        return cardapio.colocarValorMaxPrato();
    }

    @Override
    public double obterValorMinimoPrato() {
        return cardapio.colocarValorMinPrato();
    }
}

