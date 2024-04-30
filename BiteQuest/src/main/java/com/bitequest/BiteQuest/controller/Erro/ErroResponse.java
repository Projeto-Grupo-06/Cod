package com.bitequest.BiteQuest.controller.Erro;

public class ErroResponse {
    private int status;
    private String mensagem;

    public ErroResponse(int status, String mensagem) {
        this.status = status;
        this.mensagem = mensagem;
    }

    // getters e setters
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}
