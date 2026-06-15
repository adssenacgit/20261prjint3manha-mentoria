package br.com.johnny.mentoria.dto;

public record PublicacaoTecnologiaResponse(
        Integer publicacaoId,
        Integer tecnologiaId,
        Byte status
) {
}
