package projeto.sprint.restauranteAplication.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import projeto.sprint.restauranteAplication.Entity.Cardapio;
import projeto.sprint.restauranteAplication.Repository.CardapioRepository;

import java.util.List;

@RestController
@RequestMapping("/api/cardapios")
public class CardapioController {
    @Autowired
    private CardapioRepository cardapioRepository;

    @GetMapping
    public List<Cardapio> getAllCardapios() {
        return cardapioRepository.findAll();
    }

    @GetMapping("/{id}")
    public Cardapio getCardapioById(@PathVariable Integer id) {
        return cardapioRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Cardapio createCardapio(@RequestBody Cardapio cardapio) {
        return cardapioRepository.save(cardapio);
    }

    @PutMapping("/{id}")
    public Cardapio updateCardapio(@PathVariable Integer id, @RequestBody Cardapio updatedCardapio) {
        Cardapio existingCardapio = cardapioRepository.findById(id).orElse(null);
        if (existingCardapio == null) {
            return null;
        }
        existingCardapio.setDescricaoPrato(updatedCardapio.getDescricaoPrato());
        existingCardapio.setPreco(updatedCardapio.getPreco());
        // Atualize outros campos conforme necessário
        return cardapioRepository.save(existingCardapio);
    }

    @DeleteMapping("/{id}")
    public void deleteCardapio(@PathVariable Integer id) {
        cardapioRepository.deleteById(id);
    }

    @GetMapping("/ordenarPorPreco")
    public List<Cardapio> ordenarCardapiosPorPreco() {
        List<Cardapio> cardapios = cardapioRepository.findAll();

        // Bubble Sort para ordenar a lista por preço (crescente)
        int n = cardapios.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (cardapios.get(j).getPreco() > cardapios.get(j + 1).getPreco()) {
                    // Troca os elementos
                    Cardapio temp = cardapios.get(j);
                    cardapios.set(j, cardapios.get(j + 1));
                    cardapios.set(j + 1, temp);
                }
            }
        }
        return cardapios;
    }
}

