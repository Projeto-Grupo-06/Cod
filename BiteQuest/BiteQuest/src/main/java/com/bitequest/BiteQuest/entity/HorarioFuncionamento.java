package com.bitequest.BiteQuest.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.DayOfWeek;
import java.time.LocalTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HorarioFuncionamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "O dia da semana é obrigatório")
    private DayOfWeek diaSemana;

    @NotNull(message = "O horário de abertura é obrigatório")
    private LocalTime horarioAbertura;

    @NotNull(message = "O horário de fechamento é obrigatório")
    private LocalTime horarioFechamento;

    @ManyToOne
    @JoinColumn(name = "restaurante_id")
    private Restaurante restaurante;
}
