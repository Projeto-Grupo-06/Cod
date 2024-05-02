package com.bitequest.BiteQuest.usuario;

public class ComentarioCreateRequestDto {

    private Long usuarioId;
    private Integer restauranteId;
    private String texto;

    public ComentarioCreateRequestDto() {
    }

    public ComentarioCreateRequestDto(Long usuarioId, Integer restauranteId, String texto) {
        this.usuarioId = usuarioId;
        this.restauranteId = restauranteId;
        this.texto = texto;
    }
    public String getTexto() {
        return this.texto;
    }
}
