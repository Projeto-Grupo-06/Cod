package BiteQuest.ProjetoSprint.Controller;


import BiteQuest.ProjetoSprint.Entity.Cardapio;
import BiteQuest.ProjetoSprint.Repository.IAdaptadorCardapio;

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

