package br.com.johnny.mentoria.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RespostaTextoRequest(
        @NotNull Integer clienteUsuarioId,
        @NotNull Integer perguntaCadastroId,
        @NotBlank String conteudo,
        Byte status
) {
}
