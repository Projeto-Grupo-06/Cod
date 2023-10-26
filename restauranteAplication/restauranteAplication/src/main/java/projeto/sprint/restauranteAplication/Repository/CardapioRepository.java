package projeto.sprint.restauranteAplication.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import projeto.sprint.restauranteAplication.Entity.Cardapio;

public interface CardapioRepository extends JpaRepository<Cardapio, Integer> {
}
