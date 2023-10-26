package projeto.sprint.restauranteAplication.Service;

import projeto.sprint.restauranteAplication.Entity.Cardapio;



public class MinhaClasseObservadora implements CardapioObserver {
    @Override
    public void atualizarCardapio(Cardapio cardapio) {
        System.out.println("O cardápio foi atualizado:");
        System.out.println("Descrição do prato: " + cardapio.getDescricaoPrato());
        System.out.println("Preço do prato: " + cardapio.getPreco());
    }

    public static class Main {
        public static void main(String[] args) {
            Cardapio cardapio = new Cardapio();
            MinhaClasseObservadora observador = new MinhaClasseObservadora();
            cardapio.adicionarObservador(observador);

// Sempre que houver uma mudança no cardápio, notifique os observadores
            cardapio.notificarObservadores();
        }
    }
}

