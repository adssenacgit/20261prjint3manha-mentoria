package br.com.johnny.mentoria.dto;

public record RespostaPublicacaoResponse(
        Integer id,
        String conteudo,
        Integer usuarioId,
        Integer publicacaoId,
        Byte status
) {
}
