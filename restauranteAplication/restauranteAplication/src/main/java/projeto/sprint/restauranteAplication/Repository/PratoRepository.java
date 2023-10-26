package projeto.sprint.restauranteAplication.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import projeto.sprint.restauranteAplication.Entity.Prato;

public interface PratoRepository extends JpaRepository<Prato, Integer> {
}
