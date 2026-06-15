package br.com.johnny.mentoria.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record OpcaoPerguntaRequest(
        @NotNull Integer perguntaCadastroId,
        @NotBlank @Size(max = 100) String descricao,
        Byte status
) {
}
