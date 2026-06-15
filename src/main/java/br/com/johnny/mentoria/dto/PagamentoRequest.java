package br.com.johnny.mentoria.dto;

import jakarta.validation.constraints.NotNull;

public record PagamentoRequest(
        @NotNull Integer respostaPublicacaoId,
        @NotNull Integer metodoPagamentoId,
        Byte status
) {
}
