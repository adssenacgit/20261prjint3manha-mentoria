package br.com.johnny.mentoria.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record MentorRequest(
        @Size(max = 200) String descricao,
        Double precoHora,
        Double mediaAvaliacao,
        @NotNull Integer usuarioId,
        Byte onboardingConcluido,
        Byte status
) {
}
