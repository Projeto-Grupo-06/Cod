package com.bitequest.BiteQuest.usuario;

import com.bitequest.BiteQuest.entity.Restaurante;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Data
public class UsuarioCreateRequestDto {

    @NotBlank(message = "O nome é obrigatório")
    private String nome;

    private String sobrenome;

    @PastOrPresent(message = "A data de nascimento deve estar no passado ou ser a data atual")
    private LocalDate dataNascimento;

    @CPF(message = "CPF inválido")
    private String cpf;

    @Email(message = "Email inválido")
    private String email;

    @NotBlank(message = "A senha é obrigatória")
    private String senha;

    public void setSenha(String senha) {
        Pattern pattern = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$");
        Matcher matcher = pattern.matcher(senha);
        if (matcher.matches()) {
            this.senha = senha;
        } else {
            throw new IllegalArgumentException("A senha deve conter no mínimo 8 caracteres, 1 caractere especial, 1 caractere numérico e 1 caractere maiúsculo.");
        }
    }
}

