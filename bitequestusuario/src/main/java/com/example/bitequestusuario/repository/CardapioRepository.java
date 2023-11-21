package com.example.bitequestusuario.repository;

import com.example.bitequestusuario.model.Cardapio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface CardapioRepository extends JpaRepository<Cardapio, Long> {

    Optional<Cardapio> findById(Long id);

    List<Cardapio> findByNomeContainsIgnoreCase(String nome);

    @Modifying
    @Transactional
    @Query("UPDATE Cardapio c SET c.versao = :versao WHERE c.id = :id")
    Integer atualizarCardapio(Long id, String versao);

    @Modifying
    @Transactional
    @Query("DELETE FROM Cardapio c WHERE c.id = :id")
    Integer excluirCardapioId(Long id);
}
