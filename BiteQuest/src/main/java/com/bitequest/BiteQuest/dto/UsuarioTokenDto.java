package com.bitequest.BiteQuest.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioTokenDto {
    private Long userId;
    private String email;
    private String token;
}
