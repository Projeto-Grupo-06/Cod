package com.bitequest.BiteQuest.service;

import com.bitequest.BiteQuest.entity.Usuario;
import com.bitequest.BiteQuest.entity.exception.EntidadeNaoEncontradaExceptionn;
import com.bitequest.BiteQuest.repository.UsuarioRepository;
import com.bitequest.BiteQuest.usuario.UsuarioCreateRequestDto;
import com.bitequest.BiteQuest.usuario.UsuarioSimpleResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario adicionar(UsuarioCreateRequestDto u){
        Usuario novoUsuario = usuarioRepository.save(new Usuario(u.getNome(), u.getEmail(), u.getSenha(), u.getHasDono()));
        return novoUsuario;
    }

    public List<Usuario> todosUsuarios(){
        return usuarioRepository.findAll();
    }

    public  Usuario usuarioPorId(Long id){
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        return usuarioRepository.findById(id).get();
    }

    public Optional<Usuario> usuarioPorEmail(String email){
        Optional<Usuario> usuario = usuarioRepository.findByEmail(email);
        return usuarioRepository.findByEmail(email);
    }

    public Usuario editar(Long id, UsuarioSimpleResponse u){
        Usuario usuario = usuarioExiste(id);
        Usuario usuarioEditado = usuarioRepository.save(new Usuario(usuario.getId(), u.getNome(), u.getEmail(), u.getHasDono()));
        return usuarioEditado;
    }

    public void deletarUsuario(Long id){
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        usuarioRepository.deleteUsuarioById(id);
    }
    public void atualizarEmail(Long id, String email){
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        if(usuario.isPresent()){
            usuarioRepository.updateEmail(id,email);
        }
    }

    public Usuario usuarioExiste(Long id){
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(
                ()-> new EntidadeNaoEncontradaExceptionn("Usuário não encontrado")
        );
        return usuario;
    }
}
