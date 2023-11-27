package com.example.bitequestusuario.service;

import com.example.bitequestusuario.controller.dto.UsuarioDTO;
import com.example.bitequestusuario.controller.dto.mapper.UsuarioMapper;
import com.example.bitequestusuario.entity.Usuario;
import com.example.bitequestusuario.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.example.bitequestusuario.entity.exception.EntidadeNaoEncontradaException;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario salvar(Usuario usuario) {
        boolean existeEsseCpf = false;
        List<Usuario> all = usuarioRepository.findAll();

        for (Usuario u : all) {
            if (Objects.equals(u.getCpf(), usuario.getCpf())) {
                existeEsseCpf = true;
                break;
            }
        }

        if (existeEsseCpf) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Usuário já existente!");
        }

        UsuarioMapper.toUsuarioReponseDto(usuario);
        return usuario;
    }

    public List<Usuario> listar() {
        return usuarioRepository.findAll();
    }

    public Usuario buscarPorId(Integer id) {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(
                ()-> new EntidadeNaoEncontradaException("Usuario não encontrado")
        );
        return usuario;
    }

    public Usuario atualizar(Integer id, Usuario usuario) {
        usuario.setId(id);
        return usuarioRepository.save(usuario);
    }

    public void deletarUsuario(Integer id){
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        usuarioRepository.excluirUsuarioId(Long.valueOf(id));
    }
   /* public void atualizarEmail(Integer id, String email){
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        if(usuario.isPresent()){
            usuarioRepository.atualizarEmail(Long.valueOf(id),email);
        }
    } */

}
