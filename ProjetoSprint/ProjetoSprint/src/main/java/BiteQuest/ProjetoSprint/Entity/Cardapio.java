package BiteQuest.ProjetoSprint.Entity;

import java.util.ArrayList;
import java.util.List;

public class Cardapio {
    private int id;
    private String descricao;
    private List<Prato> pratos;
    private boolean statusDoCardapio;

    public Cardapio(int id, String descricao, boolean statusDoCardapio) {
        this.id = id;
        this.descricao = descricao;
        this.pratos = new ArrayList<>();
        this.statusDoCardapio = statusDoCardapio;
    }

    public int getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public boolean isStatusDoCardapio() {
        return statusDoCardapio;
    }

    public void adicionarPrato(Prato prato) {
        pratos.add(prato);
    }

    public Prato buscarPrato(String nomePrato) {
        for (Prato prato : pratos) {
            if (prato.getNome().equalsIgnoreCase(nomePrato)) {
                return prato;
            }
        }
        return null; // Retorna null se o prato não for encontrado.
    }

    public void mostrarPrecoPrato(String nomePrato) {
        Prato prato = buscarPrato(nomePrato);
        if (prato != null) {
            System.out.println("Preço do prato '" + prato.getNome() + "': R$" + prato.getPreco());
        } else {
            System.out.println("Prato não encontrado no cardápio.");
        }
    }

    public List<Prato> getPratos() {
        return pratos;
    }

    public double colocarValorMaxPrato() {
        double maxPreco = Double.MIN_VALUE;
        for (Prato prato : pratos) {
            if (prato.getPreco() > maxPreco) {
                maxPreco = prato.getPreco();
            }
        }
        return maxPreco;
    }

    public double colocarValorMinPrato() {
        double minPreco = Double.MAX_VALUE;
        for (Prato prato : pratos) {
            if (prato.getPreco() < minPreco) {
                minPreco = prato.getPreco();
            }
        }
        return minPreco;
    }
}


