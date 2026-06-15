package br.com.johnny.mentoria.dto;

import jakarta.validation.constraints.NotNull;

public record RespostaOpcaoRequest(
        @NotNull Integer clienteUsuarioId,
        @NotNull Integer opcaoPerguntaId,
        Byte status
) {
}
