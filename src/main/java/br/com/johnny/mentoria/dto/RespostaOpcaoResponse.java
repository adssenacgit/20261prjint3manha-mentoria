package br.com.johnny.mentoria.dto;

public record RespostaOpcaoResponse(
        Integer id,
        Integer clienteUsuarioId,
        Integer opcaoPerguntaId,
        Byte status
) {
}
