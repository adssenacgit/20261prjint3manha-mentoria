package br.com.johnny.mentoria.dto;

public record MentorResponse(
        Integer usuarioId,
        String descricao,
        Double precoHora,
        Double mediaAvaliacao,
        Byte status
) {
}
