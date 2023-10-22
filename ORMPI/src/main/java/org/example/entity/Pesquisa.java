package org.example.entity;

import java.util.ArrayList;
import java.util.List;

public class Pesquisa {
    private String termoPesquisa;
    private List<String> historicoPaginasVisitadas;

    public Pesquisa(String termoPesquisa) {
        this.termoPesquisa = termoPesquisa;
        this.historicoPaginasVisitadas = new ArrayList<>();
    }

    public String getTermoPesquisa() {
        return termoPesquisa;
    }

    public List<String> getHistoricoPaginasVisitadas() {
        return historicoPaginasVisitadas;
    }

    public void adicionarPaginaVisitada(String paginaVisitada) {
        historicoPaginasVisitadas.add(paginaVisitada);
    }

    @Override
    public String toString() {
        return "Pesquisa [termoPesquisa=" + termoPesquisa + ", historicoPaginasVisitadas=" + historicoPaginasVisitadas + "]";
    }
}

