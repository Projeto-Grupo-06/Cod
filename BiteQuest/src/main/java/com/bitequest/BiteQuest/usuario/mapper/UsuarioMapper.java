package com.bitequest.BiteQuest.usuario.mapper;

import com.bitequest.BiteQuest.dto.UsuarioTokenDto;
import com.bitequest.BiteQuest.entity.Usuario;
import com.bitequest.BiteQuest.usuario.UsuarioCreateRequestDto;
import com.bitequest.BiteQuest.usuario.UsuarioResponseDto;
import com.bitequest.BiteQuest.usuario.UsuarioSimpleResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class UsuarioMapper {
    public static Usuario toEntity(UsuarioCreateRequestDto requestDto){
        if(requestDto == null) {
            return null;
        }
        Usuario usuario = new Usuario();
        usuario.setNome(requestDto.getNome());
        usuario.setSobrenome(requestDto.getSobrenome());
        usuario.setDataNascimento(requestDto.getDataNascimento());
        usuario.setCpf(requestDto.getCpf());
        usuario.setEmail(requestDto.getEmail());
        usuario.setSenha(requestDto.getSenha());
        return usuario;
    }

    public static UsuarioResponseDto toUsuarioResponseDto(Usuario entity) {
        if(entity == null) {
            return null;
        }
        UsuarioResponseDto usuario = new UsuarioResponseDto();
        usuario.setId(entity.getId());
        usuario.setNome(entity.getNome());
        usuario.setEmail(entity.getEmail());
        return usuario;
    }

    public static UsuarioSimpleResponse toUsuarioSimpleResponse(Usuario entity) {
        if(entity == null) {
            return null;
        }
        UsuarioSimpleResponse usuario = new UsuarioSimpleResponse();
        usuario.setId(entity.getId());
        usuario.setNome(entity.getNome());
        usuario.setEmail(entity.getEmail());
        return usuario;
    }

    public static UsuarioTokenDto of(Usuario usuario, String token) {
        UsuarioTokenDto usuarioTokenDto = new UsuarioTokenDto();
        usuarioTokenDto.setUserId(usuario.getId());
        usuarioTokenDto.setEmail(usuario.getEmail());
        usuarioTokenDto.setToken(token);
        return usuarioTokenDto;
    }
}

