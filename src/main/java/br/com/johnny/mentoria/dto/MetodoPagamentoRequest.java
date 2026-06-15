package br.com.johnny.mentoria.dto;

import jakarta.validation.constraints.Size;

public record MetodoPagamentoRequest(
        @Size(max = 45) String descricao,
        Byte status
) {
}
