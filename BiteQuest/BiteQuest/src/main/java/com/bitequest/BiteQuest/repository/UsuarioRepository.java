package com.bitequest.BiteQuest.repository;

import com.bitequest.BiteQuest.entity.Usuario;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findById(Long id);
    Optional<Usuario> findByEmail(String email);
    Optional<Usuario>deleteUsuarioById(Long id);
    Optional<Usuario>updateEmail(Long id, String email);

    List<Usuario> findByNomeContainsIgnoreCase(String nome);

    @Modifying
    @Transactional
    @Query("UPDATE Usuario u SET u.id = :id WHERE u.email = :email")
    int updateEmail(Integer id, String email);

    @Modifying
    @Transactional
    @Query("DELETE FROM Usuario u WHERE u.id = :id")
    int deleteUsuarioById(Integer id);
}
