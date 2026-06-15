package br.com.johnny.mentoria.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;

public record UsuarioRequest(
        @Size(max = 45) String nome,
        @Email @Size(max = 45) String email,
        @Size(max = 45) String senha,
        Integer tipoUsuario,
        LocalDate dataCadastro,
        Byte status
) {
}
