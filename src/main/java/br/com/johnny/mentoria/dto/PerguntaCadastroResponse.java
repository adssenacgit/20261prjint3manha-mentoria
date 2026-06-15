package br.com.johnny.mentoria.dto;

import br.com.johnny.mentoria.enums.PerguntaCadastroTipo;

public record PerguntaCadastroResponse(
        Integer id,
        String enunciado,
        PerguntaCadastroTipo tipo,
        Byte status
) {
}
