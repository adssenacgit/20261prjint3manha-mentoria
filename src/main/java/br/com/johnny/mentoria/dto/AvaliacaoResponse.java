package br.com.johnny.mentoria.dto;

public record AvaliacaoResponse(
        Integer id,
        Integer clienteUsuarioId,
        Integer mentorUsuarioId,
        Double valor,
        String comentario,
        Integer publicacaoId,
        Byte status
) {
}
