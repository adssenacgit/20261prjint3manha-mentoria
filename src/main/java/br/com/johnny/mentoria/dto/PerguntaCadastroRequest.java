package br.com.johnny.mentoria.dto;

import br.com.johnny.mentoria.enums.PerguntaCadastroTipo;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record PerguntaCadastroRequest(
        @NotBlank @Size(max = 200) String enunciado,
        @NotNull PerguntaCadastroTipo tipo,
        Byte status
) {
}
