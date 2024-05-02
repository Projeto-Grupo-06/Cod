package com.bitequest.BiteQuest.repository;

import com.bitequest.BiteQuest.entity.Comentario;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComentarioRepository extends JpaRepository<Comentario, Long> {

    List<Comentario> findByUsuarioId(Long usuarioId);

    List<Comentario> findByRestauranteId(Integer restauranteId);

    @Modifying
    @Transactional
    @Query("DELETE FROM Comentario c WHERE c.id = :id")
    void excluirComentarioPorId(Long id);
}

