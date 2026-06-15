package br.com.johnny.mentoria.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record AvaliacaoRequest(
        @NotNull Integer clienteUsuarioId,
        @NotNull Integer mentorUsuarioId,
        Double valor,
        @Size(max = 200) String comentario,
        @NotNull Integer publicacaoId,
        Byte status
) {
}
