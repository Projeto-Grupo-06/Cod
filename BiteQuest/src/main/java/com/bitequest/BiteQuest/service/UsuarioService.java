package com.bitequest.BiteQuest.service;

import com.bitequest.BiteQuest.dto.UsuarioLoginDto;
import com.bitequest.BiteQuest.dto.UsuarioTokenDto;
import com.bitequest.BiteQuest.entity.Usuario;
import com.bitequest.BiteQuest.entity.exception.EntidadeNaoEncontradaExceptionn;
import com.bitequest.BiteQuest.jwt.GerenciadorTokenJwt;
import com.bitequest.BiteQuest.repository.UsuarioRepository;
import com.bitequest.BiteQuest.usuario.UsuarioCreateRequestDto;
import com.bitequest.BiteQuest.usuario.UsuarioSimpleResponse;
import com.bitequest.BiteQuest.usuario.mapper.UsuarioMapper;
import jakarta.validation.Valid;
import jakarta.xml.bind.SchemaOutputResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private GerenciadorTokenJwt gerenciadorTokenJwt;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UsuarioMapper usuarioMapper;

    @Autowired
    public UsuarioService(AuthenticationManager authenticationManager, GerenciadorTokenJwt gerenciadorTokenJwt, UsuarioRepository usuarioRepository) {
        this.authenticationManager = authenticationManager;
        this.gerenciadorTokenJwt = gerenciadorTokenJwt;
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario adicionar(UsuarioCreateRequestDto u){
        Usuario novoUsuario = usuarioRepository.save(new Usuario(
                u.getNome(),
                u.getSobrenome(),
                u.getCpf(),
                u.getEmail(),
                u.getDataNascimento(),
                u.getSenha(),
                u.getHasDono()
        ));
        return novoUsuario;
    }


    public List<Usuario> todosUsuarios(){
        return usuarioRepository.findAll();
    }

    public Usuario usuarioPorId(Long id){
        return usuarioRepository.findById(id).orElseThrow(
                () -> new EntidadeNaoEncontradaExceptionn("Usuário não encontrado")
        );
    }

    public Optional<Usuario> usuarioPorEmail(String email){
        return usuarioRepository.findByEmail(email);
    }

    public Usuario editar(Long id, UsuarioSimpleResponse u){
        Usuario usuario = usuarioExiste(id);
        Usuario usuarioEditado = usuarioRepository.save(new Usuario(usuario.getId(), u.getNome(), u.getEmail(), u.getHasDono()));
        return usuarioEditado;
    }

    public void deletarUsuario(Long id){
        usuarioRepository.deleteById(id);
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

    public UsuarioTokenDto autenticar(UsuarioLoginDto usuarioLoginDto){
        final UsernamePasswordAuthenticationToken credentials = new UsernamePasswordAuthenticationToken(
                usuarioLoginDto.getEmail(),
                usuarioLoginDto.getSenha()
        );
        final Authentication authentication = authenticationManager.authenticate(credentials);

        Usuario usuarioAutenticado = usuarioRepository.findByEmail(usuarioLoginDto.getEmail())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        final String token = gerenciadorTokenJwt.generateToken(authentication);
        return UsuarioMapper.of(usuarioAutenticado, token);
    }
}

