package com.bitequest.BiteQuest.configuration;

import com.bitequest.BiteQuest.entity.Usuario;
import com.bitequest.BiteQuest.entity.exception.NaoAutorizadoException;
import com.bitequest.BiteQuest.repository.UsuarioRepository;
import com.bitequest.BiteQuest.usuario.UsuarioSimpleResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AutenticacaoService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Usuario> usuarioOpt = usuarioRepository.findByEmail(username);

        if(usuarioOpt.isEmpty()){
            throw new UsernameNotFoundException(String.format("O email %s não foi encontrado", username));
        }

        return (UserDetails) new UsuarioSimpleResponse(usuarioOpt.get());
    }

    public Usuario getUsuarioFromUsuarioDetails() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null)
            return null;
        UsuarioSimpleResponse usuarioDetailsDto =  (UsuarioSimpleResponse) authentication.getPrincipal();

        Optional<Usuario> usuario = usuarioRepository.findById(usuarioDetailsDto.getId());
        return usuario.orElse(null);
    }
    public void verificarDono(Usuario usuario) {
        if (!usuario.getHasDono()) { // Supondo que getHasDono() retorne um Boolean
            throw new NaoAutorizadoException("Não autorizado. O usuário não é um dono de estabelecimento.");
        }
    }

    public void verificarRestaurante(Usuario usuario) {
        if (usuario.getRestaurante() == null) {
            throw new NaoAutorizadoException("Não autorizado. Este usuário não tem acesso a Restaurante.");
        }
}
}