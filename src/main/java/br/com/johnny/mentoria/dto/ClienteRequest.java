package br.com.johnny.mentoria.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record ClienteRequest(
        @Size(max = 45) String stack,
        @Size(max = 200) String descricao,
        @NotNull Integer usuarioId,
        Byte onboardingConcluido,
        Byte status
) {
}
