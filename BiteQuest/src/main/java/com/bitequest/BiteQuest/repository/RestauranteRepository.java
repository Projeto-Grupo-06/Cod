package com.bitequest.BiteQuest.repository;

import com.bitequest.BiteQuest.entity.Restaurante;
import com.bitequest.BiteQuest.entity.Usuario;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public interface RestauranteRepository extends JpaRepository<Restaurante, Integer> {

    List<Restaurante> findByNomeContainsIgnoreCase(String nome);

    @Modifying
    @Transactional
    @Query("UPDATE Restaurante r SET r.nome = :nome, r.cnpj = :cnpj, r.cep = :cep, r.endereco = :endereco, r.numero = :numero, r.complemento = :complemento, r.horariosDeFuncionamento = :horariosDeFuncionamento WHERE r.id = :id")
    void atualizarRestaurante(Integer id, String nome, String cnpj, String cep, String endereco, Integer numero, String complemento, Map<String, String> horariosDeFuncionamento);

    @Modifying
    @Transactional
    @Query("DELETE FROM Restaurante r WHERE r.id = :id")
    void excluirRestaurantePorId(Integer id);

}


