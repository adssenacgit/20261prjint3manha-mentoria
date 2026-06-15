package br.com.johnny.mentoria.dto;

import jakarta.validation.constraints.NotNull;

public record RespostaPublicacaoRequest(
        String conteudo,
        @NotNull Integer usuarioId,
        @NotNull Integer publicacaoId,
        Byte status
) {
}
