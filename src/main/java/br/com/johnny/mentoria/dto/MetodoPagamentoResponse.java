package br.com.johnny.mentoria.dto;

public record MetodoPagamentoResponse(
        Integer id,
        String descricao,
        Byte status
) {
}
