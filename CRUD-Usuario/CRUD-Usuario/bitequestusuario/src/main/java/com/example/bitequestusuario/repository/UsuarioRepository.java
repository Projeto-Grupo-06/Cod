package com.example.bitequestusuario.repository;

import com.example.bitequestusuario.entity.Usuario;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    Optional<Usuario> findById(Integer id);

    List<Usuario> findByNomeContainsIgnoreCase(String nome);

    @Modifying
    @Transactional
    @Query("UPDATE Usuario u SET u.email = :email WHERE u.id = :id")
    Integer atualizarEmail(Long id, String email);

    @Modifying
    @Transactional
    @Query("DELETE FROM Usuario u WHERE u.id = :id")
    Integer excluirUsuarioId(Long id);

}
