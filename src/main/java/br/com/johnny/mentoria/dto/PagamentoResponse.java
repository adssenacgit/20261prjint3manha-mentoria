package br.com.johnny.mentoria.dto;

public record PagamentoResponse(
        Integer id,
        Integer respostaPublicacaoId,
        Integer metodoPagamentoId,
        Byte status
) {
}
