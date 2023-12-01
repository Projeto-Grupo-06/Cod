package com.bitequest.BiteQuest.repository;

import com.bitequest.BiteQuest.entity.Cardapio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
@Repository
public interface CardapioRepository extends JpaRepository<Cardapio, Integer> {
    Optional<Cardapio> findById(Long id);
    boolean findByIdDelet(Long id);

    List<Cardapio> findByNomeContainsIgnoreCase(String nome);

    @Modifying
    @Transactional
    @Query("UPDATE Cardapio c SET c.versao = :versao WHERE c.id = :id")
    int updateCardapioVersion(Integer id, String versao);

    @Modifying
    @Transactional
    @Query("DELETE FROM Cardapio c WHERE c.id = :id")
    int deleteCardapioById(Long id);
}