package projeto.sprint.restauranteAplication.Repository;

import projeto.sprint.restauranteAplication.Entity.Restaurante;

import java.util.List;

public interface RestauranteRepository {

    List<Restaurante> findAll();
    Restaurante findById(String id);
    Restaurante save(Restaurante restaurante);
    void delete(Restaurante restaurante);
}
