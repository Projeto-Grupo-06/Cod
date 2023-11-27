package com.example.bitequestusuario.controller.dto.mapper;

import com.example.bitequestusuario.controller.dto.UsuarioCreateRequestDto;
import com.example.bitequestusuario.controller.dto.UsuarioResponseDto;
import com.example.bitequestusuario.controller.dto.UsuarioSimpleResponse;
import com.example.bitequestusuario.entity.Usuario;

public class UsuarioMapper {

    public static Usuario toEntity(UsuarioCreateRequestDto dto) {
        Usuario usuario = new Usuario();
        usuario.setNome(dto.getNome());
        usuario.setSobrenome(dto.getSobrenome());
        usuario.setCpf(dto.getCpf());
        usuario.setEmail(dto.getEmail());
        usuario.setDataNascimento(dto.getDataNascimento());

        return usuario;
    }

    public static UsuarioResponseDto toUsuarioReponseDto(Usuario entity) {
        UsuarioResponseDto usuario = new UsuarioResponseDto();
        String nome = entity.getNome() + " " + entity.getSobrenome();
        usuario.setId(entity.getId());
        usuario.setNomeCompleto(nome);
        usuario.setDocumento(entity.getCpf());
        usuario.setContato(entity.getEmail());
        usuario.setDataNascimento(entity.getDataNascimento());
        usuario.setSenha(entity.getSenha());
        return usuario;
    }

    public static UsuarioSimpleResponse toUsuarioSimpleResponse(Usuario entity) {
        UsuarioSimpleResponse usuario = new UsuarioSimpleResponse();
        usuario.setId(entity.getId());
        String nome = entity.getNome() + " " + entity.getSobrenome();
        usuario.setNomeCompleto(nome);
        return usuario;
    }
}
