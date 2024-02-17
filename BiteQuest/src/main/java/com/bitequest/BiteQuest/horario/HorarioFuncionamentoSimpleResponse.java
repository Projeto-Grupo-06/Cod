package com.bitequest.BiteQuest.horario;

import jakarta.validation.constraints.NotNull;

import java.time.LocalTime;

public class HorarioFuncionamentoSimpleResponse {

    private Integer id;

    @NotNull(message = "O horário de abertura é obrigatório")
    private LocalTime horarioAbertura;

    @NotNull(message = "O horário de fechamento é obrigatório")
    private LocalTime horarioFechamento;
}
