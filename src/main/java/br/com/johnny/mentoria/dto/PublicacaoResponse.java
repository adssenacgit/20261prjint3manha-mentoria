package br.com.johnny.mentoria.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record PublicacaoResponse(
        Integer id,
        String titulo,
        String conteudo,
        BigDecimal orcamentoMin,
        BigDecimal orcamentoMax,
        LocalDateTime dataCriacao,
        Integer usuarioId,
        Byte status
) {
}
