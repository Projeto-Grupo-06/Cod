package projeto.sprint.restauranteAplication.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.service.annotation.GetExchange;
import projeto.sprint.restauranteAplication.Service.CardapioObserver;
import projeto.sprint.restauranteAplication.Service.MinhaClasseObservadora;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cardapios")
public class Cardapio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String descricaoPrato;
    private Double preco;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cardapio")
    private List<Prato> pratos;


    // aplicação Observer
    private static List<CardapioObserver> observadores = new ArrayList<>();
    // Outros atributos e métodos

    public void adicionarObservador(CardapioObserver observador) {
        observadores.add(observador);
    }

    public void removerObservador(CardapioObserver observador) {
        observadores.remove(observador);
    }

    public void notificarObservadores() {
        for (CardapioObserver observador : observadores) {
            observador.atualizarCardapio(this);
        }
    }

    // Getters e setters lombok
}

