package br.com.johnny.mentoria.dto;

public record RespostaTextoResponse(
        Integer id,
        Integer clienteUsuarioId,
        Integer perguntaCadastroId,
        String conteudo,
        Byte status
) {
}
