package br.com.johnny.mentoria.dto;

import jakarta.validation.constraints.NotNull;

public record UsuarioTecnologiaRequest(
        @NotNull Integer usuarioId,
        @NotNull Integer tecnologiaId,
        Byte status
) {
}
