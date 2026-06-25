package br.com.johnny.mentoria.dto;

public record ClienteResponse(
        Integer usuarioId,
        String stack,
        String descricao,
        Byte onboardingConcluido,
        Byte status
) {
}
