package br.com.johnny.mentoria.dto;

import java.time.LocalDate;

public record UsuarioResponse(
        Integer id,
        String nome,
        String email,
        String senha,
        Integer tipoUsuario,
        LocalDate dataCadastro,
        Byte status
) {
}
