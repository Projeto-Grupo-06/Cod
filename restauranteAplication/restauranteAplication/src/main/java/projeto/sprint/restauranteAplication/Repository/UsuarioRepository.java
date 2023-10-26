package projeto.sprint.restauranteAplication.Repository;

import projeto.sprint.restauranteAplication.Entity.Usuario;
import java.util.List;

public interface UsuarioRepository {

    List<Usuario> findAll();
    Usuario findById(String id);
    Usuario save(Usuario user);
    void delete(Usuario user);
}
