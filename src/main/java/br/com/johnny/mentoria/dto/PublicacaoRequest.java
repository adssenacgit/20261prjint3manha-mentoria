package br.com.johnny.mentoria.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public record PublicacaoRequest(
        @NotBlank @Size(max = 255) String titulo,
        String conteudo,
        BigDecimal orcamentoMin,
        BigDecimal orcamentoMax,
        LocalDateTime dataCriacao,
        @NotNull Integer usuarioId,
        Byte status
) {
}
