package br.com.johnny.mentoria.dto;

import jakarta.validation.constraints.NotNull;

public record PublicacaoTecnologiaRequest(
        @NotNull Integer publicacaoId,
        @NotNull Integer tecnologiaId,
        Byte status
) {
}
