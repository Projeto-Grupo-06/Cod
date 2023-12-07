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

    @NotNull(message = "O horário de saída de segunda é obrigatório")
    private LocalTime saidaSegunda;

    @NotNull(message = "O horário de entrada de segunda é obrigatório")
    private LocalTime entradaSegunda;

    @NotNull(message = "O horário de saída de terça é obrigatório")
    private LocalTime saidaTerca;

    @NotNull(message = "O horário de entrada de terça é obrigatório")
    private LocalTime entradaTerca;

    @NotNull(message = "O horário de saída de quarta é obrigatório")
    private LocalTime saidaQuarta;

    @NotNull(message = "O horário de entrada de quarta é obrigatório")
    private LocalTime entradaQuarta;

    @NotNull(message = "O horário de saída de quinta é obrigatório")
    private LocalTime saidaQuinta;

    @NotNull(message = "O horário de entrada de quinta é obrigatório")
    private LocalTime entradaQuinta;

    @NotNull(message = "O horário de saída de sexta é obrigatório")
    private LocalTime saidaSexta;

    @NotNull(message = "O horário de entrada de sexta é obrigatório")
    private LocalTime entradaSexta;

    @NotNull(message = "O horário de saída de sábado é obrigatório")
    private LocalTime saidaSabado;

    @NotNull(message = "O horário de entrada de sábado é obrigatório")
    private LocalTime entradaSabado;

    @NotNull(message = "O horário de saída de domingo é obrigatório")
    private LocalTime saidaDomingo;

    @NotNull(message = "O horário de entrada de domingo é obrigatório")
    private LocalTime entradaDomingo;

    @ManyToOne
    @JoinColumn(name = "restaurante_id")
    private Restaurante restaurante;
}
