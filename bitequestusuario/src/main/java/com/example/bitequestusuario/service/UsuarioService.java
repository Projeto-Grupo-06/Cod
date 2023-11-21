package com.example.bitequestusuario.service;

import com.example.bitequestusuario.dto.UsuarioDTO;
import com.example.bitequestusuario.model.Usuario;
import com.example.bitequestusuario.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.bitequestusuario.exception.UsuarioNaoEncontradoException;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    public Usuario adicionar(UsuarioDTO u){
        Usuario novoUsuario = usuarioRepository.save(new Usuario(null,u.getNome(),u.getEmail(),u.getSenha()));
        return novoUsuario;
    }

    public List<Usuario> todosUsuarios(){
        return usuarioRepository.findAll();
    }

    public  Usuario usuarioPorId(Long id){
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        return usuarioRepository.findById(id).get();
    }

    public Usuario editar(UsuarioDTO u, Long id){
        Usuario usuario = usuarioExiste(id);
        Usuario usuarioEditado = usuarioRepository.save(new Usuario(usuario.getId(),u.getNome(),u.getEmail(),u.getSenha()));
        return usuarioEditado;
    }

    public void deletarUsuario(Long id){
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        usuarioRepository.excluirUsuarioId(id);
    }
    public void atualizarEmail(Long id, String email){
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        if(usuario.isPresent()){
            usuarioRepository.atualizarEmail(id,email);
        }
    }

    public Usuario usuarioExiste(Long id){
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(
                ()-> new UsuarioNaoEncontradoException()
        );
        return usuario;
    }
}
